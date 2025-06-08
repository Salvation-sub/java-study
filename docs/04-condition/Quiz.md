# Java 조건문 퀴즈 및 정리

## 📚 조건문 이해도 확인 퀴즈

### 문제 1: 조건문의 기본 개념
**여러 코드를 특정 조건에 따라 다르게 실행하고 싶다면 무엇을 사용해야 할까요?**

**선택지:**
- A) 반복문
- B) 변수 선언
- **C) 조건문** ✅
- D) 함수 호출

**해설:**
조건문은 특정 조건이 참/거짓인지 판단하여 프로그램의 실행 흐름을 바꾸는 데 사용됩니다.

**예제 코드:**
```java
int age = 20;
if (age >= 18) {
    System.out.println("성인입니다.");
} else {
    System.out.println("미성년자입니다.");
}
```

---

### 문제 2: if-else if-else 구조의 특징
**`if-else if-else` 구조에서, 여러 조건 중 하나라도 참이라면 최대 몇 개의 코드 블록이 실행될까요?**

**선택지:**
- A) 모두 실행
- **B) 하나만 실행** ✅
- C) 두 개 이상 실행
- D) 실행되지 않음

**해설:**
`if-else if-else`에서는 조건이 순차적으로 검사되며, 첫 번째로 참인 조건의 블록만 실행되고 전체 구조를 빠져나옵니다.

**예제 코드:**
```java
int score = 85;
if (score >= 90) {
    System.out.println("A학점"); // 실행되지 않음
} else if (score >= 80) {
    System.out.println("B학점"); // 이것만 실행됨
} else if (score >= 70) {
    System.out.println("C학점"); // 실행되지 않음 (앞의 조건이 참이므로)
} else {
    System.out.println("F학점"); // 실행되지 않음
}
```

---

### 문제 3: 독립적인 조건 처리
**여러 조건이 서로 영향을 주지 않고 독립적으로 평가되어, 조건이 맞을 때마다 해당 코드가 모두 실행되어야 한다면 어떤 조건문 구조를 사용하는 것이 좋을까요?**

**선택지:**
- A) `if-else if`
- B) `switch`
- **C) 별도의 `if`문들** ✅
- D) 삼항 연산자

**해설:**
각 조건이 독립적이어서 여러 조건이 동시에 만족되고 각 결과가 모두 필요할 때는 `if-else if` 대신 각각의 `if`문을 사용해야 합니다.

**잘못된 예 (if-else if 사용):**
```java
int price = 10000;
int age = 10;
int discount = 0;

if (price >= 10000) {
    discount += 1000;
    System.out.println("가격 할인 적용");
} else if (age <= 10) {  // ❌ 첫 번째 조건이 참이면 이것은 실행되지 않음
    discount += 1000;
    System.out.println("어린이 할인 적용");
}
// 결과: 1000원 할인만 적용됨
```

**올바른 예 (별도의 if문들 사용):**
```java
int price = 10000;
int age = 10;
int discount = 0;

if (price >= 10000) {  // 독립적인 조건
    discount += 1000;
    System.out.println("가격 할인 적용");
}

if (age <= 10) {  // 독립적인 조건
    discount += 1000;
    System.out.println("어린이 할인 적용");
}
// 결과: 2000원 할인 적용됨 (두 할인 모두 적용)
```

---

### 문제 4: switch문의 특징
**`switch` 문은 주로 어떤 종류의 조건 비교에 사용될까요?**

**선택지:**
- A) 크거나 작음 비교
- **B) 같음 비교** ✅
- C) 논리적 OR 비교
- D) 복합적인 조건식 평가

**해설:**
`switch` 문은 하나의 변수나 표현식의 값을 여러 상수 값과 '같음'을 비교하는 데 특화되어 있습니다.

**switch문 예제:**
```java
int grade = 2;
String message;

switch (grade) {
    case 1:  // grade == 1 인지 확인
        message = "1등급 쿠폰";
        break;
    case 2:  // grade == 2 인지 확인
        message = "2등급 쿠폰";
        break;
    case 3:  // grade == 3 인지 확인
        message = "3등급 쿠폰";
        break;
    default:
        message = "일반 쿠폰";
}
```

**if문으로 범위 비교 (switch문으로는 불가능):**
```java
int score = 85;
if (score >= 90) {  // 범위 비교는 switch문으로 불가능
    System.out.println("A학점");
} else if (score >= 80) {
    System.out.println("B학점");
}
```

---

### 문제 5: 삼항 연산자의 용도
**삼항 연산자를 사용하는 주된 이유는 무엇일까요?**

**선택지:**
- A) 반복적인 작업 수행
- B) 여러 개의 독립적인 조건 처리
- **C) 간결한 조건부 값 할당** ✅
- D) 복잡한 코드 블록 실행

**해설:**
삼항 연산자는 간단한 조건에 따라 변수에 값을 할당할 때, `if-else` 문보다 간결하게 코드를 작성할 수 있도록 돕는 데 사용됩니다.

**if-else문 사용:**
```java
int age = 18;
String status;
if (age >= 18) {
    status = "성인";
} else {
    status = "미성년자";
}
```

**삼항 연산자 사용 (더 간결):**
```java
int age = 18;
String status = (age >= 18) ? "성인" : "미성년자";
```

**삼항 연산자 문법:**
```java
// (조건) ? 참일_때_값 : 거짓일_때_값
int max = (a > b) ? a : b;
String result = (score >= 60) ? "합격" : "불합격";
```

---

## 💡 핵심 정리

### 1. 조건문 선택 가이드

| 상황 | 사용할 조건문 | 이유 |
|------|---------------|------|
| 서로 연관된 조건들을 순차 체크 | `if-else if-else` | 하나의 조건만 실행됨 |
| 독립적인 여러 조건들 | 별도의 `if`문들 | 각 조건이 독립적으로 실행됨 |
| 특정 값에 따른 분기 | `switch`문 | 값의 동등성 비교에 최적화 |
| 간단한 값 할당 | 삼항 연산자 | 코드가 간결해짐 |

### 2. 조건문 비교표

```java
// 1. if-else if (연관된 조건) - 하나만 실행
if (score >= 90) {
    grade = "A";
} else if (score >= 80) {
    grade = "B";
} else {
    grade = "C";
}

// 2. 독립적인 if문들 - 조건 맞는 것 모두 실행
if (price >= 10000) {
    discount += 1000;  // 가격 할인
}
if (age <= 10) {
    discount += 500;   // 어린이 할인
}

// 3. switch문 - 값 비교
switch (grade) {
    case 1: coupon = 1000; break;
    case 2: coupon = 2000; break;
    default: coupon = 500;
}

// 4. 삼항 연산자 - 간단한 값 할당
String status = (age >= 18) ? "성인" : "미성년자";
```

### 3. 주의사항

**❌ 흔한 실수:**
```java
// 독립적인 조건을 if-else if로 작성
if (condition1) {
    // 작업1
} else if (condition2) {  // condition1이 참이면 실행 안됨
    // 작업2
}
```

**✅ 올바른 방법:**
```java
// 독립적인 조건은 별도의 if문 사용
if (condition1) {
    // 작업1
}
if (condition2) {  // condition1과 관계없이 실행
    // 작업2
}
```

### 4. 실무 팁

1. **가독성을 위해 중괄호 사용 권장**
```java
// 권장하지 않음
if (condition) doSomething();

// 권장
if (condition) {
    doSomething();
}
```

2. **복잡한 조건은 변수로 분리**
```java
// 복잡함
if (user.getAge() >= 18 && user.hasLicense() && user.getExperience() > 2) {
    // ...
}

// 명확함
boolean isAdult = user.getAge() >= 18;
boolean hasLicense = user.hasLicense();
boolean isExperienced = user.getExperience() > 2;

if (isAdult && hasLicense && isExperienced) {
    // ...
}
```

---

