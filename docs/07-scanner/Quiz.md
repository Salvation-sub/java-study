# 자바 Scanner 사용 가이드

## 개요

Scanner는 자바에서 사용자 입력을 받기 위해 제공되는 클래스입니다. `System.in`을 직접 사용하는 것보다 훨씬 간편하고 직관적으로 사용할 수 있습니다.

## Scanner 기본 사용법

### 1. Scanner 생성

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
```

### 2. 기본 입력 메서드

| 메서드 | 설명 | 예시 |
|--------|------|------|
| `nextLine()` | 문자열 입력 (엔터까지) | `String str = scanner.nextLine();` |
| `nextInt()` | 정수 입력 | `int num = scanner.nextInt();` |
| `nextDouble()` | 실수 입력 | `double d = scanner.nextDouble();` |

### 3. 기본 예제

```java
package scanner;
import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("문자열을 입력하세요:");
        String str = scanner.nextLine();
        System.out.println("입력한 문자열: " + str);
        
        System.out.print("정수를 입력하세요:");
        int intValue = scanner.nextInt();
        System.out.println("입력한 정수: " + intValue);
        
        System.out.print("실수를 입력하세요:");
        double doubleValue = scanner.nextDouble();
        System.out.println("입력한 실수: " + doubleValue);
    }
}
```

## print() vs println()

- **print()**: 출력 후 줄바꿈하지 않음
- **println()**: 출력 후 줄바꿈함

```java
// print() 사용
System.out.print("hello");
System.out.print("world");
// 결과: helloworld

// println() 사용
System.out.println("hello");
System.out.println("world");
// 결과:
// hello
// world
```

## Scanner와 반복문 활용

### 예제 1: 문자열 반복 입력

```java
public class ScannerWhile1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("문자열을 입력하세요(exit: 종료):");
            String str = scanner.nextLine();
            
            if (str.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            
            System.out.println("입력한 문자열: " + str);
        }
    }
}
```

### 예제 2: 숫자 합계 계산

```java
public class ScannerWhile3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        
        while (true) {
            System.out.print("정수를 입력하세요 (0을 입력하면 종료): ");
            int number = input.nextInt();
            
            if (number == 0) {
                break;
            }
            
            sum += number; // sum = sum + number와 동일
        }
        
        System.out.println("입력한 모든 정수의 합: " + sum);
    }
}
```

## 주의사항

### 1. 타입 불일치 오류
```java
// 정수 입력에서 문자를 입력하면 오류 발생
정수를 입력하세요:백만원
Exception in thread "main" java.util.InputMismatchException
```

### 2. 줄바꿈 문자 처리
숫자 입력 후 문자열 입력 시 `nextLine()`을 한 번 더 호출해야 합니다:

```java
int age = scanner.nextInt();
scanner.nextLine(); // 숫자 입력 후의 줄바꿈 처리
String name = scanner.nextLine();
```

## 실습 문제

### 문제 1: 이름과 나이 입력받기
```java
// 사용자로부터 이름과 나이를 입력받아 출력하는 프로그램
// 출력 형태: "당신의 이름은 [이름]이고, 나이는 [나이]살입니다."
```

### 문제 2: 홀수/짝수 판별
```java
// 하나의 정수를 입력받고 홀수인지 짝수인지 판별
// 힌트: % 연산자 사용
```

### 문제 3: 구구단 출력
```java
// 사용자로부터 단 수를 입력받아 해당 구구단 출력
// 예: 8단 입력 시 8 x 1 = 8 부터 8 x 9 = 72까지
```

### 문제 4: 변수 값 교환
```java
// 두 변수 a=10, b=20의 값을 서로 바꾸기
// 힌트: temp 변수 활용
```

## 해답 예시

### 문제 1 해답
```java
public class ScannerEx1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("당신의 이름을 입력하세요:");
        String name = scanner.nextLine();
        
        System.out.print("당신의 나이를 입력하세요:");
        int age = scanner.nextInt();
        
        System.out.println("당신의 이름은 " + name + "이고, 나이는 " + age + "살입니다.");
    }
}
```

### 문제 2 해답
```java
public class ScannerEx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("하나의 정수를 입력하세요:");
        int number = scanner.nextInt();
        
        if (number % 2 == 0) {
            System.out.println("입력한 숫자 " + number + "는 짝수입니다.");
        } else {
            System.out.println("입력한 숫자 " + number + "는 홀수입니다.");
        }
    }
}
```

### 문제 4 해답 (변수 교환)
```java
public class ChangeVarEx {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int temp;
        
        // 교환 과정
        temp = a;  // temp에 a값(10) 저장
        a = b;     // a에 b값(20) 대입
        b = temp;  // b에 temp값(10) 대입
        
        System.out.println("a = " + a); // 20
        System.out.println("b = " + b); // 10
    }
}
```

## 핵심 포인트

1. **Scanner 생성**: `Scanner scanner = new Scanner(System.in);`
2. **입력 메서드**: `nextLine()`, `nextInt()`, `nextDouble()`
3. **반복문 활용**: `while(true)`와 `break` 조합
4. **문자열 비교**: `str.equals("exit")` 사용
5. **타입 안전성**: 입력 타입과 변수 타입 일치 확인

## Scanner 이해도 퀴즈

### 퀴즈 1: Scanner 클래스 사용 준비
**Q: 자바에서 Scanner 클래스를 사용하려면 일반적으로 무엇이 필요할까요?**

**선택지:**
- A. 새로운 클래스 생성
- B. System.out 사용
- C. import 문 추가 ✅
- D. Scanner 객체 닫기

**해설:**
Scanner는 java.util 패키지에 정의되어 있습니다. 사용하려면 코드 맨 위에 `import java.util.Scanner;` 문이 필요합니다.

### 퀴즈 2: 정수 입력 메서드
**Q: 사용자로부터 정수(whole number)를 입력받기 위해 Scanner 클래스의 어떤 메소드를 사용해야 할까요?**

**선택지:**
- A. nextLine()
- B. nextDouble()
- C. nextInt() ✅
- D. print()

**해설:**
`nextInt()`는 입력 스트림에서 다음 정수 값을 읽어옵니다. 한 줄 전체는 `nextLine()`, 소수점은 `nextDouble()`을 사용해야 합니다.

### 퀴즈 3: Scanner 사용 시 주의사항
**Q: Scanner로 `nextInt()`를 사용한 직후에 `nextLine()`을 사용할 때 발생할 수 있는 흔한 문제는 무엇일까요?**

**선택지:**
- A. 프로그램 속도가 느려짐
- B. `nextLine()`이 빈 줄을 읽음 ✅
- C. 숫자 입력이 실패함
- D. `InputMismatchException` 발생

**해설:**
`nextInt()`는 숫자만 읽고 엔터(개행 문자)를 남겨둡니다. 바로 다음 `nextLine()`이 그 엔터를 읽어버리는 문제가 발생합니다.

**해결 방법:**
```java
int age = scanner.nextInt();
scanner.nextLine(); // 개행 문자 제거
String name = scanner.nextLine(); // 실제 문자열 입력
```

### 퀴즈 4: 변수 값 교환
**Q: 변수 A와 B의 값을 서로 바꾸려면 (Swap) 임시 변수가 왜 필요한가요?**

**선택지:**
- A. 코드를 더 짧게 만들기 위해
- B. 원래 A의 값을 잃지 않기 위해 ✅
- C. 두 변수를 동시에 수정하기 위해
- D. 프로그램 오류를 방지하기 위해

**해설:**
`a=b; b=a;` 순서로 하면 A의 원래 값이 덮어씌워져 사라집니다. 임시 변수에 A 값을 먼저 저장해야 안전하게 바꿀 수 있습니다.

**올바른 교환 방법:**
```java
int temp = a;  // A의 값을 임시 저장
a = b;         // A에 B의 값 대입
b = temp;      // B에 원래 A의 값 대입
```

### 퀴즈 5: 반복문 종료 조건
**Q: 사용자 입력을 계속 받는 `while` 루프를 특정 입력값(예: -1 또는 "exit")에서 종료시키려면 어떻게 해야 할까요?**

**선택지:**
- A. 루프 조건에 종료 조건 명시
- B. `System.exit(0)` 호출
- C. 무한 루프 `while(true)` 사용 후 `break` 문 사용
- D. A 또는 C 방법 사용 가능 ✅

**해설:**
`while (true)`와 `break`를 함께 쓰거나, `while (입력값 != 종료값)`처럼 루프 조건 자체에 종료 조건을 명시할 수 있습니다.

**방법 1: break 사용**
```java
while (true) {
    int input = scanner.nextInt();
    if (input == -1) {
        break;
    }
    // 처리 로직
}
```

**방법 2: 조건 명시**
```java
int input = scanner.nextInt();
while (input != -1) {
    // 처리 로직
    input = scanner.nextInt();
    
}
```

