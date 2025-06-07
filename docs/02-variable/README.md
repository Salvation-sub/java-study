# Java 변수

## 📋 목차
- [변수 시작](#변수-시작)
- [변수 값 변경](#변수-값-변경)
- [변수 선언과 초기화](#변수-선언과-초기화)
- [변수 타입1](#변수-타입1)
- [변수 타입2](#변수-타입2)
- [변수 명명 규칙](#변수-명명-규칙)
- [문제와 풀이](#문제와-풀이)

## 🚀 변수 시작

### 변수가 필요한 이유

다음 코드를 보면서 변수의 필요성을 이해해봅시다.

```java
package variable;

public class Var1 {
    public static void main(String[] args) {
        System.out.println(10);
        System.out.println(10);
        System.out.println(10);
    }
}
```

**문제점**: 숫자 10을 20으로 변경하려면 3번의 코드를 모두 수정해야 합니다. 만약 100개라면 100번 수정해야 합니다!

### 변수 사용 예제

```java
package variable;

public class Var2 {
    public static void main(String[] args) {
        int a;        // 변수 선언
        a = 10;       // 변수 초기화
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);
    }
}
```

**장점**: `a`의 값만 변경하면 모든 출력이 함께 변경됩니다!

### 패키지(Package)

```java
package variable;
```

- 자바 파일을 구분하기 위한 **폴더** 개념
- 해당 패키지에 속한 자바 파일 첫 줄에 패키지 선언 필수
- 자바 파일 위치와 package 선언이 일치해야 함

## 🔄 변수 값 변경

변수는 이름 그대로 **변할 수 있는** 값입니다.

```java
package variable;

public class Var3 {
    public static void main(String[] args) {
        int a;                    // 변수 선언
        a = 10;                   // 변수 초기화: a(10)
        System.out.println(a);    // 10 출력
        
        a = 50;                   // 변수 값 변경: a(10 -> 50)
        System.out.println(a);    // 50 출력
    }
}
```

**실행 결과:**
```
10
50
```

### 변수의 핵심 개념

1. **변수 선언**: `int a` - 정수를 보관할 수 있는 메모리 공간 생성
2. **변수 초기화**: `a = 10` - 처음으로 값을 저장
3. **변수 값 읽기**: `System.out.println(a)` - 변수에 저장된 값 사용
4. **변수 값 변경**: `a = 50` - 기존 값을 새로운 값으로 교체

> **참고**: 자바에서 `=`는 수학의 '같다'가 아니라 '오른쪽 값을 왼쪽에 저장'을 의미합니다.

## 🎯 변수 선언과 초기화

### 변수 선언 방법

```java
// 1. 하나씩 선언
int a;
int b;

// 2. 한번에 여러 변수 선언
int c, d;
```

### 변수 초기화 방법

```java
package variable;

public class Var5 {
    public static void main(String[] args) {
        // 1. 선언과 초기화 분리
        int a;
        a = 1;
        System.out.println(a);
        
        // 2. 선언과 초기화 동시에
        int b = 2;
        System.out.println(b);
        
        // 3. 여러 변수 선언과 초기화 동시에
        int c = 3, d = 4;
        System.out.println(c);
        System.out.println(d);
    }
}
```

### ⚠️ 변수는 초기화 필수!

```java
package variable;

public class Var6 {
    public static void main(String[] args) {
        int a;
        // System.out.println(a); // 컴파일 에러 발생!
    }
}
```

**에러 메시지:**
```
java: variable a might not have been initialized
```

**이유**: 메모리는 여러 시스템이 공유하므로 어떤 값이 들어있는지 모름. 안전을 위해 자바는 초기화를 강제함.

## 📊 변수 타입1

자바는 데이터 종류에 따라 다양한 변수 타입을 제공합니다.

### 기본 타입 예제

```java
package variable;

public class Var7 {
    public static void main(String[] args) {
        int a = 100;              // 정수
        double b = 10.5;          // 실수
        boolean c = true;         // 불리언 (true, false)
        char d = 'A';             // 문자 하나
        String e = "Hello Java";  // 문자열
        
        System.out.println(a);    // 100
        System.out.println(b);    // 10.5
        System.out.println(c);    // true
        System.out.println(d);    // A
        System.out.println(e);    // Hello Java
    }
}
```

### 타입별 특징

| 타입 | 설명 | 예시 |
|------|------|------|
| `int` | 정수 | `1`, `100`, `1000` |
| `double` | 실수 | `0.2`, `1.5`, `100.121` |
| `boolean` | 불리언 | `true`, `false` |
| `char` | 문자 하나 | `'A'`, `'가'` (작은따옴표) |
| `String` | 문자열 | `"hello java"` (큰따옴표) |

### 리터럴(Literal)

코드에서 개발자가 직접 적은 고정된 값을 **리터럴**이라고 합니다.

```java
int a = 100;              // 100이 정수 리터럴
double b = 10.5;          // 10.5가 실수 리터럴
boolean c = true;         // true가 불리언 리터럴
char d = 'A';             // 'A'가 문자 리터럴
String e = "Hello Java";  // "Hello Java"가 문자열 리터럴
```

## 🔢 변수 타입2

### 숫자 타입 상세

```java
package variable;

public class Var8 {
    public static void main(String[] args) {
        // 정수형
        byte b = 127;                    // -128 ~ 127
        short s = 32767;                 // -32,768 ~ 32,767
        int i = 2147483647;              // 약 -20억 ~ 20억
        long l = 9223372036854775807L;   // 매우 큰 범위
        
        // 실수형
        float f = 10.0f;
        double d = 10.0;
    }
}
```

### 메모리 크기와 범위

#### 정수형
- **byte**: 1byte, -128 ~ 127
- **short**: 2byte, -32,768 ~ 32,767
- **int**: 4byte, 약 -20억 ~ 20억 ⭐️ **주로 사용**
- **long**: 8byte, 매우 큰 범위

#### 실수형
- **float**: 4byte, 7자리 정밀도
- **double**: 8byte, 15자리 정밀도 ⭐️ **주로 사용**

#### 기타
- **boolean**: 1byte, `true`, `false`
- **char**: 2byte, 문자 하나
- **String**: 가변, 문자열 ⭐️ **주로 사용**

### 리터럴 타입 지정

```java
// 정수 리터럴 (기본: int)
int i = 100;
long l = 10000000000L;  // L을 붙여 long 타입 지정

// 실수 리터럴 (기본: double)
double d = 10.0;
float f = 10.0f;        // f를 붙여 float 타입 지정
```

### 💡 실무에서 자주 사용하는 타입

- **정수**: `int`, `long`
- **실수**: `double`
- **불린**: `boolean`
- **문자열**: `String`

> **참고**: `byte`, `short`, `float`, `char`는 특별한 경우가 아니면 잘 사용하지 않습니다.

## 📝 변수 명명 규칙

### 규칙 (필수 - 지키지 않으면 컴파일 에러)

1. **숫자로 시작 불가**: `1num` ❌, `num1` ✅
2. **공백 사용 불가**: `my var` ❌, `myVar` ✅
3. **예약어 사용 불가**: `int`, `class`, `public` ❌
4. **사용 가능 문자**: 영문자(a-z, A-Z), 숫자(0-9), 달러($), 밑줄(_)

### 관례 (권장 - 전 세계 개발자가 따르는 암묵적 규칙)

#### 소문자로 시작하는 낙타 표기법 (Camel Case)
```java
// 좋은 예
int orderDetail;
String userAccount;
boolean isValid;

// 나쁜 예
int a, b;           // 용도가 불분명
String orderdetail; // 단어 구분이 어려움
```

#### 자바 언어 관례 정리
- **클래스**: 대문자로 시작 (`Person`, `OrderDetail`)
- **변수, 메서드**: 소문자로 시작 (`firstName`, `userAccount`)
- **상수**: 모두 대문자 + 언더바 (`USER_LIMIT`)
- **패키지**: 모두 소문자 (`org.spring.boot`)

### 낙타표기법(Camel Case)이란?

여러 단어의 첫 글자를 대문자로 만들어 낙타의 등봉처럼 보이게 하는 표기법

```java
orderDetail  // order + Detail
userName     // user + Name
maxScore     // max + Score
```

## 🧩 문제와 풀이

### 문제 1
다음 코드에서 반복되는 숫자 4, 3을 변수 `num1`, `num2`를 사용하도록 변경하세요.

```java
package variable.ex;

public class VarEx1Question {
    public static void main(String[] args) {
        System.out.println(4 + 3);
        System.out.println(4 - 3);
        System.out.println(4 * 3);
    }
}
```

<details>
<summary>정답 보기</summary>

```java
package variable.ex;

public class VarEx1 {
    public static void main(String[] args) {
        int num1 = 4;
        int num2 = 3;
        
        System.out.println(num1 + num2);  // 7
        System.out.println(num1 - num2);  // 1
        System.out.println(num1 * num2);  // 12
    }
}
```

</details>

### 문제 2
다음 작업을 수행하는 프로그램을 작성하세요.

1. 변수 `num1`을 선언하고, 10을 할당
2. 변수 `num2`를 선언하고, 20을 할당
3. 두 변수의 합을 구해서 변수 `sum`에 저장
4. `sum` 변수의 값을 출력

<details>
<summary>정답 보기</summary>

```java
package variable.ex;

public class VarEx2 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        int sum = num1 + num2;
        System.out.println(sum);  // 30
    }
}
```

</details>

### 문제 3
`long`과 `boolean` 타입을 사용하는 프로그램을 작성하세요.

1. `long` 타입 변수를 선언하고 10000000000(백억)으로 초기화
2. `boolean` 타입 변수를 선언하고 `true`로 초기화
3. 두 변수의 값을 출력

<details>
<summary>정답 보기</summary>

```java
package variable.ex;

public class VarEx3 {
    public static void main(String[] args) {
        long longVar = 10000000000L;  // L을 반드시 붙여야 함
        System.out.println(longVar);  // 10000000000
        
        boolean booleanVar = true;
        System.out.println(booleanVar);  // true
    }
}
```

</details>

## 🎯 핵심 정리

### 변수의 3요소
1. **변수 선언**: 메모리 공간 확보
2. **변수 초기화**: 처음 값 저장 (필수!)
3. **변수 사용**: 값 읽기/쓰기

### 기억할 점
- **변수는 반드시 초기화** 후 사용
- **타입에 맞는 값** 저장
- **의미있는 변수명** 사용
- **낙타표기법** 준수

### 자주 사용하는 타입
- `int` (정수), `double` (실수), `boolean` (참/거짓), `String` (문자열)

---
