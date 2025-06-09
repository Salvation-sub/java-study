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

## 추가 학습 권장사항

- 예외 처리 (Exception Handling)
- 정규표현식을 이용한 입력 검증
- 파일에서 입력 받기
- BufferedReader vs Scanner 성능 비교