# Java final 키워드 완벽 가이드

## 📖 목차
- [final 기본 개념](#final-기본-개념)
- [final 지역 변수](#final-지역-변수)
- [final 필드(멤버 변수)](#final-필드멤버-변수)
- [상수(Constant)](#상수constant)
- [final과 참조형 변수](#final과-참조형-변수)
- [실전 활용 예제](#실전-활용-예제)

---

## final 기본 개념

**final** 키워드는 "끝", "마지막"을 의미하며, **더 이상 값을 변경할 수 없음**을 나타냅니다.

### 적용 대상
- ✅ 변수 (지역 변수, 필드)
- ✅ 메서드 (상속 관련)
- ✅ 클래스 (상속 관련)

---

## final 지역 변수

### 특징
- 최초 **한 번만 할당** 가능
- 이후 값 변경 시 **컴파일 오류** 발생
- 매개변수에도 적용 가능

### 코드 예제

```java
public class FinalLocalMain {
    public static void main(String[] args) {
        // final 지역 변수1 - 선언 후 초기화
        final int data1;
        data1 = 10; // 최초 한번만 할당 가능
        // data1 = 20; // 컴파일 오류!
        
        // final 지역 변수2 - 선언과 동시에 초기화
        final int data2 = 10;
        // data2 = 20; // 컴파일 오류!
        
        method(10);
    }
    
    // final 매개변수
    static void method(final int parameter) {
        // parameter = 20; // 컴파일 오류!
    }
}
```

---

## final 필드(멤버 변수)

### 1. 생성자 초기화

```java
public class ConstructInit {
    final int value;
    
    public ConstructInit(int value) {
        this.value = value; // 생성자에서 한 번만 초기화
    }
}
```

**특징:** 각 인스턴스마다 다른 값을 가질 수 있음

### 2. 필드 초기화

```java
public class FieldInit {
    static final int CONST_VALUE = 10;
    final int value = 10;
}
```

**특징:** 모든 인스턴스가 같은 값을 가짐

### 메모리 효율성 문제

필드 초기화 방식은 모든 인스턴스가 동일한 값을 가지므로 **메모리 낭비**가 발생할 수 있습니다.

**해결책:** `static final` 사용

```java
public class FieldInit {
    static final int MY_VALUE = 10; // static 영역에 하나만 존재
}
```

---

## 상수(Constant)

### 정의
**변하지 않고 항상 일정한 값**을 갖는 수로, Java에서는 `static final` 키워드를 사용합니다.

### 상수 특징
- `static final` 키워드 사용
- **대문자 + 언더스코어(_)** 명명 규칙
- 필드에 직접 접근하여 사용
- 중앙 집중식 값 관리 가능

### 상수 예제

```java
public class Constant {
    // 수학 상수
    public static final double PI = 3.14;
    
    // 시간 상수
    public static final int HOURS_IN_DAY = 24;
    public static final int MINUTES_IN_HOUR = 60;
    public static final int SECONDS_IN_MINUTE = 60;
    
    // 애플리케이션 설정 상수
    public static final int MAX_USERS = 1000;
}
```

### 상수 사용의 장점

#### ❌ 상수 없이 사용 (문제점)
```java
public class ConstantMain1 {
    public static void main(String[] args) {
        System.out.println("프로그램 최대 참여자 수 " + 1000);
        int currentUserCount = 999;
        
        if (currentUserCount > 1000) {
            System.out.println("대기자로 등록합니다.");
        }
    }
}
```

**문제점:**
- 매직 넘버 문제 (1000이 무엇을 의미하는지 불명확)
- 값 변경 시 여러 곳을 수정해야 함

#### ✅ 상수 사용 (해결책)
```java
public class ConstantMain2 {
    public static void main(String[] args) {
        System.out.println("프로그램 최대 참여자 수 " + Constant.MAX_USERS);
        int currentUserCount = 999;
        
        if (currentUserCount > Constant.MAX_USERS) {
            System.out.println("대기자로 등록합니다.");
        }
    }
}
```

**장점:**
- 의미가 명확함 (MAX_USERS)
- 한 곳에서만 값을 변경하면 됨
- 코드 가독성 향상

---

## final과 참조형 변수

### 핵심 개념
- **기본형 변수:** 값 자체를 변경할 수 없음
- **참조형 변수:** 참조값(주소)을 변경할 수 없음 (객체 내부 값은 변경 가능)

### 예제 코드

```java
public class Data {
    public int value; // final이 아님
}

public class FinalRefMain {
    public static void main(String[] args) {
        final Data data = new Data();
        // data = new Data(); // 컴파일 오류! 참조값 변경 불가
        
        // 참조 대상의 값은 변경 가능
        data.value = 10;
        System.out.println(data.value); // 10
        data.value = 20;
        System.out.println(data.value); // 20
    }
}
```

### 메모리 구조 이해

```
final Data data = new Data();
```

![메모리 구조]
- `data` 변수: 참조값 변경 불가 (final)
- `Data` 객체: 내부 `value` 필드는 변경 가능

---

## 실전 활용 예제

### Member 클래스 - ID 보호

```java
public class Member {
    private final String id;    // final로 ID 보호
    private String name;
    
    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public void changeData(String id, String name) {
        // this.id = id; // 컴파일 오류! final 필드 변경 불가
        this.name = name; // 이름은 변경 가능
    }
    
    public void print() {
        System.out.println("id:" + id + ", name:" + name);
    }
}
```

### 사용 예제

```java
public class MemberMain {
    public static void main(String[] args) {
        Member member = new Member("myId", "kim");
        member.print();                     // id:myId, name:kim
        
        member.changeData("myId2", "seo");  // ID는 변경되지 않음
        member.print();                     // id:myId, name:seo
    }
}
```

---

## 🎯 핵심 정리

### final 사용 규칙
1. **지역 변수:** 최초 한 번만 할당 가능
2. **필드:** 생성자 또는 선언 시 초기화
3. **상수:** `static final` + 대문자 명명
4. **참조형:** 참조값만 고정, 객체 내부는 변경 가능

### 언제 사용해야 할까?
- 값이 변경되면 안 되는 중요한 데이터 (ID, 설정값 등)
- 애플리케이션 전체에서 사용하는 상수
- 매직 넘버를 의미있는 상수로 대체할 때

### 장점
- **컴파일 타임 안전성:** 실수로 값을 변경하면 컴파일 오류
- **코드 가독성:** 의미있는 상수명으로 코드 이해도 향상
- **유지보수성:** 중앙 집중식 값 관리로 변경 용이