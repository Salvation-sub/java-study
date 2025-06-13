# Java 클래스와 데이터 완전 가이드

## 목차
1. [클래스가 필요한 이유](#클래스가-필요한-이유)
2. [변수에서 배열로의 발전](#변수에서-배열로의-발전)
3. [배열 사용의 한계](#배열-사용의-한계)
4. [클래스 도입](#클래스-도입)
5. [객체 생성과 사용](#객체-생성과-사용)
6. [참조값과 메모리 구조](#참조값과-메모리-구조)
7. [클래스, 객체, 인스턴스 정리](#클래스-객체-인스턴스-정리)
8. [배열과 객체의 조합](#배열과-객체의-조합)
9. [실무 예제와 패턴](#실무-예제와-패턴)

---

## 클래스가 필요한 이유

### 초기 문제 상황
학생 정보(이름, 나이, 성적)를 관리하는 프로그램을 만들어야 한다고 가정해보자.

### 1단계: 개별 변수 사용
```java
public class ClassStart1 {
    public static void main(String[] args) {
        // 학생1 정보
        String student1Name = "학생1";
        int student1Age = 15;
        int student1Grade = 90;
        
        // 학생2 정보
        String student2Name = "학생2";
        int student2Age = 16;
        int student2Grade = 80;
        
        // 출력
        System.out.println("이름:" + student1Name + " 나이:" + student1Age + " 성적:" + student1Grade);
        System.out.println("이름:" + student2Name + " 나이:" + student2Age + " 성적:" + student2Grade);
    }
}
```

**문제점:**
- 학생이 늘어날 때마다 변수를 추가로 선언해야 함
- 출력하는 코드도 추가해야 함
- 코드 중복이 발생

---

## 변수에서 배열로의 발전

### 2단계: 배열 사용
```java
public class ClassStart2 {
    public static void main(String[] args) {
        String[] studentNames = {"학생1", "학생2"};
        int[] studentAges = {15, 16};
        int[] studentGrades = {90, 80};
        
        for (int i = 0; i < studentNames.length; i++) {
            System.out.println("이름:" + studentNames[i] + 
                " 나이:" + studentAges[i] + 
                " 성적:" + studentGrades[i]);
        }
    }
}
```

**개선점:**
- for문으로 반복 처리 가능
- 학생 추가 시 배열에 데이터만 추가하면 됨

---

## 배열 사용의 한계

### 문제점 분석
```java
// 학생 데이터가 3개의 분리된 배열에 저장됨
String[] studentNames = {"학생1", "학생2", "학생3"};
int[] studentAges = {15, 16, 17};
int[] studentGrades = {90, 80, 100};
```

**한계점:**
1. **데이터 분산**: 한 학생의 데이터가 3개 배열에 나뉘어 저장
2. **인덱스 관리**: 배열들의 인덱스 순서를 정확히 맞춰야 함
3. **데이터 변경의 어려움**: 학생 정보 수정 시 3개 배열 모두 수정 필요
4. **휴먼 에러**: 실수로 인덱스가 틀어질 가능성

### 학생 데이터 삭제 예시
```java
// 학생2 제거 - 3개 배열 모두에서 제거해야 함
String[] studentNames = {"학생1", "학생3", "학생4"};  // 인덱스 1 제거
int[] studentAges = {15, 17, 10};                    // 인덱스 1 제거  
int[] studentGrades = {90, 100, 80};                 // 인덱스 1 제거
```

**결론**: 사람이 관리하기 좋은 방식이 아님. 학생이라는 개념을 하나로 묶어야 함.

---

## 클래스 도입

### Student 클래스 정의
```java
public class Student {
    String name;    // 멤버 변수 (필드)
    int age;
    int grade;
}
```

**클래스의 구성 요소:**
- **class 키워드**: 클래스 정의
- **멤버 변수(Member Variable)**: 클래스에 소속된 변수
- **필드(Field)**: 데이터 항목을 가리키는 용어 (멤버 변수와 동일)

### 클래스 사용
```java
public class ClassStart3 {
    public static void main(String[] args) {
        // 학생1 객체 생성 및 초기화
        Student student1 = new Student();
        student1.name = "학생1";
        student1.age = 15;
        student1.grade = 90;
        
        // 학생2 객체 생성 및 초기화
        Student student2 = new Student();
        student2.name = "학생2";
        student2.age = 16;
        student2.grade = 80;
        
        // 출력
        System.out.println("이름:" + student1.name + " 나이:" + student1.age + " 성적:" + student1.grade);
        System.out.println("이름:" + student2.name + " 나이:" + student2.age + " 성적:" + student2.grade);
    }
}
```

---

## 객체 생성과 사용

### 1. 변수 선언
```java
Student student1;  // Student 타입 변수 선언
```

### 2. 객체 생성
```java
student1 = new Student();  // 새로운 Student 객체 생성
```

**과정 분석:**
- `new Student()`: 메모리에 Student 객체 생성
- 참조값(예: x001) 반환
- `student1` 변수에 참조값 저장

### 3. 객체 사용
```java
// 값 대입
student1.name = "학생1";    // .(dot) 연산자로 객체 접근
student1.age = 15;
student1.grade = 90;

// 값 읽기
System.out.println(student1.name);  // "학생1" 출력
```

---

## 참조값과 메모리 구조

### 메모리 구조 이해
```
student1 변수
┌─────┐
│x001 │ ──────┐
└─────┘       │
              ▼
         ┌─────────────────┐
         │ Student 객체    │
         │ name="학생1"    │
         │ age=15          │
         │ grade=90        │
         └─────────────────┘
         메모리 주소: x001
```

### 참조값 확인
```java
System.out.println(student1);  // class1.Student@7a81197d
System.out.println(student2);  // class1.Student@2f2c9b19
```

**출력 해석:**
- `@` 앞: 패키지 + 클래스 정보
- `@` 뒤: 참조값 (16진수)

### 객체 접근 과정
```java
student1.name = "학생1";

// 실행 과정:
// 1. student1 변수에서 참조값(x001) 읽기
// 2. 참조값으로 메모리의 실제 객체에 접근
// 3. 객체의 name 필드에 "학생1" 저장
```

---

## 클래스, 객체, 인스턴스 정리

### 클래스 (Class)
- **정의**: 객체를 생성하기 위한 '틀' 또는 '설계도'
- **특징**: 실제 메모리에 존재하지 않는 개념적 존재
- **비유**: 붕어빵 틀, 자동차 설계도

```java
public class Student {  // 이것이 클래스 (설계도)
    String name;
    int age;
    int grade;
}
```

### 객체 (Object)
- **정의**: 클래스에서 정의한 속성과 기능을 가진 실체
- **특징**: 메모리에 실제로 존재하며 서로 독립적인 상태를 가짐

```java
Student student1 = new Student();  // student1이 객체
Student student2 = new Student();  // student2도 객체 (별개)
```

### 인스턴스 (Instance)
- **정의**: 특정 클래스로부터 생성된 객체
- **사용**: 특정 클래스와의 관계를 강조할 때 사용

```java
// "student1은 Student의 인스턴스다"
// "student1은 Student 클래스로부터 생성되었다"
```

### 객체 vs 인스턴스
- **공통점**: 둘 다 클래스에서 나온 실체
- **차이점**:
    - 객체: 일반적인 용어
    - 인스턴스: 특정 클래스와의 관계를 명시할 때 사용

---

## 배열과 객체의 조합

### Student 배열 사용
```java
public class ClassStart4 {
    public static void main(String[] args) {
        // 객체 생성
        Student student1 = new Student();
        student1.name = "학생1";
        student1.age = 15;
        student1.grade = 90;
        
        Student student2 = new Student();
        student2.name = "학생2";
        student2.age = 16;
        student2.grade = 80;
        
        // 배열에 객체 저장
        Student[] students = new Student[2];
        students[0] = student1;  // 참조값 복사
        students[1] = student2;  // 참조값 복사
        
        // 배열 사용하여 출력
        for (int i = 0; i < students.length; i++) {
            System.out.println("이름:" + students[i].name + 
                " 나이:" + students[i].age + 
                " 성적:" + students[i].grade);
        }
    }
}
```

### 배열 최적화
```java
// 방법 1: 배열 선언과 초기화
Student[] students = new Student[]{student1, student2};

// 방법 2: 더 간단한 초기화 (선언과 동시에)
Student[] students = {student1, student2};
```

### 향상된 for문 사용
```java
// 기본 for문
for (int i = 0; i < students.length; i++) {
    Student s = students[i];
    System.out.println("이름:" + s.name + " 나이:" + s.age + " 성적:" + s.grade);
}

// 향상된 for문 (Enhanced For Loop)
for (Student s : students) {
    System.out.println("이름:" + s.name + " 나이:" + s.age + " 성적:" + s.grade);
}
```

---

## 실무 예제와 패턴

### 예제 1: 영화 리뷰 시스템
```java
// 클래스 정의
public class MovieReview {
    String title;
    String review;
}

// 사용 예시
public class MovieReviewMain {
    public static void main(String[] args) {
        MovieReview[] reviews = new MovieReview[2];
        
        MovieReview inception = new MovieReview();
        inception.title = "인셉션";
        inception.review = "인생은 무한 루프";
        reviews[0] = inception;
        
        MovieReview aboutTime = new MovieReview();
        aboutTime.title = "어바웃 타임";
        aboutTime.review = "인생 시간 영화!";
        reviews[1] = aboutTime;
        
        // 출력
        for (MovieReview review : reviews) {
            System.out.println("영화 제목: " + review.title + 
                ", 리뷰: " + review.review);
        }
    }
}
```

### 예제 2: 상품 주문 시스템
```java
// 클래스 정의
public class ProductOrder {
    String productName;
    int price;
    int quantity;
}

// 사용 예시
public class ProductOrderMain {
    public static void main(String[] args) {
        ProductOrder[] orders = new ProductOrder[3];
        
        // 주문 정보 입력
        ProductOrder order1 = new ProductOrder();
        order1.productName = "두부";
        order1.price = 2000;
        order1.quantity = 2;
        orders[0] = order1;
        
        ProductOrder order2 = new ProductOrder();
        order2.productName = "김치";
        order2.price = 5000;
        order2.quantity = 1;
        orders[1] = order2;
        
        ProductOrder order3 = new ProductOrder();
        order3.productName = "콜라";
        order3.price = 1500;
        order3.quantity = 2;
        orders[2] = order3;
        
        // 주문 정보 출력 및 총액 계산
        int totalAmount = 0;
        for (ProductOrder order : orders) {
            System.out.println("상품명: " + order.productName + 
                ", 가격: " + order.price + 
                ", 수량: " + order.quantity);
            totalAmount += order.price * order.quantity;
        }
        System.out.println("총 결제 금액: " + totalAmount);
    }
}
```

---

## 핵심 개념 정리

### 1. 클래스의 필요성
- **데이터 그룹핑**: 관련된 데이터를 하나로 묶어 관리
- **사용자 정의 타입**: `int`, `String`처럼 개발자가 직접 정의한 타입
- **코드 구조화**: 데이터와 관련 기능을 체계적으로 관리

### 2. 메모리와 참조의 이해
- **참조값**: 객체의 메모리 주소를 가리키는 값
- **객체 접근**: 참조값을 통해 실제 객체에 접근
- **값 복사 원칙**: Java는 항상 변수의 값을 복사해서 전달

### 3. 배열과 객체의 조합
- **객체 배열**: 같은 타입의 객체들을 배열로 관리
- **참조값 저장**: 배열에는 객체 자체가 아닌 참조값이 저장됨
- **반복 처리**: for문으로 여러 객체를 일괄 처리

### 4. 설계 원칙
- **응집성**: 관련된 데이터는 하나의 클래스로 묶기
- **가독성**: 사람이 이해하기 쉬운 구조로 설계
- **확장성**: 새로운 데이터 추가 시 최소한의 코드 변경

---

## 다음 단계

이 문서에서 학습한 클래스와 객체의 기본 개념을 바탕으로 다음 단계로 진행할 수 있습니다:

1. **생성자 (Constructor)**: 객체 생성 시 초기화 자동화
2. **메서드**: 클래스에 기능 추가
3. **캡슐화**: 데이터 보호와 접근 제어
4. **상속**: 클래스 간의 관계와 재사용
5. **다형성**: 하나의 인터페이스로 다양한 구현

클래스와 객체는 Java의 핵심 개념으로, 모든 고급 기능의 기반이 됩니다. 이 기초를 확실히 이해하고 넘어가시기 바랍니다.