# Java 다형성(Polymorphism) 완전 정리

## 목차
- [다형성 시작](#다형성-시작)
- [다형성과 캐스팅](#다형성과-캐스팅)
- [캐스팅의 종류](#캐스팅의-종류)
- [다운캐스팅과 주의점](#다운캐스팅과-주의점)
- [instanceof](#instanceof)
- [다형성과 메서드 오버라이딩](#다형성과-메서드-오버라이딩)
- [정리](#정리)

## 다형성 시작

객체지향 프로그래밍의 대표적인 특징으로는 **캡슐화**, **상속**, **다형성**이 있다. 그 중에서 다형성은 객체지향 프로그래밍의 꽃이라 불린다.

앞서 학습한 캡슐화나 상속은 직관적으로 이해하기 쉽다. 반면에 다형성은 제대로 이해하기도 어렵고, 잘 활용하기는 더 어렵다. 하지만 좋은 개발자가 되기 위해서는 다형성에 대한 이해가 필수다.

**다형성(Polymorphism)**은 이름 그대로 "다양한 형태", "여러 형태"를 뜻한다.

프로그래밍에서 다형성은 한 객체가 여러 타입의 객체로 취급될 수 있는 능력을 뜻한다. 보통 하나의 객체는 하나의 타입으로 고정되어 있다. 그런데 다형성을 사용하면 하나의 객체가 다른 타입으로 사용될 수 있다는 뜻이다.

다형성을 이해하기 위해서는 크게 2가지 핵심 이론을 알아야 한다.
1. **다형적 참조**
2. **메서드 오버라이딩**

### 다형적 참조

다형적 참조를 이해하기 위해 다음과 같은 간단한 상속 관계를 코드로 만들어보자.

```java
// Parent.java
package poly.basic;

public class Parent {
    public void parentMethod() {
        System.out.println("Parent.parentMethod");
    }
}
```

```java
// Child.java
package poly.basic;

public class Child extends Parent {
    public void childMethod() {
        System.out.println("Child.childMethod");
    }
}
```

#### 다형적 참조 예제

```java
// PolyMain.java
package poly.basic;

/**
 * 다형적 참조: 부모는 자식을 품을 수 있다.
 */
public class PolyMain {
    public static void main(String[] args) {
        // 부모 변수가 부모 인스턴스 참조
        System.out.println("Parent -> Parent");
        Parent parent = new Parent();
        parent.parentMethod();
        
        // 자식 변수가 자식 인스턴스 참조
        System.out.println("Child -> Child");
        Child child = new Child();
        child.parentMethod();
        child.childMethod();
        
        // 부모 변수가 자식 인스턴스 참조(다형적 참조)
        System.out.println("Parent -> Child");
        Parent poly = new Child();
        poly.parentMethod();
        
        // Child child1 = new Parent(); // 자식은 부모를 담을 수 없다.
        // 자식의 기능은 호출할 수 없다. 컴파일 오류 발생
        // poly.childMethod();
    }
}
```

**실행 결과**
```
Parent -> Parent
Parent.parentMethod
Child -> Child
Parent.parentMethod
Child.childMethod
Parent -> Child
Parent.parentMethod
```

### 다형적 참조 분석

1. **부모 타입의 변수가 부모 인스턴스 참조**
    - `Parent parent = new Parent()`
    - Parent 인스턴스를 만들었다. 메모리 상에 Parent만 생성된다.

2. **자식 타입의 변수가 자식 인스턴스 참조**
    - `Child child = new Child()`
    - Child 인스턴스를 만들었다. 메모리 상에 Child와 Parent가 모두 생성된다.

3. **다형적 참조: 부모 타입의 변수가 자식 인스턴스 참조**
    - `Parent poly = new Child()`
    - **부모는 자식을 담을 수 있다!**
    - 반대로 자식은 부모를 담을 수 없다: `Child child1 = new Parent()` → 컴파일 오류

### 다형적 참조의 핵심

부모 타입은 자신은 물론이고, 자신을 기준으로 모든 자식 타입을 참조할 수 있다.

```java
Parent poly = new Parent()
Parent poly = new Child()
Parent poly = new Grandson() // Child 하위에 손자가 있다면 가능
```

### 다형적 참조의 한계

Parent 타입으로 Child 인스턴스를 참조하는 경우, Parent에서 Child의 기능을 직접 호출할 수 없다.

```java
Parent poly = new Child();
// poly.childMethod(); // 컴파일 오류!
```

이런 경우 **캐스팅**이 필요하다.

## 다형성과 캐스팅

Parent 타입의 변수를 사용하게 되면 자식 타입에 있는 기능은 호출할 수 없다.

### 다운캐스팅 예제

```java
// CastingMain1.java
package poly.basic;

public class CastingMain1 {
    public static void main(String[] args) {
        // 부모 변수가 자식 인스턴스 참조(다형적 참조)
        Parent poly = new Child();
        
        // 단 자식의 기능은 호출할 수 없다. 컴파일 오류 발생
        // poly.childMethod();
        
        // 다운캐스팅(부모 타입 -> 자식 타입)
        Child child = (Child) poly;
        child.childMethod();
    }
}
```

**실행 결과**
```
Child.childMethod
```

### 다운캐스팅 과정

```java
Child child = (Child) poly; // Parent poly
```

1. `(타입)` 처럼 괄호와 그 사이에 타입을 지정하면 참조 대상을 특정 타입으로 변경할 수 있다.
2. `(Child) poly` 코드로 poly를 일시적으로 Child 타입으로 변경한다.
3. 그리고 `Child child`에 대입한다.

**중요**: 캐스팅을 한다고 해서 `Parent poly`의 타입이 변하는 것은 아니다. 해당 참조값을 꺼내고 꺼낸 참조값이 Child 타입이 되는 것이다.

## 캐스팅의 종류

- **업캐스팅(upcasting)**: 부모 타입으로 변경
- **다운캐스팅(downcasting)**: 자식 타입으로 변경

### 일시적 다운캐스팅

다운캐스팅 결과를 변수에 담아두는 과정이 번거로울 때 사용한다.

```java
// CastingMain2.java
package poly.basic;

public class CastingMain2 {
    public static void main(String[] args) {
        // 부모 변수가 자식 인스턴스 참조(다형적 참조)
        Parent poly = new Child();
        
        // 일시적 다운캐스팅 - 해당 메서드를 호출하는 순간만 다운캐스팅
        ((Child) poly).childMethod();
    }
}
```

### 업캐스팅

현재 타입을 부모 타입으로 변경하는 것을 업캐스팅이라 한다.

```java
// CastingMain3.java
package poly.basic;

public class CastingMain3 {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent1 = (Parent) child; // 업캐스팅은 생략 가능, 생략 권장
        Parent parent2 = child; // 업캐스팅 생략
        
        parent1.parentMethod();
        parent2.parentMethod();
    }
}
```

**업캐스팅 특징:**
- 업캐스팅은 생략할 수 있다.
- 다운캐스팅은 생략할 수 없다.
- 업캐스팅은 매우 자주 사용하기 때문에 생략을 권장한다.

## 다운캐스팅과 주의점

다운캐스팅은 잘못하면 심각한 런타임 오류가 발생할 수 있다.

```java
// CastingMain4.java
package poly.basic;

public class CastingMain4 {
    public static void main(String[] args) {
        Parent parent1 = new Child();
        Child child1 = (Child) parent1;
        child1.childMethod(); // 문제 없음
        
        Parent parent2 = new Parent();
        Child child2 = (Child) parent2; // 런타임 오류 - ClassCastException
        child2.childMethod(); // 실행 불가
    }
}
```

**실행 결과**
```
Child.childMethod
Exception in thread "main" java.lang.ClassCastException: 
class poly.basic.Parent cannot be cast to class poly.basic.Child
```

### 다운캐스팅이 가능한 경우 vs 불가능한 경우

**가능한 경우:**
```java
Parent parent1 = new Child(); // Child 인스턴스 생성
Child child1 = (Child) parent1; // 문제 없음
```

**불가능한 경우:**
```java
Parent parent2 = new Parent(); // Parent 인스턴스만 생성
Child child2 = (Child) parent2; // ClassCastException 발생
```

### 업캐스팅이 안전하고 다운캐스팅이 위험한 이유

**업캐스팅이 안전한 이유:**
- 객체를 생성하면 해당 타입의 상위 부모 타입은 모두 함께 생성된다.
- 따라서 위로만 타입을 변경하는 업캐스팅은 메모리 상에 인스턴스가 모두 존재하기 때문에 항상 안전하다.

**다운캐스팅이 위험한 이유:**
- 인스턴스에 존재하지 않는 하위 타입으로 캐스팅하는 문제가 발생할 수 있다.
- 객체를 생성하면 부모 타입은 모두 함께 생성되지만 자식 타입은 생성되지 않는다.

## instanceof

다형성에서 참조형 변수는 다양한 자식을 대상으로 참조할 수 있다. 그런데 참조하는 대상이 다양하기 때문에 어떤 인스턴스를 참조하고 있는지 확인하려면 `instanceof` 키워드를 사용한다.

```java
// CastingMain5.java
package poly.basic;

public class CastingMain5 {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        System.out.println("parent1 호출");
        call(parent1);
        
        Parent parent2 = new Child();
        System.out.println("parent2 호출");
        call(parent2);
    }
    
    private static void call(Parent parent) {
        parent.parentMethod();
        if (parent instanceof Child) {
            System.out.println("Child 인스턴스 맞음");
            Child child = (Child) parent;
            child.childMethod();
        }
    }
}
```

**실행 결과**
```
parent1 호출
Parent.parentMethod
parent2 호출
Parent.parentMethod
Child 인스턴스 맞음
Child.childMethod
```

### instanceof 사용법

```java
parent instanceof Child // parent가 Child의 인스턴스인지 확인
```

- `Parent` 인스턴스를 참조하는 경우: `false` 반환
- `Child` 인스턴스를 참조하는 경우: `true` 반환

### instanceof 특징

```java
new Parent() instanceof Parent // true
new Child() instanceof Parent  // true (부모는 자식을 담을 수 있다)
new Parent() instanceof Child  // false (자식은 부모를 담을 수 없다)
new Child() instanceof Child   // true
```

### 자바 16 - Pattern Matching for instanceof

자바 16부터는 `instanceof`를 사용하면서 동시에 변수를 선언할 수 있다.

```java
// CastingMain6.java
package poly.basic;

public class CastingMain6 {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        call(parent1);
        
        Parent parent2 = new Child();
        call(parent2);
    }
    
    private static void call(Parent parent) {
        parent.parentMethod();
        
        // Child 인스턴스인 경우 childMethod() 실행
        if (parent instanceof Child child) {
            System.out.println("Child 인스턴스 맞음");
            child.childMethod();
        }
    }
}
```

덕분에 인스턴스가 맞는 경우 직접 다운캐스팅 하는 코드를 생략할 수 있다.

## 다형성과 메서드 오버라이딩

다형성을 이루는 또 하나의 중요한 핵심 이론은 바로 **메서드 오버라이딩**이다.

메서드 오버라이딩에서 꼭 기억해야 할 점은 **오버라이딩 된 메서드가 항상 우선권을 가진다**는 점이다.

### 오버라이딩 예제

```java
// Parent.java
package poly.overriding;

public class Parent {
    public String value = "parent";
    
    public void method() {
        System.out.println("Parent.method");
    }
}
```

```java
// Child.java
package poly.overriding;

public class Child extends Parent {
    public String value = "child";
    
    @Override
    public void method() {
        System.out.println("Child.method");
    }
}
```

```java
// OverridingMain.java
package poly.overriding;

public class OverridingMain {
    public static void main(String[] args) {
        // 자식 변수가 자식 인스턴스 참조
        Child child = new Child();
        System.out.println("Child -> Child");
        System.out.println("value = " + child.value);
        child.method();
        
        // 부모 변수가 부모 인스턴스 참조
        Parent parent = new Parent();
        System.out.println("Parent -> Parent");
        System.out.println("value = " + parent.value);
        parent.method();
        
        // 부모 변수가 자식 인스턴스 참조(다형적 참조)
        Parent poly = new Child();
        System.out.println("Parent -> Child");
        System.out.println("value = " + poly.value); // 변수는 오버라이딩X
        poly.method(); // 메서드 오버라이딩!
    }
}
```

**실행 결과**
```
Child -> Child
value = child
Child.method
Parent -> Parent
value = parent
Parent.method
Parent -> Child
value = parent
Child.method
```

### 오버라이딩 분석

**Parent -> Child** 부분이 중요하다:

- `poly` 변수는 `Parent` 타입이다.
- `poly.value`: Parent 타입에 있는 value 값을 읽는다. → "parent"
- `poly.method()`: Parent 타입에 있는 method()를 실행하려고 한다. 그런데 하위 타입인 `Child.method()`가 오버라이딩 되어 있다. **오버라이딩 된 메서드는 항상 우선권을 가진다.** 따라서 `Parent.method()`가 아니라 `Child.method()`가 실행된다.

### 오버라이딩의 우선권

- **멤버 변수**: 오버라이딩 되지 않는다.
- **메서드**: 오버라이딩 된다.

오버라이딩은 부모 타입에서 정의한 기능을 자식 타입에서 재정의하는 것이다. 만약 자식에서도 오버라이딩 하고 손자에서도 같은 메서드를 오버라이딩을 하면 손자의 오버라이딩 메서드가 우선권을 가진다. **더 하위 자식의 오버라이딩 된 메서드가 우선권을 가지는 것이다.**

## 정리

지금까지 다형성을 이루는 핵심 이론인 **다형적 참조**와 **메서드 오버라이딩**에 대해 학습했다.

### 핵심 개념

1. **다형적 참조**: 하나의 변수 타입으로 다양한 자식 인스턴스를 참조할 수 있는 기능
2. **메서드 오버라이딩**: 기존 기능을 하위 타입에서 새로운 기능으로 재정의

### 중요 포인트

- **부모는 자식을 담을 수 있다**
- **업캐스팅은 안전하고 생략 가능**
- **다운캐스팅은 위험하므로 instanceof로 확인 후 사용**
- **오버라이딩 된 메서드는 항상 우선권을 가진다**

이 둘을 이해하고 나면 진정한 다형성의 위력을 맛볼 수 있다. 다형성은 객체지향 프로그래밍의 핵심이며, 유연하고 확장 가능한 코드를 작성하는 데 필수적인 개념이다.