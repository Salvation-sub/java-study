# Java 상속(Inheritance) 완전 정리

## 목차
- [상속 - 시작](#상속---시작)
- [상속 관계](#상속-관계)
- [상속과 메모리 구조](#상속과-메모리-구조)
- [상속과 기능 추가](#상속과-기능-추가)
- [상속과 메서드 오버라이딩](#상속과-메서드-오버라이딩)
- [상속과 접근 제어](#상속과-접근-제어)
- [super - 부모 참조](#super---부모-참조)
- [super - 생성자](#super---생성자)
- [문제와 풀이](#문제와-풀이)
- [정리](#정리)

---

## 상속 - 시작

상속이 필요한 이유를 이해하기 위해 다음 예제를 살펴보겠습니다.

### 상속 사용 전 - 코드 중복 문제

```java
// 전기차 클래스
package extends1.ex1;
public class ElectricCar {
    public void move() {
        System.out.println("차를 이동합니다.");
    }
    
    public void charge() {
        System.out.println("충전합니다.");
    }
}
```

```java
// 가솔린차 클래스
package extends1.ex1;
public class GasCar {
    public void move() {
        System.out.println("차를 이동합니다.");
    }
    
    public void fillUp() {
        System.out.println("기름을 주유합니다.");
    }
}
```

**문제점**: `move()` 메서드가 중복됨

---

## 상속 관계

상속은 객체 지향 프로그래밍의 핵심 요소로, 기존 클래스의 필드와 메서드를 새로운 클래스에서 재사용할 수 있게 해줍니다.

### 상속의 기본 문법
```java
class 자식클래스 extends 부모클래스 {
    // 자식 클래스의 고유 기능
}
```

### 용어 정리
- **부모 클래스(슈퍼 클래스)**: 상속을 통해 자신의 필드와 메서드를 제공하는 클래스
- **자식 클래스(서브 클래스)**: 부모 클래스로부터 필드와 메서드를 상속받는 클래스

### 상속을 사용한 개선된 코드

```java
// 부모 클래스
package extends1.ex2;
public class Car {
    public void move() {
        System.out.println("차를 이동합니다.");
    }
}
```

```java
// 자식 클래스 - 전기차
package extends1.ex2;
public class ElectricCar extends Car {
    public void charge() {
        System.out.println("충전합니다.");
    }
}
```

```java
// 자식 클래스 - 가솔린차
package extends1.ex2;
public class GasCar extends Car {
    public void fillUp() {
        System.out.println("기름을 주유합니다.");
    }
}
```

### 단일 상속
- 자바는 **다중 상속을 지원하지 않음**
- `extends` 대상은 하나만 선택 가능
- 부모가 또 다른 부모를 가지는 것은 가능

---

## 상속과 메모리 구조

### 🔥 중요한 개념!
상속 관계의 객체를 생성할 때 메모리 구조를 이해하는 것이 매우 중요합니다.

```java
ElectricCar electricCar = new ElectricCar();
```

위 코드를 실행하면:
1. `ElectricCar` 뿐만 아니라 상속 관계에 있는 `Car`까지 함께 포함해서 인스턴스 생성
2. 참조값은 하나(`x001`)이지만 내부에는 `Car`, `ElectricCar` 두 클래스 정보가 공존

### 메서드 호출 과정

#### `electricCar.charge()` 호출 시:
1. 참조값(`x001`)을 통해 인스턴스 접근
2. 호출하는 변수의 타입(`ElectricCar`)을 기준으로 선택
3. `ElectricCar`에서 `charge()` 메서드 실행

#### `electricCar.move()` 호출 시:
1. 참조값(`x001`)을 통해 인스턴스 접근
2. `ElectricCar` 타입에서 `move()` 메서드 탐색
3. `ElectricCar`에 `move()`가 없으므로 부모인 `Car`에서 탐색
4. `Car`의 `move()` 메서드 실행

### 핵심 원칙
- 상속 관계의 객체를 생성하면 내부에 부모와 자식이 모두 생성됨
- 현재 타입에서 기능을 찾지 못하면 상위 부모 타입으로 올라가서 탐색
- 기능을 찾지 못하면 컴파일 오류 발생

---

## 상속과 기능 추가

상속의 장점을 활용하여 기능을 추가해보겠습니다.

### 요구사항
1. 모든 차량에 문열기(`openDoor()`) 기능 추가
2. 새로운 수소차(`HydrogenCar`) 추가

### 개선된 코드

```java
// 부모 클래스에 공통 기능 추가
package extends1.ex3;
public class Car {
    public void move() {
        System.out.println("차를 이동합니다.");
    }
    
    // 추가된 공통 기능
    public void openDoor() {
        System.out.println("문을 엽니다.");
    }
}
```

```java
// 새로운 수소차 클래스
package extends1.ex3;
public class HydrogenCar extends Car {
    public void fillHydrogen() {
        System.out.println("수소를 충전합니다.");
    }
}
```

### 상속의 장점
- 부모 클래스에 기능 추가 시 모든 자식 클래스가 자동으로 해당 기능 사용 가능
- 새로운 클래스 추가 시 기존 기능을 바로 사용 가능

---

## 상속과 메서드 오버라이딩

부모의 기능을 자식에서 다르게 재정의하고 싶을 때 **메서드 오버라이딩(Method Overriding)**을 사용합니다.

### 오버라이딩 예제

```java
package extends1.overriding;
public class ElectricCar extends Car {
    @Override
    public void move() {
        System.out.println("전기차를 빠르게 이동합니다.");
    }
    
    public void charge() {
        System.out.println("충전합니다.");
    }
}
```

### @Override 애노테이션
- 상위 클래스의 메서드를 오버라이드함을 명시
- 컴파일러가 오버라이딩 조건을 확인
- 오타나 실수 방지에 도움
- 필수는 아니지만 권장됨

### 오버라이딩 vs 오버로딩

| 구분 | 오버라이딩(Overriding) | 오버로딩(Overloading) |
|------|----------------------|---------------------|
| 정의 | 상속 관계에서 부모 메서드를 재정의 | 같은 이름, 다른 매개변수의 메서드 여러 개 정의 |
| 관계 | 상속 관계에서 사용 | 같은 클래스 내에서 사용 |
| 조건 | 메서드 시그니처가 동일해야 함 | 매개변수가 달라야 함 |

### 메서드 오버라이딩 조건
1. **메서드 이름**: 동일해야 함
2. **매개변수**: 타입, 순서, 개수가 동일해야 함
3. **반환 타입**: 동일하거나 하위 클래스 타입
4. **접근 제어자**: 상위 클래스보다 더 제한적이면 안됨
5. **예외**: 상위 클래스보다 더 많은 체크 예외를 선언할 수 없음
6. **제한**: `static`, `final`, `private` 메서드는 오버라이딩 불가
7. **생성자**: 오버라이딩 불가

---

## 상속과 접근 제어

### 접근 제어자 종류
- `private`: 모든 외부 호출 차단
- `default`: 같은 패키지 내에서만 호출 허용
- `protected`: 같은 패키지 + 상속 관계에서 호출 허용
- `public`: 모든 외부 호출 허용

### 상속에서의 접근 제어 예제

```java
// 부모 클래스 (다른 패키지)
package extends1.access.parent;
public class Parent {
    public int publicValue;
    protected int protectedValue;
    int defaultValue;
    private int privateValue;
    
    // 메서드도 동일한 접근 제어 규칙 적용
    public void publicMethod() { }
    protected void protectedMethod() { }
    void defaultMethod() { }
    private void privateMethod() { }
}
```

```java
// 자식 클래스 (다른 패키지)
package extends1.access.child;
import extends1.access.parent.Parent;

public class Child extends Parent {
    public void call() {
        publicValue = 1;        // ✅ 접근 가능
        protectedValue = 1;     // ✅ 상속 관계이므로 접근 가능
        // defaultValue = 1;    // ❌ 다른 패키지이므로 접근 불가
        // privateValue = 1;    // ❌ private은 접근 불가
        
        publicMethod();         // ✅ 접근 가능
        protectedMethod();      // ✅ 상속 관계이므로 접근 가능
        // defaultMethod();     // ❌ 다른 패키지이므로 접근 불가
        // privateMethod();     // ❌ private은 접근 불가
    }
}
```

### 접근 제어와 메모리 구조
- 객체 내부에서는 자식과 부모가 구분되어 있음
- 자식 타입에서 부모 타입의 기능 호출 시, 부모 입장에서는 외부 호출과 동일
- 따라서 접근 제어자 규칙이 적용됨

---

## super - 부모 참조

부모와 자식의 필드명이 같거나 메서드가 오버라이딩되어 있을 때, `super` 키워드로 부모를 참조할 수 있습니다.

### super 사용 예제

```java
public class Parent {
    public String value = "parent";
    
    public void hello() {
        System.out.println("Parent.hello");
    }
}
```

```java
public class Child extends Parent {
    public String value = "child";
    
    @Override
    public void hello() {
        System.out.println("Child.hello");
    }
    
    public void call() {
        System.out.println("this value = " + this.value);    // child
        System.out.println("super value = " + super.value);  // parent
        
        this.hello();   // Child.hello
        super.hello();  // Parent.hello
    }
}
```

### this vs super
- `this`: 자기 자신의 참조 (생략 가능)
- `super`: 부모 클래스에 대한 참조

---

## super - 생성자

### 상속과 생성자 호출 규칙
상속 관계에서는 **자식 클래스의 생성자에서 부모 클래스의 생성자를 반드시 호출**해야 합니다.

### 생성자 호출 예제

```java
public class ClassA {
    public ClassA() {
        System.out.println("ClassA 생성자");
    }
}
```

```java
public class ClassB extends ClassA {
    public ClassB(int a) {
        super(); // 부모의 기본 생성자 호출 (생략 가능)
        System.out.println("ClassB 생성자 a=" + a);
    }
    
    public ClassB(int a, int b) {
        super(); // 부모의 기본 생성자 호출 (생략 가능)
        System.out.println("ClassB 생성자 a=" + a + " b=" + b);
    }
}
```

```java
public class ClassC extends ClassB {
    public ClassC() {
        super(10, 20); // 부모의 특정 생성자 호출
        System.out.println("ClassC 생성자");
    }
}
```

### 생성자 호출 순서
```java
ClassC classC = new ClassC();
```

**실행 결과:**
```
ClassA 생성자
ClassB 생성자 a=10 b=20
ClassC 생성자
```

**호출 과정:**
1. `new ClassC()` → `ClassC()` 생성자 호출
2. `ClassC()` → `super(10, 20)` → `ClassB(int a, int b)` 호출
3. `ClassB(int a, int b)` → `super()` → `ClassA()` 호출
4. `ClassA()` 실행 완료 → `ClassB()` 실행 완료 → `ClassC()` 실행 완료

### 생성자 호출 규칙
1. 자식 클래스 생성자의 **첫 줄**에 반드시 `super(...)` 호출
2. 부모의 기본 생성자인 경우 `super()` 생략 가능 (자동으로 추가됨)
3. `this(...)`를 사용하더라도 결국 어딘가에서 `super(...)`가 호출되어야 함

---

## 문제와 풀이

### 문제: 상속 관계 상품 클래스 만들기

**요구사항:**
- `Book`, `Album`, `Movie` 3가지 상품 클래스 생성
- 코드 중복 없이 상속 관계 사용
- 부모 클래스: `Item`

**공통 속성:** `name`, `price`
- `Book`: 저자(`author`), ISBN(`isbn`)
- `Album`: 아티스트(`artist`)
- `Movie`: 감독(`director`), 배우(`actor`)

### 정답

```java
// 부모 클래스
public class Item {
    private String name;
    private int price;
    
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void print() {
        System.out.println("이름:" + name + ", 가격:" + price);
    }
}
```

```java
// Book 클래스
public class Book extends Item {
    private String author;
    private String isbn;
    
    public Book(String name, int price, String author, String isbn) {
        super(name, price);
        this.author = author;
        this.isbn = isbn;
    }
    
    @Override
    public void print() {
        super.print();
        System.out.println("- 저자:" + author + ", isbn:" + isbn);
    }
}
```

```java
// Album 클래스
public class Album extends Item {
    private String artist;
    
    public Album(String name, int price, String artist) {
        super(name, price);
        this.artist = artist;
    }
    
    @Override
    public void print() {
        super.print();
        System.out.println("- 아티스트:" + artist);
    }
}
```

```java
// Movie 클래스
public class Movie extends Item {
    private String director;
    private String actor;
    
    public Movie(String name, int price, String director, String actor) {
        super(name, price);
        this.director = director;
        this.actor = actor;
    }
    
    @Override
    public void print() {
        super.print();
        System.out.println("- 감독:" + director + ", 배우:" + actor);
    }
}
```

---

## 정리

### 클래스와 메서드에 사용되는 final

#### 클래스에 final
```java
public final class MyFinalClass {
    // 상속 끝! - 이 클래스는 확장될 수 없음
}
```

#### 메서드에 final
```java
public final void myFinalMethod() {
    // 오버라이딩 끝! - 이 메서드는 오버라이드될 수 없음
}
```

### 상속의 핵심 개념 정리

1. **코드 재사용**: 부모 클래스의 필드와 메서드를 자식이 물려받아 사용
2. **확장성**: 기존 코드 수정 없이 새로운 기능 추가 가능
3. **다형성의 기반**: 상속은 다형성을 구현하는 기초가 됨
4. **단일 상속**: 자바는 클래스의 다중 상속을 지원하지 않음
5. **생성자 연쇄**: 자식 생성자에서 부모 생성자를 반드시 호출
6. **메서드 오버라이딩**: 부모의 메서드를 자식에서 재정의 가능
7. **접근 제어**: 상속 관계에서도 접근 제어자 규칙이 적용됨

### 상속 사용 시 주의사항
- 상속은 **IS-A 관계**일 때 사용 (자식이 부모의 한 종류인 경우)
- 단순한 코드 재사용 목적이라면 **합성(Composition)** 고려
- 과도한 상속 계층은 복잡성을 증가시킬 수 있음
- `final` 키워드로 상속이나 오버라이딩을 제한할 수 있음