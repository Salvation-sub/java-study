# Java 반복문 (Loop Statements)

## 목차
- [반복문 시작](#반복문-시작)
- [while문](#while문)
- [do-while문](#do-while문)
- [break, continue](#break-continue)
- [for문](#for문)
- [중첩 반복문](#중첩-반복문)
- [문제와 풀이](#문제와-풀이)
- [정리](#정리)

---

## 반복문 시작

반복문은 이름 그대로 특정 코드를 반복해서 실행할 때 사용합니다.

자바는 다음 3가지 종류의 반복문을 제공합니다:
- **while**
- **do-while**
- **for**

### 반복문이 필요한 이유

1을 한 번씩 더해서 총 3번 더하는 코드를 반복문 없이 작성하면:

```java
package loop;

public class While1_1 {
    public static void main(String[] args) {
        int count = 0;
        count = count + 1;
        System.out.println("현재 숫자는:" + count);
        count = count + 1;
        System.out.println("현재 숫자는:" + count);
        count = count + 1;
        System.out.println("현재 숫자는:" + count);
    }
}
```

**실행 결과:**
```
현재 숫자는:1
현재 숫자는:2
현재 숫자는:3
```

같은 코드가 3번 반복되고 있습니다. 만약 100번 더해야 한다면? 같은 코드를 100번 작성해야 할 것입니다.

이렇게 특정 코드를 반복해서 실행할 때 사용하는 것이 바로 **반복문**입니다.

---

## while문

while문은 조건에 따라 코드를 반복해서 실행할 때 사용합니다.

### while문 구조
```java
while (조건식) {
    // 코드
}
```

### 실행 순서
1. 조건식을 확인한다. 참이면 코드 블럭을 실행하고, 거짓이면 while문을 벗어난다.
2. 조건식이 참이면 코드 블럭을 실행한다.
3. 코드 블럭이 끝나면 다시 조건식 검사로 돌아간다. (무한 반복)

### 예제 1: 기본 while문

```java
package loop;

public class While1_2 {
    public static void main(String[] args) {
        int count = 0;
        while (count < 3) {
            count++;
            System.out.println("현재 숫자는:" + count);
        }
    }
}
```

**실행 결과:**
```
현재 숫자는:1
현재 숫자는:2
현재 숫자는:3
```

### 예제 2: 누적 합계 구하기

**문제:** 1부터 하나씩 증가하는 수를 endNum까지 더하기

```java
package loop;

public class While2_3 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        int endNum = 3;
        
        while (i <= endNum) {
            sum = sum + i;
            System.out.println("i=" + i + " sum=" + sum);
            i++;
        }
    }
}
```

**실행 결과:**
```
i=1 sum=1
i=2 sum=3
i=3 sum=6
```

---

## do-while문

do-while문은 while문과 비슷하지만, **조건에 상관없이 무조건 한 번은 코드를 실행**합니다.

### do-while문 구조
```java
do {
    // 코드
} while (조건식);
```

### while vs do-while 비교

**while문 예제:**
```java
package loop;

public class DoWhile1 {
    public static void main(String[] args) {
        int i = 10;
        while (i < 3) {
            System.out.println("현재 숫자는:" + i);
            i++;
        }
    }
}
```
**실행 결과:** (아무것도 출력되지 않음)

**do-while문 예제:**
```java
package loop;

public class DoWhile2 {
    public static void main(String[] args) {
        int i = 10;
        do {
            System.out.println("현재 숫자는:" + i);
            i++;
        } while (i < 3);
    }
}
```
**실행 결과:**
```
현재 숫자는:10
```

do-while문은 **최초 한번은 코드 블럭을 꼭 실행해야 하는 경우**에 사용합니다.

---

## break, continue

break와 continue는 반복문에서 사용할 수 있는 키워드입니다.

### break
- 반복문을 **즉시 종료**하고 나갑니다.

```java
while(조건식) {
    코드1;
    break; // 즉시 while문 종료로 이동
    코드2; // 실행되지 않음
}
```

### continue
- 반복문의 나머지 부분을 건너뛰고 **다음 반복으로 진행**합니다.

```java
while(조건식) {
    코드1;
    continue; // 즉시 조건식으로 이동
    코드2; // 실행되지 않음
}
```

### break 예제

**문제:** 1부터 시작해서 숫자를 계속 누적해서 더하다가 합계가 10보다 처음으로 큰 값은 얼마인가?

```java
package loop;

public class Break1 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        
        while (true) {
            sum += i;
            if (sum > 10) {
                System.out.println("합이 10보다 크면 종료: i=" + i + " sum=" + sum);
                break;
            }
            i++;
        }
    }
}
```

**실행 결과:**
```
합이 10보다 크면 종료: i=5 sum=15
```

### continue 예제

**문제:** 1부터 5까지 숫자를 출력하는데, 숫자가 3일 때는 출력을 건너뛰기

```java
package loop;

public class Continue1 {
    public static void main(String[] args) {
        int i = 1;
        
        while (i <= 5) {
            if (i == 3) {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }
    }
}
```

**실행 결과:**
```
1
2
4
5
```

---

## for문

for문도 while문과 같은 반복문이며, 코드를 반복 실행하는 역할을 합니다.
for문은 주로 **반복 횟수가 정해져 있을 때** 사용합니다.

### for문 구조
```java
for (1.초기식; 2.조건식; 4.증감식) {
    // 3.코드
}
```

### for문 실행 순서
1. **초기식**이 실행된다. (딱 1번만 실행)
2. **조건식**을 검증한다. 참이면 코드를 실행하고, 거짓이면 for문을 빠져나간다.
3. **코드**를 실행한다.
4. 코드가 종료되면 **증감식**을 실행한다.
5. 다시 2번 조건식부터 시작한다. (무한 반복)

### 기본 for문 예제

```java
package loop;

public class For1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }
}
```

### for문으로 누적 합계 구하기

```java
package loop;

public class For2 {
    public static void main(String[] args) {
        int sum = 0;
        int endNum = 3;
        
        for (int i = 1; i <= endNum; i++) {
            sum = sum + i;
            System.out.println("i=" + i + " sum=" + sum);
        }
    }
}
```

**실행 결과:**
```
i=1 sum=1
i=2 sum=3
i=3 sum=6
```

### for vs while 비교

**while문:**
```java
int sum = 0;
int i = 1;
int endNum = 3;

while (i <= endNum) {
    sum = sum + i;
    System.out.println("i=" + i + " sum=" + sum);
    i++;
}
```

**for문:**
```java
int sum = 0;
int endNum = 3;

for (int i = 1; i <= endNum; i++) {
    sum = sum + i;
    System.out.println("i=" + i + " sum=" + sum);
}
```

for문이 더 깔끔합니다. **초기화, 조건 검사, 반복 후 작업**이 규칙적으로 한 줄에 모두 들어있어 코드를 이해하기 더 쉽습니다.

### for문의 유연성

for문에서 초기식, 조건식, 증감식은 선택사항입니다. 모두 생략해도 되지만 세미콜론(;)은 유지해야 합니다.

```java
for (;;) {
    // 무한 반복
}
```

### for문에서 break 사용

```java
package loop;

public class Break2 {
    public static void main(String[] args) {
        int sum = 0;
        
        for (int i = 1; ; i++) {
            sum += i;
            if (sum > 10) {
                System.out.println("합이 10보다 크면 종료: i=" + i + " sum=" + sum);
                break;
            }
        }
    }
}
```

---

## 중첩 반복문

반복문은 내부에 또 반복문을 만들 수 있습니다. for, while 모두 가능합니다.

### 중첩 for문 예제

```java
package loop;

public class Nested1 {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            System.out.println("외부 for 시작 i:" + i);
            for (int j = 0; j < 3; j++) {
                System.out.println("-> 내부 for " + i + "-" + j);
            }
            System.out.println("외부 for 종료 i:" + i);
            System.out.println(); // 라인 구분을 위해 실행
        }
    }
}
```

**실행 결과:**
```
외부 for 시작 i:0
-> 내부 for 0-0
-> 내부 for 0-1
-> 내부 for 0-2
외부 for 종료 i:0

외부 for 시작 i:1
-> 내부 for 1-0
-> 내부 for 1-1
-> 내부 for 1-2
외부 for 종료 i:1
```

외부 for는 2번, 내부 for는 3번 실행되므로, 외부(2) × 내부(3) = 총 6번의 내부 for 코드가 수행됩니다.

---

## 문제와 풀이

### 문제 1: 자연수 출력
처음 10개의 자연수를 출력하는 프로그램을 작성하세요.

**while문 해답:**
```java
package loop.ex;

public class WhileEx1 {
    public static void main(String[] args) {
        int count = 1;
        while (count <= 10) {
            System.out.println(count);
            count++;
        }
    }
}
```

**for문 해답:**
```java
package loop.ex;

public class ForEx1 {
    public static void main(String[] args) {
        for (int count = 1; count <= 10; count++) {
            System.out.println(count);
        }
    }
}
```

### 문제 2: 짝수 출력
처음 10개의 짝수를 출력하는 프로그램을 작성하세요.

**while문 해답:**
```java
package loop.ex;

public class WhileEx2 {
    public static void main(String[] args) {
        int num = 2;
        int count = 1;
        while (count <= 10) {
            System.out.println(num);
            num += 2;
            count++;
        }
    }
}
```

**for문 해답:**
```java
package loop.ex;

public class ForEx2 {
    public static void main(String[] args) {
        for (int num = 2, count = 1; count <= 10; num += 2, count++) {
            System.out.println(num);
        }
    }
}
```

### 문제 3: 누적 합 계산
1부터 max까지의 합을 계산하고 출력하는 프로그램을 작성하세요.

**while문 해답:**
```java
package loop.ex;

public class WhileEx3 {
    public static void main(String[] args) {
        int max = 100;
        int sum = 0;
        int i = 1;
        
        while (i <= max) {
            sum += i;
            i++;
        }
        System.out.println(sum);
    }
}
```

**for문 해답:**
```java
package loop.ex;

public class ForEx3 {
    public static void main(String[] args) {
        int max = 100;
        int sum = 0;
        
        for (int i = 1; i <= max; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
```

### 문제 4: 구구단 출력
중첩 for문을 사용해서 구구단을 완성하세요.

```java
package loop.ex;

public class NestedEx1 {
    public static void main(String[] args) {
        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                System.out.println(i + " * " + j + " = " + i * j);
            }
        }
    }
}
```

### 문제 5: 피라미드 출력
rows 수만큼 피라미드를 출력하세요.

```java
package loop.ex;

public class NestedEx2 {
    public static void main(String[] args) {
        int rows = 5;
        
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
```

**실행 결과:**
```
*
**
***
****
*****
```

---

## 정리

### while vs for

#### for문
**장점:**
1. 초기화, 조건 체크, 반복 후의 작업을 한 줄에서 처리할 수 있어 편리하다.
2. 정해진 횟수만큼의 반복을 수행하는 경우에 사용하기 적합하다.
3. 루프 변수의 범위가 for 루프 블록에 제한되므로, 다른 곳에서 이 변수를 실수로 변경할 가능성이 적다.

**단점:**
1. 루프의 조건이 루프 내부에서 변경되는 경우, for 루프는 관리하기 어렵다.
2. 복잡한 조건을 가진 반복문을 작성하기에는 while문이 더 적합할 수 있다.

#### while문
**장점:**
1. 루프의 조건이 루프 내부에서 변경되는 경우, while 루프는 이를 관리하기 쉽다.
2. for 루프보다 더 복잡한 조건과 시나리오에 적합하다.
3. 조건이 충족되는 동안 계속해서 루프를 실행하며, 종료 시점을 명확하게 알 수 없는 경우에 유용하다.

**단점:**
1. 초기화, 조건 체크, 반복 후의 작업이 분산되어 있어 코드를 이해하거나 작성하기 어려울 수 있다.
2. 루프 변수가 while 블록 바깥에서도 접근 가능하므로, 이 변수를 실수로 변경하는 상황이 발생할 수 있다.

### 사용 가이드

**한줄로 정리:** 정해진 횟수만큼 반복을 수행해야 하면 **for문**을 사용하고, 그렇지 않으면 **while문**을 사용하면 됩니다.

---

## 핵심 포인트

1. **while문**: 조건이 참인 동안 반복 실행
2. **do-while문**: 최소 1번은 실행 후 조건 확인
3. **for문**: 반복 횟수가 정해진 경우에 적합
4. **break**: 반복문을 즉시 종료
5. **continue**: 현재 반복을 건너뛰고 다음 반복으로
6. **중첩 반복문**: 반복문 안에 또 다른 반복문 사용 가능

각 반복문의 특성을 이해하고 상황에 맞게 선택하여 사용하는 것이 중요합니다.