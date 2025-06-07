# Java 연산자

## 📋 목차
- [산술 연산자](#산술-연산자)
- [문자열 더하기](#문자열-더하기)
- [연산자 우선순위](#연산자-우선순위)
- [증감 연산자](#증감-연산자)
- [비교 연산자](#비교-연산자)
- [논리 연산자](#논리-연산자)
- [대입 연산자](#대입-연산자)
- [문제와 풀이](#문제와-풀이)

## 🔢 산술 연산자

### 연산자 종류
- **산술 연산자**: `+`, `-`, `*`, `/`, `%` (나머지)
- **증감 연산자**: `++`, `--`
- **비교 연산자**: `==`, `!=`, `>`, `<`, `>=`, `<=`
- **논리 연산자**: `&&` (AND), `||` (OR), `!` (NOT)
- **대입 연산자**: `=`, `+=`, `-=`, `*=`, `/=`, `%=`
- **삼항 연산자**: `? :`

### 연산자와 피연산자
```java
3 + 4
a + b
```
- **연산자(operator)**: 연산 기호 (예: `+`, `-`)
- **피연산자(operand)**: 연산 대상 (예: `3`, `4`, `a`, `b`)

### 기본 산술 연산

```java
package operator;

public class Operator1 {
    public static void main(String[] args) {
        int a = 5;
        int b = 2;
        
        // 덧셈
        int sum = a + b;
        System.out.println("a + b = " + sum);    // 7
        
        // 뺄셈
        int diff = a - b;
        System.out.println("a - b = " + diff);   // 3
        
        // 곱셈
        int multi = a * b;
        System.out.println("a * b = " + multi);  // 10
        
        // 나눗셈
        int div = a / b;
        System.out.println("a / b = " + div);    // 2
        
        // 나머지
        int mod = a % b;
        System.out.println("a % b = " + mod);    // 1
    }
}
```

### 📊 산술 연산자 상세

| 연산자 | 의미 | 예시 | 결과 |
|--------|------|------|------|
| `+` | 더하기 | `5 + 3` | `8` |
| `-` | 빼기 | `5 - 3` | `2` |
| `*` | 곱하기 | `5 * 3` | `15` |
| `/` | 나누기 | `5 / 2` | `2` (정수 나눗셈) |
| `%` | 나머지 | `5 % 2` | `1` |

### ⚠️ 정수 나눗셈 주의사항
```java
int result = 5 / 2;  // 결과: 2 (소수점 제거)
```
- `int` 끼리 계산하면 결과도 `int`
- 소수점 이하는 자동으로 버려짐

### 나머지 연산자 (%)
```java
5 / 2 = 2 (몫)
5 % 2 = 1 (나머지)
```
- 실무와 알고리즘에서 자주 사용
- 홀수/짝수 판별, 특정 주기 계산 등에 활용

### 🚫 0으로 나누기
```java
int result = 10 / 0;  // ArithmeticException 발생!
```
예외 메시지: `Exception in thread "main" java.lang.ArithmeticException: / by zero`

## 📝 문자열 더하기

자바는 문자열에도 `+` 연산자를 사용할 수 있습니다.

```java
package operator;

public class Operator2 {
    public static void main(String[] args) {
        // 문자열과 문자열 더하기
        String result1 = "hello " + "world";
        System.out.println(result1);  // hello world
        
        String s1 = "string1";
        String s2 = "string2";
        String result2 = s1 + s2;
        System.out.println(result2);  // string1string2
        
        // 문자열과 숫자 더하기
        String result3 = "a + b = " + 10;
        System.out.println(result3);  // a + b = 10
        
        int num = 20;
        String str = "a + b = ";
        String result4 = str + num;
        System.out.println(result4);  // a + b = 20
    }
}
```

### 문자열 + 숫자 계산 과정

```java
"a + b = " + 10
```

**계산 순서:**
1. `"a + b = "(String) + 10(int)`
2. `"a + b = "(String) + "10"(String)` ← 숫자를 문자열로 변환
3. `"a + b = 10"` ← 문자열 연결

> **핵심**: 문자열에 다른 타입을 더하면 **모든 것이 문자열**이 됩니다!

## 🎯 연산자 우선순위

### 기본 개념
```java
1 + 2 * 3 = ?
```
수학과 동일하게 **곱셈이 덧셈보다 우선순위가 높습니다**.

```java
1 + 2 * 3
= 1 + (2 * 3)  // 곱셈 먼저
= 1 + 6
= 7
```

### 예제 코드

```java
package operator;

public class Operator3 {
    public static void main(String[] args) {
        int sum1 = 1 + 2 * 3;     // 1 + (2 * 3) = 7
        int sum2 = (1 + 2) * 3;   // (1 + 2) * 3 = 9
        
        System.out.println("sum1 = " + sum1);  // 7
        System.out.println("sum2 = " + sum2);  // 9
    }
}
```

### 복잡한 연산 예제

```java
int sum3 = 2 * 2 + 3 * 3;        // (2 * 2) + (3 * 3) = 13
int sum4 = (2 * 2) + (3 * 3);    // 명시적 괄호 사용 = 13
```

### 📚 연산자 우선순위 (높음 → 낮음)

1. **괄호** `()`
2. **단항 연산자** `++`, `--`, `!`, `~`, `new`, `(type)`
3. **산술 연산자** `*`, `/`, `%` → `+`, `-`
4. **Shift 연산자** `<<`, `>>`, `>>>`
5. **비교 연산자** `<`, `<=`, `>`, `>=`, `instanceof`
6. **등식 연산자** `==`, `!=`
7. **비트 연산자** `&`, `^`, `|`
8. **논리 연산자** `&&`, `||`
9. **삼항 연산자** `? :`
10. **대입 연산자** `=`, `+=`, `-=`, `*=`, `/=`, `%=`

### 💡 연산자 우선순위 암기법

**실제로는 2가지만 기억하면 됩니다!**

#### 1. 상식선에서 우선순위 사용
```java
int sum = 1 + 2 * 3;  // 당연히 * 이 + 보다 우선
int sum = 1 + 2;      // 당연히 + 이 = 보다 우선
```

#### 2. 애매하면 괄호() 사용
```java
((2 * 2) + (3 * 3)) / (3 + 2)  // 명확하고 읽기 쉬움
```

> **핵심**: 연산자 우선순위는 상식선에서 생각하고, 애매하면 괄호를 사용하자!

## ⬆️ 증감 연산자

값을 1씩 증가시키거나 감소시키는 연산자입니다.

### 기본 사용법

```java
package operator;

public class OperatorAdd1 {
    public static void main(String[] args) {
        int a = 0;
        
        a = a + 1;
        System.out.println("a = " + a);  // 1
        
        a = a + 1;
        System.out.println("a = " + a);  // 2
        
        // 증감 연산자 사용
        ++a;  // a = a + 1 과 동일
        System.out.println("a = " + a);  // 3
        
        ++a;
        System.out.println("a = " + a);  // 4
    }
}
```

### 전위 vs 후위 증감연산자

```java
++a  // 전위(Prefix): 증가 먼저, 사용 나중
a++  // 후위(Postfix): 사용 먼저, 증가 나중
```

### 전위 증감 연산자 예제

```java
package operator;

public class OperatorAdd2 {
    public static void main(String[] args) {
        // 전위 증감 연산자
        int a = 1;
        int b = 0;
        
        b = ++a;  // a를 먼저 증가시키고, 그 결과를 b에 대입
        System.out.println("a = " + a + ", b = " + b);  // a = 2, b = 2
        
        // 후위 증감 연산자
        a = 1;
        b = 0;
        
        b = a++;  // a의 현재 값을 b에 먼저 대입하고, 그 후 a 증가
        System.out.println("a = " + a + ", b = " + b);  // a = 2, b = 1
    }
}
```

### 💡 증감 연산자 동작 원리

#### 전위 (++a)
```java
a = 1, b = 0
b = ++a

// 실행 순서:
// 1. a = a + 1  (a = 2)
// 2. b = a      (b = 2)
```

#### 후위 (a++)
```java
a = 1, b = 0
b = a++

// 실행 순서:
// 1. b = a      (b = 1)
// 2. a = a + 1  (a = 2)
```

### 단독 사용시
```java
++a;  // 전위
a++;  // 후위
// 단독 사용시에는 결과가 동일
```

## 🔍 비교 연산자

두 값을 비교하여 `true` 또는 `false`를 반환합니다.

### 비교 연산자 종류

| 연산자 | 의미 | 예시 |
|--------|------|------|
| `==` | 같음 | `a == b` |
| `!=` | 다름 | `a != b` |
| `>` | 크다 | `a > b` |
| `<` | 작다 | `a < b` |
| `>=` | 크거나 같다 | `a >= b` |
| `<=` | 작거나 같다 | `a <= b` |

### 예제 코드

```java
package operator;

public class Comp1 {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        
        System.out.println(a == b);  // false
        System.out.println(a != b);  // true
        System.out.println(a > b);   // false
        System.out.println(a < b);   // true
        System.out.println(a >= b);  // false
        System.out.println(a <= b);  // true
        
        // 결과를 boolean 변수에 저장
        boolean result = a == b;
        System.out.println(result);  // false
    }
}
```

### ⚠️ 주의사항
- `=` (대입 연산자) ≠ `==` (비교 연산자)
- `!=` 에서 `!`는 "반대"를 의미

### 문자열 비교

**문자열 비교시에는 `.equals()` 메서드를 사용해야 합니다!**

```java
package operator;

public class Comp2 {
    public static void main(String[] args) {
        String str1 = "문자열1";
        String str2 = "문자열2";
        
        boolean result1 = "hello".equals("hello");     // true
        boolean result2 = str1.equals("문자열1");        // true
        boolean result3 = str1.equals(str2);           // false
        
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
    }
}
```

> **중요**: `==`는 문자열 비교에서 예상과 다른 결과가 나올 수 있습니다. 항상 `.equals()`를 사용하세요!

## 🧠 논리 연산자

`boolean` 값들을 조합하여 논리 연산을 수행합니다.

### 논리 연산자 종류

| 연산자 | 의미 | 설명 |
|--------|------|------|
| `&&` | AND (그리고) | 모두 참이어야 참 |
| `\|\|` | OR (또는) | 하나라도 참이면 참 |
| `!` | NOT (부정) | 참↔거짓 뒤바뀜 |

### 기본 예제

```java
package operator;

public class Logical1 {
    public static void main(String[] args) {
        System.out.println("&&: AND 연산");
        System.out.println(true && true);    // true
        System.out.println(true && false);   // false
        System.out.println(false && false);  // false
        
        System.out.println("||: OR 연산");
        System.out.println(true || true);    // true
        System.out.println(true || false);   // true
        System.out.println(false || false);  // false
        
        System.out.println("! 연산");
        System.out.println(!true);   // false
        System.out.println(!false);  // true
        
        // 변수 활용
        boolean a = true;
        boolean b = false;
        System.out.println(a && b);  // false
        System.out.println(a || b);  // true
        System.out.println(!a);      // false
        System.out.println(!b);      // true
    }
}
```

### 실무 활용 예제

```java
package operator;

public class Logical2 {
    public static void main(String[] args) {
        int a = 15;
        
        // a가 10보다 크고 20보다 작은지 확인
        boolean result = a > 10 && a < 20;
        System.out.println("result = " + result);  // true
        
        // 더 읽기 쉬운 형태
        boolean result2 = 10 < a && a < 20;
        System.out.println("result2 = " + result2);  // true
    }
}
```

## 📥 대입 연산자

### 기본 대입 연산자
```java
int a = 5;  // 값을 변수에 할당
```

### 축약(복합) 대입 연산자

| 연산자 | 의미 | 축약 전 | 축약 후 |
|--------|------|---------|---------|
| `+=` | 더하기 후 대입 | `i = i + 3` | `i += 3` |
| `-=` | 빼기 후 대입 | `i = i - 3` | `i -= 3` |
| `*=` | 곱하기 후 대입 | `i = i * 3` | `i *= 3` |
| `/=` | 나누기 후 대입 | `i = i / 3` | `i /= 3` |
| `%=` | 나머지 후 대입 | `i = i % 3` | `i %= 3` |

### 예제 코드

```java
package operator;

public class Assign1 {
    public static void main(String[] args) {
        int a = 5;
        
        a += 3;  // a = a + 3  → a = 8
        a -= 2;  // a = a - 2  → a = 6
        a *= 4;  // a = a * 4  → a = 24
        a /= 3;  // a = a / 3  → a = 8
        a %= 5;  // a = a % 5  → a = 3
        
        System.out.println(a);  // 3
    }
}
```

## 🧩 문제와 풀이

### 문제 1: int와 평균
세 개의 정수 변수를 선언하고 평균을 구하는 프로그램을 작성하세요.

**요구사항:**
1. `num1`, `num2`, `num3` 변수를 각각 10, 20, 30으로 초기화
2. 세 변수의 합을 `sum` 변수에 저장
3. 평균을 `average` 변수에 저장 (소수점 버림)
4. 결과 출력

<details>
<summary>정답 보기</summary>

```java
package operator.ex;

public class OperationEx1 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        int num3 = 30;
        
        int sum = num1 + num2 + num3;
        int average = sum / 3;  // int 나눗셈은 자동으로 소수점 버림
        
        System.out.println(sum);      // 60
        System.out.println(average);  // 20
    }
}
```

</details>

### 문제 2: double과 평균
double 변수들의 평균을 구하는 프로그램을 작성하세요.

```java
double val1 = 1.5;
double val2 = 2.5;
double val3 = 3.5;
```

<details>
<summary>정답 보기</summary>

```java
package operator.ex;

public class OperationEx2 {
    public static void main(String[] args) {
        double val1 = 1.5;
        double val2 = 2.5;
        double val3 = 3.5;
        
        double sum = val1 + val2 + val3;
        double avg = sum / 3;
        
        System.out.println(sum);  // 7.5
        System.out.println(avg);  // 2.5
    }
}
```

</details>

### 문제 3: 합격 범위
점수가 80점 이상이고 100점 이하인지 확인하는 프로그램을 작성하세요.

<details>
<summary>정답 보기</summary>

```java
package operator.ex;

public class OperationEx3 {
    public static void main(String[] args) {
        int score = 80;
        
        boolean result = score >= 80 && score <= 100;
        System.out.println(result);  // true
    }
}
```

</details>

## 🎯 핵심 정리

### 자주 사용하는 연산자
- **산술**: `+`, `-`, `*`, `/`, `%`
- **증감**: `++`, `--`
- **비교**: `==`, `!=`, `>`, `<`, `>=`, `<=`
- **논리**: `&&`, `||`, `!`
- **대입**: `=`, `+=`, `-=`, `*=`, `/=`, `%=`

### 기억할 핵심 원칙

1. **문자열 + 숫자 = 문자열**
2. **문자열 비교는 `.equals()` 사용**
3. **연산자 우선순위는 상식 + 괄호()**
4. **전위(`++a`): 증가 먼저, 후위(`a++`): 사용 먼저**
5. **논리 연산자로 복잡한 조건 표현 가능**

### 다음 학습 주제
- 조건문 (`if`, `else`, `switch`)
- 반복문 (`for`, `while`)
- 배열과 메서드

---

> **개발 철학**: 복잡하면 명확하게! 애매하면 괄호를 사용하여 의도를 명확히 표현하세요.