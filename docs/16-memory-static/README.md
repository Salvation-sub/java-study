# Java 메모리 구조와 static 학습 가이드

## 목차
1. [자바 메모리 구조](#자바-메모리-구조)
2. [스택과 큐 자료 구조](#스택과-큐-자료-구조)
3. [스택 영역](#스택-영역)
4. [스택 영역과 힙 영역](#스택-영역과-힙-영역)
5. [static 변수](#static-변수)
6. [static 메서드](#static-메서드)
7. [문제와 풀이](#문제와-풀이)

---

## 자바 메모리 구조

자바의 메모리 구조는 크게 **3개 영역**으로 나뉩니다:

### 메모리 영역 구분
- **메서드 영역**: 클래스 정보를 보관 (붕어빵 틀)
- **스택 영역**: 실제 프로그램이 실행되는 영역, 메서드 호출 시마다 쌓임
- **힙 영역**: 객체(인스턴스)가 생성되는 영역, `new` 명령어 사용 시 생성

### 메서드 영역 (Method Area)
프로그램 실행에 필요한 공통 데이터를 관리하며, 모든 영역에서 공유됩니다.

**포함 요소:**
- **클래스 정보**: 실행 코드(바이트 코드), 필드, 메서드, 생성자 코드
- **static 영역**: static 변수들을 보관
- **런타임 상수 풀**: 공통 리터럴 상수 보관 (예: "hello" 문자열)

### 스택 영역 (Stack Area)
각 스택 프레임은 지역 변수, 중간 연산 결과, 메서드 호출 정보를 포함합니다.

**특징:**
- **스택 프레임**: 메서드 호출 시마다 생성, 종료 시 제거
- **지역 변수**: 스택 프레임 내에서 관리
- **쓰레드별 생성**: 각 쓰레드마다 하나의 실행 스택 생성

### 힙 영역 (Heap Area)
객체(인스턴스)와 배열이 생성되는 영역입니다.

**특징:**
- **가비지 컬렉션(GC)**: 참조되지 않는 객체를 자동으로 제거
- **동적 할당**: 런타임에 객체 크기 결정

---

## 스택과 큐 자료 구조

### 스택 (Stack) - LIFO (Last In First Out)
- **후입 선출**: 나중에 넣은 것이 먼저 나옴
- **예시**: 1→2→3 순서로 넣으면, 3→2→1 순서로 나옴

### 큐 (Queue) - FIFO (First In First Out)
- **선입 선출**: 먼저 넣은 것이 먼저 나옴
- **예시**: 1→2→3 순서로 넣으면, 1→2→3 순서로 나옴

---

## 스택 영역

### 메서드 호출과 스택 프레임

```java
public class JavaMemoryMain1 {
    public static void main(String[] args) {
        System.out.println("main start");
        method1(10);
        System.out.println("main end");
    }
    
    static void method1(int m1) {
        System.out.println("method1 start");
        int cal = m1 * 2;
        method2(cal);
        System.out.println("method1 end");
    }
    
    static void method2(int m2) {
        System.out.println("method2 start");
        System.out.println("method2 end");
    }
}
```

**실행 순서:**
1. `main()` 스택 프레임 생성
2. `method1()` 스택 프레임 생성 (지역 변수: m1, cal)
3. `method2()` 스택 프레임 생성 (지역 변수: m2)
4. `method2()` 종료 → 스택 프레임 제거
5. `method1()` 종료 → 스택 프레임 제거
6. `main()` 종료 → 프로그램 종료

### 정리
- 자바는 스택 영역을 사용해서 메서드 호출과 지역 변수를 관리
- 메서드 호출 시 스택 프레임이 쌓이고, 종료 시 제거
- 스택 프레임이 모두 제거되면 프로그램 종료

---

## 스택 영역과 힙 영역

### 예제: Data 클래스와 메모리 사용

```java
public class Data {
    private int value;
    
    public Data(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
```

### 메모리 할당 과정
1. **스택 영역**: 지역 변수 `data1`에 참조값 저장
2. **힙 영역**: `new Data(10)`으로 Data 인스턴스 생성
3. **참조 관계**: 스택의 변수가 힙의 객체를 참조

### 가비지 컬렉션 (GC)
- 힙 영역의 객체가 더 이상 참조되지 않으면 GC 대상
- 메모리를 자동으로 정리하여 메모리 누수 방지

---

## static 변수

### static이 필요한 이유

**문제 상황**: 객체 생성 개수를 세고 싶을 때
- 인스턴스 변수 사용 시: 각 객체마다 별도의 카운트 보관
- 외부 객체 사용 시: 코드가 복잡해짐

### static 변수 해결책

```java
public class Data3 {
    public String name;
    public static int count; // static 변수
    
    public Data3(String name) {
        this.name = name;
        count++;
    }
}
```

### static 변수 특징
- **메서드 영역에 저장**: 힙 영역이 아닌 메서드 영역의 static 영역에 보관
- **클래스 레벨 공유**: 모든 인스턴스가 같은 변수를 공유
- **클래스명으로 접근**: `Data3.count`로 접근 (권장)

### 변수의 종류와 생명주기

| 변수 종류 | 저장 위치 | 생명주기 | 특징 |
|-----------|-----------|----------|------|
| **지역 변수** | 스택 영역 | 메서드 실행 동안 | 가장 짧음 |
| **인스턴스 변수** | 힙 영역 | GC 전까지 | 중간 |
| **클래스 변수(static)** | 메서드 영역 | 프로그램 시작~종료 | 가장 김 |

### static 변수 접근 방법
```java
// 권장: 클래스를 통한 접근
Data3.count

// 비권장: 인스턴스를 통한 접근 (오해 소지)
data3.count
```

---

## static 메서드

### static 메서드의 장점

```java
// 일반 메서드 - 인스턴스 생성 필요
DecoUtil1 utils = new DecoUtil1();
String result = utils.deco("hello");

// static 메서드 - 인스턴스 생성 불필요
String result = DecoUtil2.deco("hello");
```

### static 메서드 사용 규칙

**✅ 사용 가능:**
- static 변수
- static 메서드
- 지역 변수

**❌ 사용 불가:**
- 인스턴스 변수
- 인스턴스 메서드

```java
public class DecoData {
    private int instanceValue;
    private static int staticValue;
    
    public static void staticCall() {
        // instanceValue++; // 컴파일 오류!
        // instanceMethod(); // 컴파일 오류!
        
        staticValue++; // OK
        staticMethod(); // OK
    }
    
    public void instanceCall() {
        instanceValue++; // OK
        instanceMethod(); // OK
        staticValue++; // OK
        staticMethod(); // OK
    }
}
```

### static 메서드 활용
- **유틸리티 메서드**: 객체 상태와 무관한 기능
- **수학 함수**: Math.max(), Math.min() 등
- **팩토리 메서드**: 객체 생성을 담당하는 메서드

### static import 활용
```java
// 기본 사용
DecoUtil.staticMethod();
DecoUtil.staticMethod();

// static import 적용
import static 패키지.DecoUtil.*;

staticMethod();
staticMethod();
```

### main() 메서드도 static
```java
public static void main(String[] args) {
    // main은 static이므로 객체 생성 없이 실행 가능
    // 따라서 main에서 호출하는 메서드들도 static이어야 함
}
```

---

## 문제와 풀이

### 문제 1: 구매한 자동차 수

**요구사항**: 생성된 Car 객체의 수를 추적하는 프로그램

```java
public class Car {
    private static int totalCars;
    private String name;
    
    public Car(String name) {
        System.out.println("차량 구입, 이름: " + name);
        this.name = name;
        totalCars++;
    }
    
    public static void showTotalCars() {
        System.out.println("구매한 차량 수: " + totalCars);
    }
}
```

### 문제 2: 수학 유틸리티 클래스

**요구사항**: 배열 관련 수학 계산을 제공하는 유틸리티 클래스

```java
public class MathArrayUtils {
    private MathArrayUtils() {
        // private 생성자로 인스턴스 생성 방지
    }
    
    public static int sum(int[] values) {
        int total = 0;
        for (int value : values) {
            total += value;
        }
        return total;
    }
    
    public static double average(int[] values) {
        return (double) sum(values) / values.length;
    }
    
    public static int min(int[] values) {
        int minValue = values[0];
        for (int value : values) {
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }
    
    public static int max(int[] values) {
        int maxValue = values[0];
        for (int value : values) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
```

---

## 핵심 정리

### static의 핵심 개념
1. **클래스 레벨**: 인스턴스와 무관하게 클래스 자체에 속함
2. **메서드 영역 저장**: 프로그램 시작부터 종료까지 생존
3. **공유 자원**: 모든 인스턴스가 같은 변수/메서드를 공유

### 언제 static을 사용할까?
- **유틸리티 메서드**: 객체 상태와 무관한 기능
- **상수 정의**: 모든 곳에서 사용하는 공통 상수
- **팩토리 메서드**: 객체 생성을 담당하는 메서드
- **카운터 변수**: 전체 인스턴스 개수 추적

### 주의사항
- static 메서드에서는 인스턴스 멤버에 직접 접근 불가
- static 변수는 메모리에 계속 남아있으므로 남용 주의
- 멀티스레드 환경에서는 동시성 문제 고려 필요