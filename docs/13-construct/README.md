# Java 생성자(Constructor) 학습 가이드

## 목차
- [생성자가 필요한 이유](#생성자가-필요한-이유)
- [this 키워드](#this-키워드)
- [생성자 도입](#생성자-도입)
- [기본 생성자](#기본-생성자)
- [생성자 오버로딩과 this()](#생성자-오버로딩과-this)
- [문제와 풀이](#문제와-풀이)
- [정리](#정리)

## 생성자가 필요한 이유

객체를 생성하는 시점에 어떤 작업을 하고 싶다면 생성자(Constructor)를 이용하면 됩니다.

### 초기 접근법 - 메서드 사용

**MemberInit.java**
```java
package construct;

public class MemberInit {
    String name;
    int age;
    int grade;
}
```

**MethodInitMain1.java**
```java
package construct;

public class MethodInitMain1 {
    public static void main(String[] args) {
        MemberInit member1 = new MemberInit();
        member1.name = "user1";
        member1.age = 15;
        member1.grade = 90;

        MemberInit member2 = new MemberInit();
        member2.name = "user2";
        member2.age = 16;
        member2.grade = 80;

        MemberInit[] members = {member1, member2};
        for (MemberInit s : members) {
            System.out.println("이름:" + s.name + " 나이:" + s.age + " 성적:" + s.grade);
        }
    }
}
```

**실행 결과:**
```
이름:user1 나이:15 성적:90
이름:user2 나이:16 성적:80
```

### 메서드를 통한 개선

반복되는 초기화 코드를 메서드로 개선할 수 있습니다.

**MethodInitMain2.java**
```java
package construct;

public class MethodInitMain2 {
    public static void main(String[] args) {
        MemberInit member1 = new MemberInit();
        initMember(member1, "user1", 15, 90);

        MemberInit member2 = new MemberInit();
        initMember(member2, "user2", 16, 80);

        MemberInit[] members = {member1, member2};
        for (MemberInit s : members) {
            System.out.println("이름:" + s.name + " 나이:" + s.age + " 성적:" + s.grade);
        }
    }

    static void initMember(MemberInit member, String name, int age, int grade) {
        member.name = name;
        member.age = age;
        member.grade = grade;
    }
}
```

## this 키워드

객체 지향 관점에서 속성과 기능을 한 곳에 두는 것이 더 나은 방법입니다.

**MemberInit - initMember() 추가**
```java
package construct;

public class MemberInit {
    String name;
    int age;
    int grade;

    // 추가
    void initMember(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
```

**MethodInitMain3.java**
```java
package construct;

public class MethodInitMain3 {
    public static void main(String[] args) {
        MemberInit member1 = new MemberInit();
        member1.initMember("user1", 15, 90);

        MemberInit member2 = new MemberInit();
        member2.initMember("user2", 16, 80);

        MemberInit[] members = {member1, member2};
        for (MemberInit s : members) {
            System.out.println("이름:" + s.name + " 나이:" + s.age + " 성적:" + s.grade);
        }
    }
}
```

### this 키워드 설명

- 매개변수와 멤버 변수의 이름이 같을 때 구분하기 위해 사용
- `this`는 인스턴스 자신의 참조값을 가리킴
- 멤버 변수에 접근하려면 `this.`를 앞에 붙임

**진행 과정:**
```java
this.name = name; // 1. 오른쪽의 name은 매개변수에 접근
this.name = "user"; // 2. name 매개변수의 값 사용
x001.name = "user"; // 3. this는 인스턴스 자신의 참조값
```

### this 생략

`this`는 생략할 수 있습니다. 변수를 찾을 때:
1. 가까운 지역변수(매개변수)를 먼저 찾음
2. 없으면 멤버 변수를 찾음
3. 멤버 변수도 없으면 오류 발생

## 생성자 도입

프로그래밍에서는 객체를 생성하고 즉시 초기값을 할당하는 경우가 많습니다. 생성자를 사용하면 객체 생성 시점에 필요한 기능을 편리하게 수행할 수 있습니다.

**MemberConstruct.java**
```java
package construct;

public class MemberConstruct {
    String name;
    int age;
    int grade;

    MemberConstruct(String name, int age, int grade) {
        System.out.println("생성자 호출 name=" + name + ",age=" + age + ",grade=" + grade);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
```

### 생성자의 특징

1. **생성자의 이름은 클래스 이름과 같아야 함** (첫 글자도 대문자)
2. **반환 타입이 없음** (void도 사용하지 않음)
3. 나머지는 메서드와 동일

**ConstructMain1.java**
```java
package construct;

public class ConstructMain1 {
    public static void main(String[] args) {
        MemberConstruct member1 = new MemberConstruct("user1", 15, 90);
        MemberConstruct member2 = new MemberConstruct("user2", 16, 80);

        MemberConstruct[] members = {member1, member2};
        for (MemberConstruct s : members) {
            System.out.println("이름:" + s.name + " 나이:" + s.age + " 성적:" + s.grade);
        }
    }
}
```

**실행 결과:**
```
생성자 호출 name=user1,age=15,grade=90
생성자 호출 name=user2,age=16,grade=80
이름:user1 나이:15 성적:90
이름:user2 나이:16 성적:80
```

### 생성자 호출

생성자는 인스턴스를 생성하고 나서 즉시 호출됩니다.

```java
new 생성자이름(생성자에 맞는 인수 목록)
new 클래스이름(생성자에 맞는 인수 목록)
```

### 생성자의 장점

#### 1. 중복 호출 제거
```java
// 생성자 등장 전
MemberInit member = new MemberInit();
member.initMember("user1", 15, 90);

// 생성자 등장 후
MemberConstruct member = new MemberConstruct("user1", 15, 90);
```

#### 2. 제약 - 생성자 호출 필수
직접 정의한 생성자가 있다면 반드시 호출해야 합니다.

```java
// 컴파일 오류 발생
MemberConstruct member3 = new MemberConstruct();
```

**컴파일 오류 메시지:**
```
no suitable constructor found for MemberConstruct(no arguments)
```

## 기본 생성자

매개변수가 없는 생성자를 **기본 생성자**라고 합니다.

### 기본 생성자 규칙

1. **클래스에 생성자가 하나도 없으면** 자바 컴파일러가 기본 생성자를 자동으로 만들어줌
2. **생성자가 하나라도 있으면** 자바는 기본 생성자를 만들지 않음

**MemberDefault.java**
```java
package construct;

public class MemberDefault {
    String name;
    // 자바가 자동으로 기본 생성자를 만들어줌
}
```

**자동 생성되는 기본 생성자:**
```java
public class MemberDefault {
    String name;
    
    // 기본 생성자 (자동 생성)
    public MemberDefault() {
    }
}
```

### 기본 생성자를 직접 정의

```java
package construct;

public class MemberDefault {
    String name;
    
    MemberDefault() {
        System.out.println("생성자 호출");
    }
}
```

## 생성자 오버로딩과 this()

생성자도 메서드 오버로딩처럼 매개변수만 다르게 해서 여러 생성자를 제공할 수 있습니다.

**MemberConstruct - 생성자 추가**
```java
package construct;

public class MemberConstruct {
    String name;
    int age;
    int grade;

    // 추가된 생성자
    MemberConstruct(String name, int age) {
        this.name = name;
        this.age = age;
        this.grade = 50;
    }

    MemberConstruct(String name, int age, int grade) {
        System.out.println("생성자 호출 name=" + name + ",age=" + age + ",grade=" + grade);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
```

**ConstructMain2.java**
```java
package construct;

public class ConstructMain2 {
    public static void main(String[] args) {
        MemberConstruct member1 = new MemberConstruct("user1", 15, 90);
        MemberConstruct member2 = new MemberConstruct("user2", 16);

        MemberConstruct[] members = {member1, member2};
        for (MemberConstruct s : members) {
            System.out.println("이름:" + s.name + " 나이:" + s.age + " 성적:" + s.grade);
        }
    }
}
```

**실행 결과:**
```
생성자 호출 name=user1,age=15,grade=90
이름:user1 나이:15 성적:90
이름:user2 나이:16 성적:50
```

### this() 사용

생성자 내부에서 자신의 다른 생성자를 호출할 수 있습니다.

**MemberConstruct - this() 사용**
```java
package construct;

public class MemberConstruct {
    String name;
    int age;
    int grade;

    MemberConstruct(String name, int age) {
        this(name, age, 50); // 다른 생성자 호출
    }

    MemberConstruct(String name, int age, int grade) {
        System.out.println("생성자 호출 name=" + name + ",age=" + age + ",grade=" + grade);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
```

### this() 규칙

⚠️ **중요:** `this()`는 생성자 코드의 **첫 줄에만** 작성할 수 있습니다.

```java
// 규칙 위반 - 컴파일 오류
public MemberConstruct(String name, int age) {
    System.out.println("go");
    this(name, age, 50); // 오류!
}
```

## 문제와 풀이

### 문제 - Book과 생성자

BookMain 코드가 작동하도록 Book 클래스를 완성하세요. 생성자 코드에 중복이 없도록 주의하세요.

**BookMain.java**
```java
package construct.ex;

public class BookMain {
    public static void main(String[] args) {
        // 기본 생성자 사용
        Book book1 = new Book();
        book1.displayInfo();
        
        // title과 author만을 매개변수로 받는 생성자
        Book book2 = new Book("Hello Java", "Seo");
        book2.displayInfo();
        
        // 모든 필드를 매개변수로 받는 생성자
        Book book3 = new Book("JPA 프로그래밍", "kim", 700);
        book3.displayInfo();
    }
}
```

**기대 실행 결과:**
```
제목: , 저자: , 페이지: 0
제목: Hello Java, 저자: Seo, 페이지: 0
제목: JPA 프로그래밍, 저자: kim, 페이지: 700
```

### 정답

**Book.java**
```java
package construct.ex;

public class Book {
    String title;
    String author;
    int page;

    // 기본생성자
    Book() {
        this("", "", 0);
    }

    // title과 author만을 매개변수로 받는 생성자
    Book(String title, String author) {
        this(title, author, 0);
    }

    // 모든 필드를 매개변수로 받는 생성자
    Book(String title, String author, int page) {
        this.title = title;
        this.author = author;
        this.page = page;
    }

    void displayInfo() {
        System.out.println("제목: " + title + ", 저자: " + author + ", 페이지: " + page);
    }
}
```

## 정리

생성자는 객체 생성 직후 객체를 초기화하기 위한 특별한 메서드로 생각할 수 있습니다.

### 핵심 포인트

1. **생성자는 반드시 호출되어야 함**
2. **생성자가 없으면 기본 생성자가 제공됨**
3. **생성자가 하나라도 있으면 기본 생성자가 제공되지 않음**
4. **this()를 사용하여 생성자 간 호출 가능**
5. **생성자를 사용하면 필수값 입력을 보장할 수 있음**

> 💡 **참고:** 좋은 프로그램은 무한한 자유도가 주어지는 프로그램이 아니라 적절한 제약이 있는 프로그램입니다.