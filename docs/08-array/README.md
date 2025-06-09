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

## 핵심 포인트

1. **배열 선언**: `int[] arr = new int[크기];`
2. **배열 초기화**: `int[] arr = {값1, 값2, 값3};`
3. **인덱스는 0부터 시작**
4. **배열 길이**: `arr.length`
5. **2차원 배열**: `int[][] arr = new int[행][열];`
6. **향상된 for문**: 인덱스 없이 배열 순회
7. **참조형**: 배열은 참조값을 저장하는 참조형 타입