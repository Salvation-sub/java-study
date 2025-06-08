# Java 조건문 (Conditional Statements)

## 목차
- [if문1 - if, else](#if문1---if-else)
- [if문2 - else if](#if문2---else-if)
- [if문3 - if문과 else if문](#if문3---if문과-else-if문)
- [switch문](#switch문)
- [삼항 연산자](#삼항-연산자)
- [문제와 풀이](#문제와-풀이)

## 조건문 시작

조건문은 특정 조건에 따라서 다른 코드를 실행하는 것입니다.

예를 들어:
- 만약 18살 이상이면 "성인입니다"를 출력
- 만약 18살 미만이라면 "미성년자입니다"를 출력

조건문에는 **if 문**과 **switch 문**이 있습니다.

---

## if문1 - if, else

### if문

if 문은 특정 조건이 참인지 확인하고, 그 조건이 참(true)일 경우 특정 코드 블록을 실행합니다.

```java
if (condition) {
    // 조건이 참일 때 실행되는 코드
}
```

### 예제 - If1
```java
package cond;

public class If1 {
    public static void main(String[] args) {
        int age = 20; // 사용자 나이
        
        if (age >= 18) {
            System.out.println("성인입니다.");
        }
        
        if (age < 18) {
            System.out.println("미성년자입니다.");
        }
    }
}
```

**실행 결과:**
```
성인입니다.
```

### else문

else 문은 if 문에서 만족하는 조건이 없을 때 실행하는 코드를 제공합니다.

```java
if (condition) {
    // 조건이 참일 때 실행되는 코드
} else {
    // 만족하는 조건이 없을 때 실행되는 코드
}
```

### 예제 - If2
```java
package cond;

public class If2 {
    public static void main(String[] args) {
        int age = 20; // 사용자의 나이
        
        if (age >= 18) {
            System.out.println("성인입니다."); //참일 때 실행
        } else {
            System.out.println("미성년자입니다."); //만족하는 조건이 없을 때 실행
        }
    }
}
```

---

## if문2 - else if

### 문제 상황
연령에 따라 다른 메시지를 출력하는 프로그램:
- 7세 이하일 경우: "미취학"
- 8세 이상 13세 이하일 경우: "초등학생"
- 14세 이상 16세 이하일 경우: "중학생"
- 17세 이상 19세 이하일 경우: "고등학생"
- 20세 이상일 경우: "성인"

### if문만 사용한 비효율적인 코드 - If3
```java
package cond;

public class If3 {
    public static void main(String[] args) {
        int age = 14;
        
        if(age <= 7) { //~7: 미취학
            System.out.println("미취학");
        }
        if(age >= 8 && age <= 13) { //8~13: 초등학생
            System.out.println("초등학생");
        }
        if(age >= 14 && age <= 16) { //14~16: 중학생
            System.out.println("중학생");
        }
        if(age >= 17 && age <= 19) { //17~19: 고등학생
            System.out.println("고등학생");
        }
        if(age >= 20) { //20~: 성인
            System.out.println("성인");
        }
    }
}
```

**문제점:**
- 불필요한 조건 검사
- 코드 효율성 저하

### else if 사용

```java
if (condition1) {
    // 조건1이 참일 때 실행되는 코드
} else if (condition2) {
    // 조건1이 거짓이고, 조건2가 참일 때 실행되는 코드
} else if (condition3) {
    // 조건2이 거짓이고, 조건3이 참일 때 실행되는 코드
} else {
    // 모든 조건이 거짓일 때 실행되는 코드
}
```

### 개선된 코드 - If4
```java
package cond;

public class If4 {
    public static void main(String[] args) {
        int age = 14;
        
        if(age <= 7) { //~7: 미취학
            System.out.println("미취학");
        } else if(age <= 13) { //8~13: 초등학생
            System.out.println("초등학생");
        } else if(age <= 16) { //14~16: 중학생
            System.out.println("중학생");
        } else if(age <= 19) { //17~19: 고등학생
            System.out.println("고등학생");
        } else { //20~: 성인
            System.out.println("성인");
        }
    }
}
```

---

## if문3 - if문과 else if문

### 언제 if문을 각각 사용할까?

**서로 연관된 조건** → `if-else if` 사용
```java
// 예시1. if-else 사용: 서로 연관된 조건이어서, 하나로 묶을 때
if (condition1) {
    // 작업1 수행
} else if (condition2) {
    // 작업2 수행
}
```

**독립적인 조건** → `if문` 각각 사용
```java
// 예시2. if 각각 사용: 독립 조건일 때
if (condition1) {
    // 작업1 수행
}
if (condition2) {
    // 작업2 수행
}
```

### 독립적인 조건 예제 - If5 (할인 시스템)
```java
package cond;

public class If5 {
    public static void main(String[] args) {
        int price = 10000;// 아이템 가격
        int age = 10;//나이
        int discount = 0;
        
        if (price >= 10000) {
            discount = discount + 1000;
            System.out.println("10000원 이상 구매, 1000원 할인");
        }
        
        if (age <= 10) {
            discount = discount + 1000;
            System.out.println("어린이 1000원 할인");
        }
        
        System.out.println("총 할인 금액: " + discount + "원");
    }
}
```

**실행 결과:**
```
10000원 이상 구매, 1000원 할인
어린이 1000원 할인
총 할인 금액: 2000원
```

---

## switch문

### switch문 기본 구조
```java
switch (조건식) {
    case value1:
        // 조건식의 결과 값이 value1일 때 실행되는 코드
        break;
    case value2:
        // 조건식의 결과 값이 value2일 때 실행되는 코드
        break;
    default:
        // 조건식의 결과 값이 위의 어떤 값에도 해당하지 않을 때 실행되는 코드
}
```

### 회원 등급 쿠폰 발급 예제

**if문 사용 - Switch1**
```java
package cond;

public class Switch1 {
    public static void main(String[] args) {
        //grade 1:1000, 2:2000, 3:3000, 나머지: 500
        int grade = 2;
        int coupon;
        
        if (grade == 1) {
            coupon = 1000;
        } else if (grade == 2) {
            coupon = 2000;
        } else if (grade == 3) {
            coupon = 3000;
        } else {
            coupon = 500;
        }
        
        System.out.println("발급받은 쿠폰 " + coupon);
    }
}
```

**switch문 사용 - Switch2**
```java
package cond;

public class Switch2 {
    public static void main(String[] args) {
        //grade 1:1000, 2:2000, 3:3000, 나머지: 500
        int grade = 2;
        int coupon;
        
        switch (grade) {
            case 1:
                coupon = 1000;
                break;
            case 2:
                coupon = 2000;
                break;
            case 3:
                coupon = 3000;
                break;
            default:
                coupon = 500;
        }
        
        System.out.println("발급받은 쿠폰 " + coupon);
    }
}
```

### break문이 없는 경우 - Switch3
```java
package cond;

public class Switch3 {
    public static void main(String[] args) {
        //grade 1:1000, 2:3000(변경), 3:3000, 나머지: 500
        int grade = 2;
        int coupon;
        
        switch (grade) {
            case 1:
                coupon = 1000;
                break;
            case 2:
            case 3:
                coupon = 3000;
                break;
            default:
                coupon = 500;
                break;
        }
        
        System.out.println("발급받은 쿠폰 " + coupon);
    }
}
```

### if문 vs switch문
- **switch문**: 조건식이 특정 case와 같은지만 체크 (값이 같은지 확인하는 연산만 가능)
- **if문**: 참 거짓의 결과가 나오는 조건식을 자유롭게 사용 가능 (예: `x > 10`, `x == 10`)

### 자바 14 새로운 switch문
```java
int coupon = switch (grade) {
    case 1 -> 1000;
    case 2 -> 2000;
    case 3 -> 3000;
    default -> 500;
};
```

---

## 삼항 연산자

단순히 참과 거짓에 따라 특정 값을 구하는 경우 사용하는 연산자입니다.

### 기본 구조
```
(조건) ? 참_표현식 : 거짓_표현식
```

### if문 사용 - CondOp1
```java
package cond;

public class CondOp1 {
    public static void main(String[] args) {
        int age = 18;
        String status;
        
        if (age >= 18) {
            status = "성인";
        } else {
            status = "미성년자";
        }
        
        System.out.println("age = " + age + " status = " + status);
    }
}
```

### 삼항 연산자 사용 - CondOp2
```java
package cond;

public class CondOp2 {
    public static void main(String[] args) {
        int age = 18;
        String status = (age >= 18) ? "성인" : "미성년자";
        System.out.println("age = " + age + " status = " + status);
    }
}
```

**삼항 연산자 특징:**
- 항이 3개: 조건, 참_표현식, 거짓_표현식
- 코드 블럭이 아닌 단순한 표현식만 사용 가능
- 간결한 코드 작성 가능

---

## 문제와 풀이

### 문제 1: 학점 계산하기
학생의 점수를 기반으로 학점을 출력하는 프로그램을 작성하세요.

**기준:**
- 90점 이상: "A"
- 80점 이상 90점 미만: "B"
- 70점 이상 80점 미만: "C"
- 60점 이상 70점 미만: "D"
- 60점 미만: "F"

**정답:**
```java
package cond.ex;

public class ScoreEx {
    public static void main(String[] args) {
        int score = 85;
        
        if (score >= 90) {
            System.out.println("학점은 A입니다.");
        } else if (score >= 80) {
            System.out.println("학점은 B입니다.");
        } else if (score >= 70) {
            System.out.println("학점은 C입니다.");
        } else if (score >= 60) {
            System.out.println("학점은 D입니다.");
        } else {
            System.out.println("학점은 F입니다.");
        }
    }
}
```

### 문제 2: 거리에 따른 운송 수단 선택하기
주어진 거리에 따라 가장 적합한 운송 수단을 선택하는 프로그램을 작성하세요.

**기준:**
- 거리가 1km 이하: "도보"
- 거리가 10km 이하: "자전거"
- 거리가 100km 이하: "자동차"
- 거리가 100km 초과: "비행기"

**정답:**
```java
package cond.ex;

public class DistanceEx {
    public static void main(String[] args) {
        int distance = 25;
        
        if (distance <= 1) {
            System.out.println("도보를 이용하세요.");
        } else if (distance <= 10) {
            System.out.println("자전거를 이용하세요.");
        } else if (distance <= 100) {
            System.out.println("자동차를 이용하세요.");
        } else {
            System.out.println("비행기를 이용하세요.");
        }
    }
}
```

### 문제 3: 환율 계산하기
특정 금액을 미국 달러에서 한국 원으로 변환하는 프로그램을 작성하세요. (환율: 1달러당 1300원)

**기준:**
- 달러가 0미만: "잘못된 금액입니다."
- 달러가 0: "환전할 금액이 없습니다."
- 달러가 0 초과: "환전 금액은 (계산된 원화 금액)원입니다."

**정답:**
```java
package cond.ex;

public class ExchangeRateEx {
    public static void main(String[] args) {
        int dollar = 10;
        
        if (dollar < 0) {
            System.out.println("잘못된 금액입니다.");
        } else if (dollar == 0) {
            System.out.println("환전할 금액이 없습니다.");
        } else {
            int won = dollar * 1300;
            System.out.println("환전 금액은 " + won + "원입니다.");
        }
    }
}
```

### 문제 4: 평점에 따른 영화 추천하기
요청한 평점 이상의 영화를 찾아서 추천하는 프로그램을 작성하세요.

**영화 정보:**
- 어바웃타임 - 평점9
- 토이 스토리 - 평점8
- 고질라 - 평점7

**정답:**
```java
package cond.ex;

public class MovieRateEx {
    public static void main(String[] args) {
        double rating = 7.1;
        
        if (rating <= 9) {
            System.out.println("'어바웃타임'을 추천합니다.");
        }
        if (rating <= 8) {
            System.out.println("'토이 스토리'를 추천합니다.");
        }
        if (rating <= 7) {
            System.out.println("'고질라'를 추천합니다.");
        }
    }
}
```

### 문제 5: 학점에 따른 성취도 출력하기 (switch문)
String grade에 따라 성취도를 출력하는 프로그램을 작성하세요.

**성취도:**
- "A": "탁월한 성과입니다!"
- "B": "좋은 성과입니다!"
- "C": "준수한 성과입니다!"
- "D": "향상이 필요합니다."
- "F": "불합격입니다."
- 나머지: "잘못된 학점입니다."

**정답:**
```java
package cond.ex;

public class GradeSwitchEx {
    public static void main(String[] args) {
        String grade = "B";
        
        switch(grade) {
            case "A":
                System.out.println("탁월한 성과입니다!");
                break;
            case "B":
                System.out.println("좋은 성과입니다!");
                break;
            case "C":
                System.out.println("준수한 성과입니다!");
                break;
            case "D":
                System.out.println("향상이 필요합니다.");
                break;
            case "F":
                System.out.println("불합격입니다.");
                break;
            default:
                System.out.println("잘못된 학점입니다.");
        }
    }
}
```

### 문제 6: 더 큰 숫자 찾기 (삼항 연산자)
두 개의 정수 a(10), b(20) 중 더 큰 숫자를 출력하는 프로그램을 작성하세요.

**정답:**
```java
package cond.ex;

public class CondOpEx {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int max = (a > b) ? a : b;
        System.out.println("더 큰 숫자는 " + max + "입니다.");
    }
}
```

### 문제 7: 홀수 짝수 찾기 (삼항 연산자)
정수 x가 짝수이면 "짝수"를, 홀수이면 "홀수"를 출력하는 프로그램을 작성하세요.
(`x % 2` 사용)

**정답:**
```java
package cond.ex;

public class EvenOddEx {
    public static void main(String[] args) {
        int x = 2;
        String result = (x % 2 == 0) ? "짝수" : "홀수";
        System.out.println("x = " + x + ", " + result);
    }
}
```

---

## 정리

### 조건문 선택 가이드

1. **if-else if-else**: 서로 연관된 조건들을 순서대로 체크할 때
2. **독립적인 if문들**: 각각 독립적으로 실행되어야 하는 조건들
3. **switch문**: 특정 값에 따라 다른 코드를 실행할 때 (단순 값 비교)
4. **삼항 연산자**: 간단한 참/거짓 조건에 따라 값을 할당할 때

### 중괄호 사용 권장사항
실행할 명령이 하나만 있어도 가독성과 유지보수성을 위해 중괄호 `{}`를 사용하는 것을 권장합니다.

```java
// 권장하지 않음
if (true)
    System.out.println("실행됨");

// 권장
if (true) {
    System.out.println("실행됨");
}
```