# Java 메서드 완전 가이드

## 목차
1. [메서드 시작 - 코드 중복 문제](#메서드-시작---코드-중복-문제)
2. [수학 함수 개념과 메서드](#수학-함수-개념과-메서드)
3. [메서드 기본 구조](#메서드-기본-구조)
4. [메서드 호출과 실행 과정](#메서드-호출과-실행-과정)
5. [반환 타입과 return 문](#반환-타입과-return-문)
6. [매개변수가 없거나 반환 타입이 없는 경우](#매개변수가-없거나-반환-타입이-없는-경우)
7. [값 전달 방식 - 복사의 원리](#값-전달-방식---복사의-원리)
8. [메서드와 형변환](#메서드와-형변환)
9. [메서드 오버로딩](#메서드-오버로딩)
10. [메서드 사용의 장점](#메서드-사용의-장점)

---

## 메서드 시작 - 코드 중복 문제

### 문제 상황
```java
// 중복 코드 예시
public class Method1 {
    public static void main(String[] args) {
        // 계산1
        int a = 1;
        int b = 2;
        System.out.println(a + "+" + b + " 연산 수행");
        int sum1 = a + b;
        System.out.println("결과1 출력:" + sum1);
        
        // 계산2 - 거의 동일한 코드 반복
        int x = 10;
        int y = 20;
        System.out.println(x + "+" + y + " 연산 수행");
        int sum2 = x + y;
        System.out.println("결과2 출력:" + sum2);
    }
}
```

### 코드 중복의 문제점
- 같은 코드를 여러 번 작성해야 함
- 기능 변경 시 모든 중복 코드를 찾아서 수정해야 함
- 실수로 일부만 수정하면 일관성 문제 발생

---

## 수학 함수 개념과 메서드

### 함수의 이해
```
입력 1, 2 → [add 함수: a + b] → 출력 3
```

**함수의 특징:**
- 입력값을 받아 특정 연산을 수행
- 결과값을 출력
- 블랙박스 개념 - 내부 구현을 몰라도 사용 가능
- 한 번 정의하면 계속 재사용 가능

### 메서드로 해결
```java
public class Method1Ref {
    public static void main(String[] args) {
        int sum1 = add(5, 10);
        System.out.println("결과1 출력:" + sum1);
        
        int sum2 = add(15, 20);
        System.out.println("결과2 출력:" + sum2);
    }
    
    // add 메서드 정의
    public static int add(int a, int b) {
        System.out.println(a + "+" + b + " 연산 수행");
        int sum = a + b;
        return sum;
    }
}
```

---

## 메서드 기본 구조

### 메서드 구성 요소

```java
제어자 반환타입 메서드이름(매개변수 목록) {
    메서드 본문
}
```

### 상세 분석
```java
public static int add(int a, int b) {
    System.out.println(a + "+" + b + " 연산 수행");
    int sum = a + b;
    return sum;
}
```

**1. 메서드 선언 (Method Declaration)**
- `public static`: 제어자
    - `public`: 다른 클래스에서 호출 가능
    - `static`: 객체 생성 없이 호출 가능
- `int`: 반환 타입
- `add`: 메서드 이름
- `(int a, int b)`: 매개변수 목록

**2. 메서드 본문 (Method Body)**
- 실제 수행할 코드가 위치
- `return` 문으로 결과 반환

---

## 메서드 호출과 실행 과정

### 호출 과정 상세 분석
```java
int sum1 = add(5, 10);
```

**실행 단계:**
1. `add(5, 10)` 호출
2. 매개변수에 값 복사: `a=5, b=10`
3. 메서드 본문 실행
4. `return sum;` 실행 (sum=15)
5. 호출한 위치로 값 15 반환
6. `sum1 = 15;` 완료

### 메서드 호출과 용어 정리
```java
call("hello", 20);  // "hello", 20은 인수(Argument)

int call(String str, int age) {  // str, age는 매개변수(Parameter)
    // 메서드 본문
}
```

**용어 구분:**
- **인수(Argument)**: 메서드 호출 시 전달하는 실제 값
- **매개변수(Parameter)**: 메서드 정의 시 선언하는 변수

---

## 반환 타입과 return 문

### return 문의 동작
```java
public static boolean odd(int i) {
    if (i % 2 == 1) {
        return true;  // 즉시 메서드 종료
    }
    return false;     // 모든 경로에서 반환 필요
}
```

**중요한 규칙:**
- `return` 문을 만나면 **즉시 메서드 종료**
- 반환 타입이 있는 메서드는 **모든 경로에서 값을 반환**해야 함
- 반환되지 않을 가능성이 있으면 **컴파일 에러** 발생

### return을 이용한 조건부 실행
```java
public static void checkAge(int age) {
    if (age < 18) {
        System.out.println(age + "살, 미성년자는 출입이 불가능합니다.");
        return;  // 메서드 즉시 종료
    }
    System.out.println(age + "살, 입장하세요.");
}
```

---

## 매개변수가 없거나 반환 타입이 없는 경우

### void 타입 메서드
```java
public static void printHeader() {
    System.out.println("= 프로그램을 시작합니다 =");
    return; // void의 경우 생략 가능
}

public static void printFooter() {
    System.out.println("= 프로그램을 종료합니다 =");
    // return 생략됨
}
```

**특징:**
- `void`: 반환값이 없음을 의미
- `return` 문 생략 가능 (자바가 자동으로 추가)
- 매개변수 없는 경우: `()` 빈 괄호 사용

### 반환값 무시
```java
int result = add(1, 2);  // 반환값 사용
add(1, 2);              // 반환값 무시 (가능)
```

---

## 값 전달 방식 - 복사의 원리

### 핵심 원칙
> **자바는 항상 변수의 값을 복사해서 대입한다.**

### 기본 예제
```java
int num1 = 5;
int num2 = num1;  // num1의 값 5를 복사해서 num2에 대입
num2 = 10;        // num2만 변경, num1은 여전히 5
```

### 메서드 호출 시 값 복사
```java
public static void main(String[] args) {
    int num1 = 5;
    changeNumber(num1);  // num1의 값 5를 복사해서 전달
    System.out.println(num1);  // 여전히 5
}

public static void changeNumber(int num2) {
    num2 = num2 * 2;  // 복사본만 변경됨
}
```

**실행 과정:**
1. `changeNumber(num1)` 호출
2. `num1`의 값 5를 복사해서 `num2`에 전달
3. `num2` 변경은 복사본에만 영향
4. 원본 `num1`은 변경되지 않음

### 값을 변경하려면 반환값 사용
```java
public static void main(String[] args) {
    int num1 = 5;
    num1 = changeNumber(num1);  // 반환값으로 받아서 대입
    System.out.println(num1);   // 10
}

public static int changeNumber(int num2) {
    num2 = num2 * 2;
    return num2;  // 변경된 값을 반환
}
```

---

## 메서드와 형변환

### 명시적 형변환
```java
public static void printNumber(int n) {
    System.out.println("숫자: " + n);
}

double number = 1.5;
// printNumber(number);        // 컴파일 에러
printNumber((int) number);     // 명시적 형변환 필요
```

### 자동 형변환
```java
public static void printNumber(double n) {
    System.out.println("숫자: " + n);
}

int number = 100;
printNumber(number);  // int → double 자동 형변환
```

**형변환 규칙:**
- `int < long < double` 순서로 자동 형변환
- 작은 타입 → 큰 타입: 자동 형변환
- 큰 타입 → 작은 타입: 명시적 형변환 필요

---

## 메서드 오버로딩

### 오버로딩이란?
**같은 이름의 메서드를 매개변수를 다르게 해서 여러 개 정의하는 것**

### 오버로딩 성공 예시
```java
// 매개변수 개수가 다름
public static int add(int a, int b) {
    return a + b;
}

public static int add(int a, int b, int c) {
    return a + b + c;
}

// 매개변수 타입이 다름
public static double add(double a, double b) {
    return a + b;
}
```

### 오버로딩 실패 예시
```java
// 반환 타입만 다름 - 컴파일 에러!
public static int add(int a, int b) {
    return a + b;
}

public static double add(int a, int b) {  // 오류!
    return a + b;
}
```

### 메서드 시그니처
**메서드 시그니처 = 메서드 이름 + 매개변수 타입(순서)**

- 오버로딩 구분 기준: 메서드 시그니처
- 반환 타입은 시그니처에 포함되지 않음

### 오버로딩 호출 과정
```java
System.out.println(add(1, 2));      // add(int, int) 호출
System.out.println(add(1.2, 1.5));  // add(double, double) 호출
```

1. **정확한 타입 매치 우선**
2. **형변환 가능한 타입으로 매치**

---

## 메서드 사용의 장점

### 1. 코드 재사용성 (Code Reusability)
```java
// 같은 기능을 여러 곳에서 사용
double avg1 = average(1, 2, 3);
double avg2 = average(15, 25, 35);
```

### 2. 유지보수 용이성 (Maintainability)
- 한 곳에서만 수정하면 모든 곳에 적용
- 버그 수정이나 기능 개선이 간단

### 3. 모듈화 (Modularity)
```java
public static void main(String[] args) {
    int balance = 10000;
    balance = deposit(balance, 1000);    // 입금
    balance = withdraw(balance, 2000);   // 출금
    System.out.println("최종 잔액: " + balance + "원");
}
```
- 프로그램을 기능별로 분리
- 전체 구조를 한눈에 파악 가능

### 4. 추상화 (Abstraction)
- 복잡한 내부 구현을 숨김
- 사용자는 사용법에만 집중

### 5. 테스트와 디버깅 용이성
- 개별 메서드를 독립적으로 테스트
- 문제 발생 시 해당 메서드만 확인

### 6. 코드 가독성 향상
```java
// 메서드 사용 전
int sum = a + b + c;
double result = sum / 3.0;

// 메서드 사용 후
double result = average(a, b, c);  // 의도가 명확함
```

---

## 실습 예제

### 예제 1: 평균값 계산
```java
public static double average(int a, int b, int c) {
    int sum = a + b + c;
    return sum / 3.0;
}

// 사용
System.out.println("평균값: " + average(1, 2, 3));
System.out.println("평균값: " + average(15, 25, 35));
```

### 예제 2: 메시지 반복 출력
```java
public static void printMessage(String message, int times) {
    for (int i = 0; i < times; i++) {
        System.out.println(message);
    }
}

// 사용
printMessage("Hello, world!", 3);
printMessage("Welcome!", 5);
```

### 예제 3: 은행 계좌 관리
```java
public static int deposit(int balance, int amount) {
    balance += amount;
    System.out.println(amount + "원을 입금하였습니다. 현재 잔액: " + balance + "원");
    return balance;
}

public static int withdraw(int balance, int amount) {
    if (balance >= amount) {
        balance -= amount;
        System.out.println(amount + "원을 출금하였습니다. 현재 잔액: " + balance + "원");
    } else {
        System.out.println(amount + "원을 출금하려 했으나 잔액이 부족합니다.");
    }
    return balance;
}
```

---

## 네이밍 규칙

### 변수명 vs 메서드명
- **변수명**: 명사 사용 (`customerName`, `totalSum`, `isAvailable`)
- **메서드명**: 동사로 시작 (`printReport()`, `calculateSum()`, `addCustomer()`)

### 좋은 메서드명 예시
- `getEmployeeCount()`: 직원 수 조회
- `setEmployeeName()`: 직원 이름 설정
- `validateInput()`: 입력값 검증
- `processOrder()`: 주문 처리

---

## 핵심 정리

1. **코드 중복 해결**: 메서드로 공통 기능을 분리
2. **값 복사 원칙**: 자바는 항상 값을 복사해서 전달
3. **return 문**: 즉시 메서드 종료, 모든 경로에서 반환 필요
4. **오버로딩**: 같은 이름, 다른 매개변수로 여러 메서드 정의
5. **모듈화**: 기능별 분리로 가독성과 유지보수성 향상

메서드는 Java 프로그래밍의 핵심 요소로, 효율적이고 유지보수 가능한 코드 작성을 위한 필수 도구입니다.