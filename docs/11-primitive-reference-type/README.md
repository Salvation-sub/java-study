# Java 기본형과 참조형

## 📋 개요
이 문서는 Java에서 가장 중요한 개념 중 하나인 기본형(Primitive Type)과 참조형(Reference Type)의 차이점과 동작 원리를 다룹니다.

## 🎯 학습 목표
- 기본형과 참조형의 개념과 차이점 이해
- 변수 대입 시 값 복사 원리 파악
- 메서드 호출 시 매개변수 전달 방식 이해
- null과 NullPointerException 개념 습득
- 변수 초기화 규칙 이해

## 📚 목차
1. [기본형 vs 참조형 - 시작](#기본형-vs-참조형---시작)
2. [기본형 vs 참조형 - 변수 대입](#기본형-vs-참조형---변수-대입)
3. [기본형 vs 참조형 - 메서드 호출](#기본형-vs-참조형---메서드-호출)
4. [참조형과 메서드 호출 - 활용](#참조형과-메서드-호출---활용)
5. [변수와 초기화](#변수와-초기화)
6. [null](#null)
7. [NullPointerException](#nullpointerexception)

## 🔍 기본형 vs 참조형 - 시작

### 기본 개념
**자바에서 참조형을 제대로 이해하는 것은 정말 중요합니다.**

변수의 데이터 타입은 크게 두 가지로 분류됩니다:

#### 🟦 기본형 (Primitive Type)
- `int`, `long`, `double`, `boolean` 등
- **변수에 사용할 값을 직접 넣을 수 있는 데이터 타입**
- 실제 사용하는 값이 변수에 바로 들어있음

#### 🟨 참조형 (Reference Type)
- `Student student1`, `int[] students` 등
- **데이터에 접근하기 위한 참조(주소)를 저장하는 데이터 타입**
- 객체 또는 배열에 사용
- 객체의 위치(참조값)가 들어가 있음

### 핵심 차이점

| 구분 | 기본형 | 참조형 |
|------|--------|--------|
| **저장 내용** | 실제 사용하는 값 | 객체의 메모리 위치(참조값) |
| **접근 방법** | 직접 사용 | `.`(dot)을 통해 객체에 접근 |
| **연산** | 산술 연산 가능 | 산술 연산 불가능 |
| **예시** | `int a = 10` | `Student s = new Student()` |

### 💡 쉽게 이해하는 팁
- **기본형을 제외한 나머지는 모두 참조형**
- **기본형은 소문자로 시작** (`int`, `boolean` 등)
- **클래스는 대문자로 시작하며 모두 참조형** (`Student`, `String` 등)

### 연산 예시

```java
// 기본형 - 연산 가능
int a = 10, b = 20;
int sum = a + b; // ✅ 정상 동작

// 참조형 - 연산 불가능
Student s1 = new Student();
Student s2 = new Student();
s1 + s2; // ❌ 오류 발생

// 참조형에서 멤버 변수 연산은 가능
s1.grade = 100;
s2.grade = 90;
int sum = s1.grade + s2.grade; // ✅ 정상 동작
```

## 🔄 기본형 vs 참조형 - 변수 대입

### 🎯 대원칙
**자바는 항상 변수의 값을 복사해서 대입한다.**

### 기본형 변수 대입

```java
int a = 10;
int b = a; // a의 값(10)을 복사해서 b에 대입

// a 변경
a = 20;
System.out.println("a = " + a); // 20
System.out.println("b = " + b); // 10 (변경되지 않음)
```

**결과**: `a`와 `b`는 각각 독립적인 값을 가짐

### 참조형 변수 대입

```java
Data dataA = new Data();
dataA.value = 10;
Data dataB = dataA; // dataA의 참조값을 복사해서 dataB에 대입

// dataA를 통해 값 변경
dataA.value = 20;
System.out.println("dataA.value = " + dataA.value); // 20
System.out.println("dataB.value = " + dataB.value); // 20 (함께 변경됨!)
```

**결과**: `dataA`와 `dataB`는 같은 객체를 참조하므로 값이 함께 변경됨

### 📊 메모리 구조 이해

#### 기본형 대입
```
int a = 10;     [a: 10]
int b = a;      [a: 10] [b: 10] (값 복사)
```

#### 참조형 대입
```
Data dataA = new Data();    [dataA: x001] → [Data 객체: value=10]
Data dataB = dataA;         [dataA: x001] → [Data 객체: value=10]
                           [dataB: x001] → (같은 객체를 참조)
```

## 🔧 기본형 vs 참조형 - 메서드 호출

### 기본형과 메서드 호출

```java
public static void main(String[] args) {
    int a = 10;
    System.out.println("메서드 호출 전: a = " + a); // 10
    changePrimitive(a);
    System.out.println("메서드 호출 후: a = " + a); // 10 (변경되지 않음)
}

static void changePrimitive(int x) {
    x = 20; // 복사된 값만 변경
}
```

### 참조형과 메서드 호출

```java
public static void main(String[] args) {
    Data dataA = new Data();
    dataA.value = 10;
    System.out.println("메서드 호출 전: dataA.value = " + dataA.value); // 10
    changeReference(dataA);
    System.out.println("메서드 호출 후: dataA.value = " + dataA.value); // 20 (변경됨!)
}

static void changeReference(Data dataX) {
    dataX.value = 20; // 같은 객체의 값을 변경
}
```

### 🔑 핵심 포인트
- **기본형**: 메서드 내부에서 매개변수 값을 변경해도 호출자의 변수에 영향 없음
- **참조형**: 메서드 내부에서 객체의 멤버 변수를 변경하면 호출자의 객체도 변경됨

## 🛠️ 참조형과 메서드 호출 - 활용

### 메서드에 객체 전달하기

```java
// Student 클래스
public class Student {
    String name;
    int age;
    int grade;
}

// 메서드를 활용한 코드 개선
public class Method1 {
    public static void main(String[] args) {
        Student student1 = new Student();
        initStudent(student1, "학생1", 15, 90);
        
        Student student2 = new Student();
        initStudent(student2, "학생2", 16, 80);
        
        printStudent(student1);
        printStudent(student2);
    }
    
    // 학생 정보 초기화 메서드
    static void initStudent(Student student, String name, int age, int grade) {
        student.name = name;
        student.age = age;
        student.grade = grade;
    }
    
    // 학생 정보 출력 메서드
    static void printStudent(Student student) {
        System.out.println("이름:" + student.name + " 나이:" + student.age + " 성적:" + student.grade);
    }
}
```

### 메서드에서 객체 반환하기

```java
public class Method2 {
    public static void main(String[] args) {
        Student student1 = createStudent("학생1", 15, 90);
        Student student2 = createStudent("학생2", 16, 80);
        
        printStudent(student1);
        printStudent(student2);
    }
    
    // 객체 생성과 초기화를 한 번에 처리
    static Student createStudent(String name, int age, int grade) {
        Student student = new Student();
        student.name = name;
        student.age = age;
        student.grade = grade;
        return student; // 참조값 반환
    }
}
```

## 📝 변수와 초기화

### 변수의 종류

#### 🏷️ 멤버 변수 (필드)
- **위치**: 클래스에 선언
- **초기화**: 자동 초기화
- **초기값**:
    - 숫자형: `0`
    - boolean: `false`
    - 참조형: `null`

```java
public class Student {
    String name;    // 자동으로 null로 초기화
    int age;        // 자동으로 0으로 초기화
    int grade = 90; // 직접 초기값 지정
}
```

#### 🏷️ 지역 변수
- **위치**: 메서드에 선언
- **초기화**: 수동 초기화 (반드시 필요)
- **생명주기**: 메서드 종료 시 제거

```java
public static void main(String[] args) {
    int a;           // 선언만 함
    a = 10;          // 반드시 초기화 필요
    System.out.println(a); // 초기화 후 사용 가능
}
```

## ⚠️ null

### null의 개념
- **의미**: "값이 존재하지 않는, 없다"는 뜻
- **용도**: 참조형 변수에서 아직 가리키는 대상이 없을 때 사용
- **특징**: 기본형에는 사용할 수 없음

### null 사용 예시

```java
public class NullMain1 {
    public static void main(String[] args) {
        Data data = null;                    // null 할당
        System.out.println("1. data = " + data); // null 출력
        
        data = new Data();                   // 객체 생성 후 할당
        System.out.println("2. data = " + data); // 참조값 출력
        
        data = null;                         // 다시 null 할당
        System.out.println("3. data = " + data); // null 출력
    }
}
```

### 🗑️ GC (가비지 컬렉션)
참조하는 곳이 없어진 객체는 JVM의 **가비지 컬렉션**이 자동으로 메모리에서 제거합니다.

## ❌ NullPointerException

### 발생 원인
**null 값에 `.`(dot)을 사용할 때 발생하는 예외**

```java
Data data = null;
data.value = 10; // ❌ NullPointerException 발생!
```

### 예외 발생 과정
```java
data.value = 10
↓
null.value = 10  // data에는 null이 들어있음
↓
NullPointerException // null에 .을 찍으면 예외 발생
```

### 해결 방법

```java
// ❌ 문제가 되는 코드
BigData bigData = new BigData();
System.out.println(bigData.data.value); // data가 null이므로 예외 발생

// ✅ 해결된 코드
BigData bigData = new BigData();
bigData.data = new Data(); // 객체를 생성해서 할당
System.out.println(bigData.data.value); // 정상 동작
```

### 💡 NullPointerException 해결 팁
1. **객체가 null인지 확인**
2. **필요한 경우 객체를 생성해서 할당**
3. **null 체크 로직 추가**

## 📋 정리

### 🎯 핵심 원칙
**자바는 항상 변수의 값을 복사해서 대입한다.**

### 주요 차이점

| 구분 | 기본형 | 참조형 |
|------|--------|--------|
| **데이터 저장** | 실제 값 직접 저장 | 참조값(주소) 저장 |
| **연산** | 산술 연산 가능 | 산술 연산 불가능 |
| **null 할당** | 불가능 | 가능 |
| **대입 결과** | 값 복사 (독립적) | 참조값 복사 (같은 객체 공유) |
| **메서드 호출** | 호출자에 영향 없음 | 호출자 객체도 변경됨 |

### 🔑 기억할 점
1. **기본형은 값 복사, 참조형은 참조값 복사**
2. **참조형 변수 여러 개가 같은 객체를 가리킬 수 있음**
3. **null은 "참조할 대상이 없다"는 의미**
4. **NullPointerException은 null에 .을 찍을 때 발생**
5. **멤버 변수는 자동 초기화, 지역 변수는 수동 초기화**

### 🚀 다음 단계
이 개념들을 바탕으로 객체지향 프로그래밍의 캡슐화, 상속, 다형성 등을 학습할 수 있습니다.