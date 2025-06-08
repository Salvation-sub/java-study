# Java 스코프와 형변환 학습 가이드

## 목차
- [스코프 (Scope)](#스코프-scope)
    - [지역 변수와 스코프](#지역-변수와-스코프)
    - [스코프 존재 이유](#스코프-존재-이유)
    - [while vs for - 스코프 관점](#while-vs-for---스코프-관점)
- [형변환 (Type Casting)](#형변환-type-casting)
    - [자동 형변환](#자동-형변환)
    - [명시적 형변환](#명시적-형변환)
    - [계산과 형변환](#계산과-형변환)
- [정리](#정리)

---

## 스코프 (Scope)

### 지역 변수와 스코프

변수는 선언한 위치에 따라 분류됩니다:
- **지역 변수 (Local Variable)**: 특정 지역(코드 블록 `{}`)에서만 사용할 수 있는 변수
- **멤버 변수**: 클래스 변수, 인스턴스 변수 (추후 학습)

**지역 변수의 특징:**
- 자신이 선언된 코드 블록(`{}`) 안에서만 생존
- 코드 블록을 벗어나면 제거되어 접근 불가

### 기본 스코프 예제

```java
package scope;

public class Scope1 {
    public static void main(String[] args) {
        int m = 10; // m 생존 시작
        
        if (true) {
            int x = 20; // x 생존 시작
            System.out.println("if m = " + m); // 블록 내부에서 외부 접근 가능
            System.out.println("if x = " + x);
        } // x 생존 종료
        
        // System.out.println("main x = " + x); // 오류! x에 접근 불가
        System.out.println("main m = " + m);
    } // m 생존 종료
}
```

**스코프 설명:**
- `int m`: `main{}` 전체에서 접근 가능 (넓은 스코프)
- `int x`: `if{}` 블록 내에서만 접근 가능 (좁은 스코프)

### for문에서의 스코프

```java
package scope;

public class Scope2 {
    public static void main(String[] args) {
        int m = 10;
        
        for (int i = 0; i < 2; i++) { // for문 내에서 변수 선언
            System.out.println("for m = " + m); // 외부 변수 접근 가능
            System.out.println("for i = " + i);
        } // i 생존 종료
        
        // System.out.println("main i = " + i); // 오류! i에 접근 불가
        System.out.println("main m = " + m);
    }
}
```

for문에서 `for(int i=0;...)` 과 같이 선언된 변수는 for문 코드 블록 안에서만 사용할 수 있습니다.

---

## 스코프 존재 이유

### 문제가 있는 코드 예제

```java
package scope;

public class Scope3_1 {
    public static void main(String[] args) {
        int m = 10;
        int temp = 0; // main 블록에 선언 (문제!)
        
        if (m > 0) {
            temp = m * 2;
            System.out.println("temp = " + temp);
        }
        System.out.println("m = " + m);
    }
}
```

**문제점:**
1. **비효율적인 메모리 사용**: `temp`는 if 블록에서만 필요하지만 main 블록 전체에서 메모리 점유
2. **코드 복잡성 증가**: if 블록이 끝나도 `temp`를 계속 신경써야 함

### 개선된 코드

```java
package scope;

public class Scope3_2 {
    public static void main(String[] args) {
        int m = 10;
        
        if (m > 0) {
            int temp = m * 2; // if 블록 내에서 선언
            System.out.println("temp = " + temp);
        }
        System.out.println("m = " + m);
    }
}
```

**개선점:**
- `temp`의 스코프를 필요한 곳으로 한정
- 메모리 효율성 향상
- 코드 유지보수성 향상

---

## while vs for - 스코프 관점

### while문 (넓은 스코프)

```java
package loop;

public class While2_3 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;        // main 메서드 전체에서 접근 가능
        int endNum = 3;
        
        while (i <= endNum) {
            sum = sum + i;
            System.out.println("i=" + i + " sum=" + sum);
            i++;
        }
        // i는 여전히 접근 가능
    }
}
```

### for문 (제한된 스코프)

```java
package loop;

public class For2 {
    public static void main(String[] args) {
        int sum = 0;
        int endNum = 3;
        
        for (int i = 1; i <= endNum; i++) { // i는 for문 안에서만 사용
            sum = sum + i;
            System.out.println("i=" + i + " sum=" + sum);
        }
        // i는 여기서 접근 불가
    }
}
```

**결론:** for문에서만 사용되는 카운터 변수가 있다면 **for문이 스코프 관점에서 더 좋습니다.**

---

## 형변환 (Type Casting)

### 자바 숫자 타입의 범위

```
int < long < double
```

- 작은 범위에서 큰 범위: 허용 (안전)
- 큰 범위에서 작은 범위: 위험 (데이터 손실 가능)

### 자동 형변환 (묵시적 형변환)

작은 범위에서 큰 범위로의 대입은 자동으로 형변환됩니다.

```java
package casting;

public class Casting1 {
    public static void main(String[] args) {
        int intValue = 10;
        long longValue;
        double doubleValue;
        
        longValue = intValue;        // int → long (자동 형변환)
        System.out.println("longValue = " + longValue);     // 10
        
        doubleValue = intValue;      // int → double (자동 형변환)
        System.out.println("doubleValue1 = " + doubleValue); // 10.0
        
        doubleValue = 20L;           // long → double (자동 형변환)
        System.out.println("doubleValue2 = " + doubleValue); // 20.0
    }
}
```

**실행 결과:**
```
longValue = 10
doubleValue1 = 10.0
doubleValue2 = 20.0
```

**자동 형변환 과정:**
```java
// 개념적 처리 과정
doubleValue = intValue;
doubleValue = (double) intValue;  // 자동 형변환
doubleValue = (double) 10;
doubleValue = 10.0;
```

---

## 명시적 형변환

큰 범위에서 작은 범위로의 대입은 명시적 형변환이 필요합니다.

### 기본 예제

```java
package casting;

public class Casting2 {
    public static void main(String[] args) {
        double doubleValue = 1.5;
        int intValue = 0;
        
        // intValue = doubleValue;        // 컴파일 오류!
        intValue = (int) doubleValue;     // 명시적 형변환 필요
        System.out.println(intValue);     // 출력: 1 (소수점 버림)
    }
}
```

**형변환 과정:**
```java
intValue = (int) doubleValue;
intValue = (int) 1.5;
intValue = 1;  // 소수점 부분 버림
```

### 오버플로우 문제

```java
package casting;

public class Casting3 {
    public static void main(String[] args) {
        long maxIntValue = 2147483647;  // int 최대값
        long maxIntOver = 2147483648L;  // int 최대값 + 1
        int intValue = 0;
        
        intValue = (int) maxIntValue;   // 정상 변환
        System.out.println("maxIntValue casting=" + intValue); // 2147483647
        
        intValue = (int) maxIntOver;    // 오버플로우 발생!
        System.out.println("maxIntOver casting=" + intValue);  // -2147483648
    }
}
```

**오버플로우 현상:**
- int 범위를 초과하는 값은 전혀 다른 숫자로 변환됨
- 마치 시계가 한바퀴 돈 것처럼 다시 처음부터 시작
- **오버플로우 자체를 방지해야 함!**

---

## 계산과 형변환

### 계산 규칙

1. **같은 타입끼리 계산 → 같은 타입 결과**
    - `int + int = int`
    - `double + double = double`

2. **다른 타입끼리 계산 → 큰 범위로 자동 형변환**
    - `int + long = long + long = long`
    - `int + double = double + double = double`

### 실제 예제

```java
package casting;

public class Casting4 {
    public static void main(String[] args) {
        int div1 = 3 / 2;                    // int / int = int
        System.out.println("div1 = " + div1); // 1
        
        double div2 = 3 / 2;                 // int / int = int, 그 후 double로 변환
        System.out.println("div2 = " + div2); // 1.0
        
        double div3 = 3.0 / 2;               // double / int → double / double
        System.out.println("div3 = " + div3); // 1.5
        
        double div4 = (double) 3 / 2;        // 명시적 형변환
        System.out.println("div4 = " + div4); // 1.5
        
        int a = 3;
        int b = 2;
        double result = (double) a / b;       // 변수에서 명시적 형변환
        System.out.println("result = " + result); // 1.5
    }
}
```

### 상세 분석

**div1: int / int**
```java
int div1 = 3 / 2;    // int / int이므로 int 결과
int div1 = 1;        // 소수점 버림
```

**div2: int / int → double 대입**
```java
double div2 = 3 / 2;          // int / int = int (1)
double div2 = (double) 1;     // 자동 형변환
double div2 = 1.0;
```

**div3: double / int**
```java
double div3 = 3.0 / 2;                // double / int
double div3 = 3.0 / (double) 2;       // 자동 형변환
double div3 = 3.0 / 2.0;              // double / double
double div3 = 1.5;
```

**div4: 명시적 형변환**
```java
double div4 = (double) 3 / 2;         // 명시적 형변환
double div4 = (double) 3 / (double) 2; // 자동 형변환
double div4 = 3.0 / 2.0;
double div4 = 1.5;
```

---

## 정리

### 스코프 핵심 원칙

1. **변수는 꼭 필요한 범위로 한정**하여 사용
2. **메모리 효율성**과 **코드 유지보수성** 향상
3. **좋은 프로그램 = 적절한 제약이 있는 프로그램**

### 형변환 핵심 규칙

#### 자동 형변환 (작은 → 큰 범위)
```
int → long → double
```
- 데이터 손실 없음
- 자동으로 처리됨

#### 명시적 형변환 (큰 → 작은 범위)
```java
int intValue = (int) doubleValue;  // 명시적 형변환 필요
```
- 데이터 손실 가능 (소수점 버림, 오버플로우)
- 개발자가 명시적으로 처리

#### 계산에서의 형변환
1. **같은 타입 = 같은 결과**
2. **다른 타입 = 큰 범위로 자동 형변환**

### 실무 가이드

#### 스코프 Best Practice
```java
// ❌ 나쁜 예: 넓은 스코프
int temp = 0;
if (condition) {
    temp = calculate();
    // temp 사용
}
// temp가 계속 살아있음

// ✅ 좋은 예: 제한된 스코프
if (condition) {
    int temp = calculate();
    // temp 사용
}
// temp가 자동으로 제거됨
```

#### 형변환 Best Practice
```java
// ❌ 정수 나눗셈으로 소수점 손실
double result = 3 / 2;  // 1.0

// ✅ 명시적 형변환으로 정확한 계산
double result = (double) 3 / 2;  // 1.5

// ✅ 또는 실수 리터럴 사용
double result = 3.0 / 2;  // 1.5
```

#### 오버플로우 방지
```java
// ❌ 오버플로우 위험
int bigNumber = 2147483647;
int overflow = (int) (bigNumber + 1L);  // 오버플로우!

// ✅ 적절한 타입 사용
long bigNumber = 2147483647;
long safe = bigNumber + 1;  // 안전
```

---

## 🎯 핵심 포인트

1. **스코프는 최소한으로** - 변수를 꼭 필요한 곳에서만 선언
2. **자동 형변환 활용** - 작은 타입에서 큰 타입으로는 안전
3. **명시적 형변환 주의** - 데이터 손실과 오버플로우 고려
4. **계산 시 타입 고려** - 정확한 결과를 위해 적절한 형변환 사용
5. **for문 활용** - 카운터 변수의 스코프를 제한하여 더 깔끔한 코드 작성