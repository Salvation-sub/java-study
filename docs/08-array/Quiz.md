# 자바 배열 사용 가이드

## 배열의 필요한 이유

학생의 점수를 출력하는 간단한 프로그램에서 여러 변수를 사용하는 문제:

```java
int student1 = 90;
int student2 = 80;
int student3 = 70;
int student4 = 60;
int student5 = 50;
```

**문제점:**
- 학생 수가 증가하면 변수도 계속 추가해야 함
- 비슷한 변수를 반복해서 선언
- 변수 이름이 달라서 반복문 사용 불가

## 배열의 선언과 생성

### 1. 배열 변수 선언
```java
int[] students; // 배열 변수 선언
```

### 2. 배열 생성
```java
students = new int[5]; // 배열 생성
```

### 3. 배열 참조값 보관
- `new int[5]`로 배열 생성하면 참조값(예: x001) 반환
- 배열 변수에 참조값 저장

### 배열과 초기화
- 배열 생성 시 자동으로 초기화됨
- 숫자는 0, boolean은 false, String은 null

## 배열 사용법

### 인덱스를 통한 접근
```java
// 값 대입
students[0] = 90;
students[1] = 80;

// 값 사용
System.out.println("학생1 점수: " + students[0]);
```

### 주의사항
- 배열은 0부터 시작
- `new int[5]`의 경우 인덱스는 0,1,2,3,4
- 범위를 벗어나면 `ArrayIndexOutOfBoundsException` 발생

## 기본형 vs 참조형

### 기본형 (Primitive Type)
- `int`, `long`, `double`, `boolean`
- 변수에 사용할 값을 직접 저장
- 크기가 명확하게 정해짐

### 참조형 (Reference Type)
- `int[]` 같은 배열
- 메모리의 참조값(주소) 저장
- 동적으로 크기 할당 가능

## 배열 리팩토링

### 1단계: 기본 배열 사용
```java
int[] students = new int[5];
students[0] = 90;
students[1] = 80;
// ... 값 대입

// 출력
for (int i = 0; i < students.length; i++) {
    System.out.println("학생" + (i + 1) + " 점수: " + students[i]);
}
```

### 2단계: 배열 초기화
```java
// 방법 1
int[] students = new int[]{90, 80, 70, 60, 50};

// 방법 2 (간단한 방법)
int[] students = {90, 80, 70, 60, 50};
```

### 3단계: 배열 길이 활용
```java
for (int i = 0; i < students.length; i++) {
    System.out.println("학생" + (i + 1) + " 점수: " + students[i]);
}
```

## 2차원 배열

### 선언과 생성
```java
int[][] arr = new int[2][3]; // 2행 3열
```

### 값 대입과 사용
```java
arr[0][0] = 1; // 0행 0열
arr[0][1] = 2; // 0행 1열
arr[1][0] = 4; // 1행 0열

// 출력
for (int row = 0; row < arr.length; row++) {
    for (int column = 0; column < arr[row].length; column++) {
        System.out.print(arr[row][column] + " ");
    }
    System.out.println();
}
```

### 2차원 배열 초기화
```java
int[][] arr = {
    {1, 2, 3},
    {4, 5, 6}
};
```

### 배열의 길이
- `arr.length`: 행의 길이
- `arr[row].length`: 열의 길이

## 향상된 for문 (Enhanced For Loop)

### 기본 문법
```java
for (변수 : 배열 또는 컬렉션) {
    // 배열 요소를 순회하면서 수행할 작업
}
```

### 예제
```java
int[] numbers = {1, 2, 3, 4, 5};

// 일반 for문
for (int i = 0; i < numbers.length; i++) {
    int number = numbers[i];
    System.out.println(number);
}

// 향상된 for문
for (int number : numbers) {
    System.out.println(number);
}
```

### 사용 제한
- 인덱스 값이 필요한 경우 사용 불가
- 배열을 순서대로 처음부터 끝까지 탐색할 때만 사용

## 실습 예제

### 예제 1: 배열을 사용한 점수 관리
```java
public class ArrayEx1Ref {
    public static void main(String[] args) {
        int[] students = {90, 80, 70, 60, 50};
        int total = 0;
        
        for (int i = 0; i < students.length; i++) {
            total += students[i];
        }
        
        double average = (double) total / students.length;
        System.out.println("점수 총합: " + total);
        System.out.println("점수 평균: " + average);
    }
}
```

### 예제 2: 사용자 입력과 배열
```java
public class ArrayEx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        
        System.out.println("5개의 정수를 입력하세요:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        System.out.println("출력");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
```

### 예제 3: 최댓값과 최솟값 찾기
```java
public class ArrayEx6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력받을 숫자의 개수를 입력하세요:");
        int n = scanner.nextInt();
        
        int[] numbers = new int[n];
        int minNumber, maxNumber;
        
        System.out.println(n + "개의 정수를 입력하세요:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        minNumber = maxNumber = numbers[0];
        for (int i = 1; i < n; i++) {
            if (numbers[i] < minNumber) {
                minNumber = numbers[i];
            }
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }
        }
        
        System.out.println("가장 작은 정수: " + minNumber);
        System.out.println("가장 큰 정수: " + maxNumber);
    }
}
```

### 예제 4: 2차원 배열 - 학생 성적 관리
```java
public class ArrayEx7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] scores = new int[4][3];
        String[] subjects = {"국어", "영어", "수학"};
        
        // 성적 입력
        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + "번 학생의 성적을 입력하세요:");
            for (int j = 0; j < 3; j++) {
                System.out.print(subjects[j] + " 점수:");
                scores[i][j] = scanner.nextInt();
            }
        }
        
        // 총점과 평균 계산
        for (int i = 0; i < 4; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                total += scores[i][j];
            }
            double average = total / 3.0;
            System.out.println((i + 1) + "번 학생의 총점: " + total + 
                ", 평균: " + average);
        }
    }
}
```

## 배열 이해도 퀴즈

### 퀴즈 1: 배열 사용의 주된 이유
**Q: 배열을 사용하는 주된 이유는 무엇일까요?**

**선택지:**
- A. 변수 이름을 다양하게 만들 수 있어서
- B. 동일 타입 변수를 효율적으로 관리하기 위해 ✅
- C. 코드 실행 속도가 항상 빨라져서
- D. 어떤 타입의 변수든 함께 저장 가능해서

**해설:**
동일 타입 변수를 하나의 이름으로 묶어 관리하며, 코드 중복을 줄이고 확장성을 높여줍니다. 개별 변수 방식의 비효율성을 개선하죠.

### 퀴즈 2: 배열 변수와 기본 타입 변수의 차이
**Q: 배열 변수가 기본 타입 변수와 다른 점은 무엇일까요?**

**선택지:**
- A. 실제 값을 직접 저장한다
- B. 메모리 주소(참조 값)를 저장한다 ✅
- C. 크기가 고정되어 변경할 수 없다
- D. 선언과 동시에 값을 할당해야 한다

**해설:**
배열 변수는 실제 배열 데이터가 있는 메모리 공간의 주소를 가리킵니다. 기본 타입은 변수 자체에 값을 저장하죠.

### 퀴즈 3: new int[5]의 역할
**Q: `new int[5]` 코드가 하는 역할은 무엇일까요?**

**선택지:**
- A. 크기가 5인 정수 배열 변수를 선언한다
- B. 메모리에 정수 5개를 저장할 공간을 할당한다 ✅
- C. 배열 변수에 직접 5를 할당한다
- D. 정수 5를 배열의 첫 번째 요소에 저장한다

**해설:**
`new` 키워드는 메모리 공간을 새로 만드는 역할을 합니다. `int[5]`는 정수 5개를 저장할 연속된 공간을 만든다는 의미입니다.

### 퀴즈 4: 배열 요소 접근 방법
**Q: 배열에서 특정 위치의 요소에 접근하려면 무엇을 사용해야 할까요?**

**선택지:**
- A. 변수 이름만
- B. 배열의 크기
- C. 인덱스 ✅
- D. 참조 값

**해설:**
배열은 0부터 시작하는 순서 번호인 인덱스를 이용해 각 요소에 접근합니다. 배열 이름 뒤에 대괄호와 인덱스를 사용하죠.

### 퀴즈 5: 배열 인덱스 범위 초과 시 결과
**Q: 배열의 유효한 범위를 벗어나는 인덱스를 사용하면 어떻게 될까요?**

**선택지:**
- A. 자동으로 가장 가까운 인덱스로 이동한다
- B. 배열의 크기가 자동으로 늘어난다
- C. 컴파일 오류가 발생한다
- D. 런타임 예외(오류)가 발생한다 ✅

**해설:**
배열은 선언 시 정해진 크기 내에서만 접근해야 합니다. 범위를 벗어나면 실행 중 'ArrayIndexOutOfBoundsException' 예외가 발생합니다.

### 퀴즈 6: 리팩토링의 의미
**Q: 리팩토링(Refactoring)은 무엇을 의미할까요?**

**선택지:**
- A. 기능 변경 없이 코드 내부 구조를 개선하는 것 ✅
- B. 새로운 기능을 추가하는 것
- C. 기존 코드를 완전히 새로 작성하는 것
- D. 코드의 버그를 모두 수정하는 것

**해설:**
리팩토링은 프로그램의 동작은 유지하면서 코드를 더 읽기 쉽고 유지보수하기 좋게 만드는 작업입니다. 코드의 설계 품질을 높이죠.

### 퀴즈 7: 2차원 배열의 행 개수 구하기
**Q: 2차원 배열 `int[][] arr`에서 전체 행의 개수를 얻으려면 어떻게 해야 할까요?**

**선택지:**
- A. arr[0].length
- B. arr.length ✅
- C. arr.size()
- D. arr[].length

**해설:**
2차원 배열 `arr`은 여러 개의 1차원 배열(행)을 담고 있습니다. `arr.length`는 이 1차원 배열들의 개수, 즉 행의 수를 반환합니다.

### 퀴즈 8: 2차원 배열 순회 구조
**Q: 2차원 배열의 각 요소에 접근하며 순회할 때, 행과 열 인덱스를 모두 사용하는 일반적인 반복 구조는 무엇일까요?**

**선택지:**
- A. 단일 for 문
- B. 향상된 for 문
- C. 이중 for 문 ✅
- D. while 문

**해설:**
2차원 배열은 행과 열, 두 개의 차원을 가지므로, 바깥 for 문이 행을, 안쪽 for 문이 열을 순회하는 이중 for 문이 흔히 사용됩니다.

### 퀴즈 9: 향상된 for문의 이점
**Q: 향상된 for 문(for-each loop)을 사용하는 주된 이점은 무엇일까요?**

**선택지:**
- A. 배열 요소의 값을 쉽게 변경할 수 있다
- B. 코드 작성 시 인덱스 관리가 필요 없다 ✅
- C. 어떤 종류의 반복 작업이든 가능하다
- D. 배열의 크기를 동적으로 조절할 수 있다

**해설:**
향상된 for 문은 배열의 시작부터 끝까지 순차적으로 요소를 읽어올 때 인덱스 변수를 직접 관리할 필요가 없어 코드가 간결해집니다.

### 퀴즈 10: 향상된 for문 사용 제한
**Q: 향상된 for 문을 사용하기 어려운 경우는 언제일까요?**

**선택지:**
- A. 배열의 모든 요소를 순회할 때
- B. 배열 요소의 값을 읽기만 할 때
- C. 현재 요소의 '인덱스' 값이 필요할 때 ✅
- D. 배열의 크기가 작을 때

**해설:**
향상된 for 문은 내부적으로 인덱스를 숨기므로, 반복문 내에서 현재 요소의 인덱스 값이 필요한 작업에는 적합하지 않습니다. 이럴 땐 일반 for 문을 씁니다.

## 핵심 포인트

1. **배열 선언**: `int[] arr = new int[크기];`
2. **배열 초기화**: `int[] arr = {값1, 값2, 값3};`
3. **인덱스는 0부터 시작**
4. **배열 길이**: `arr.length`
5. **2차원 배열**: `int[][] arr = new int[행][열];`
6. **향상된 for문**: 인덱스 없이 배열 순회
7. **참조형**: 배열은 참조값을 저장하는 참조형 타입