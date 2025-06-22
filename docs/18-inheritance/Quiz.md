## 상속 퀴즈 및 문제 해결

### 퀴즈 1: 상속의 주된 목적

**문제:** 상속을 사용하는 주된 목적은 무엇일까요?

**A.** 새로운 클래스 이름을 짓기 위해  
**B.** 코드 재사용을 통해 중복을 줄이기 위해 ✅  
**C.** 프로그램 실행 속도를 높이기 위해  
**D.** 메모리 사용량을 줄이기 위해

**해설:**  
상속은 부모 클래스의 필드와 메소드를 자식 클래스에서 물려받아 사용할 수 있게 합니다. 이를 통해 코드 중복을 줄이고 재사용성을 높이는 것이 핵심 목적입니다.

---

### 퀴즈 2: 자바 상속의 특징

**문제:** 자바 상속에 대한 설명 중 올바른 것은 무엇인가요?

**A.** 하나의 자식 클래스는 여러 부모 클래스를 가질 수 있다.  
**B.** 'inherits' 키워드를 사용하여 상속한다.  
**C.** 부모는 자식의 모든 멤버에 직접 접근할 수 있다.  
**D.** 하나의 자식 클래스는 오직 하나의 부모 클래스만 상속할 수 있다. ✅

**해설:**  
자바는 단일 상속만을 지원합니다. 이는 복잡성을 줄이기 위함이며, 한 자식 클래스는 반드시 하나의 부모 클래스만 상속받을 수 있습니다.

---

### 퀴즈 3: 메소드 탐색 순서

**문제:** 상속 관계의 자식 객체에서 메소드를 호출할 때, 자바는 해당 메소드를 어떤 순서로 찾을까요?

**A.** 부모 클래스에서 먼저 찾는다.  
**B.** 자식 클래스에서 먼저 찾고, 없으면 부모 클래스에서 찾는다. ✅  
**C.** 무작위 순서로 클래스를 검색한다.  
**D.** 컴파일 시점에 사용될 메소드가 결정된다.

**해설:**  
메소드 호출 시 자바는 항상 실제 객체 타입인 자식 클래스부터 검색합니다. 해당 메소드가 없으면 부모 클래스로 올라가 찾고, 최상위까지 없으면 컴파일 오류가 발생합니다.

**실제 예제:**
```java
class Parent {
    public void method1() { System.out.println("Parent method1"); }
    public void method2() { System.out.println("Parent method2"); }
}

class Child extends Parent {
    @Override
    public void method1() { System.out.println("Child method1"); }
    // method2는 오버라이딩 안함
}

Child child = new Child();
child.method1(); // "Child method1" - 자식에서 찾음
child.method2(); // "Parent method2" - 자식에 없어서 부모에서 찾음
```

---

### 퀴즈 4: 메소드 오버라이딩

**문제:** 메소드 오버라이딩(Overriding)은 무엇을 의미할까요?

**A.** 부모 클래스에 없는 새로운 메소드를 자식 클래스에 추가하는 것  
**B.** 부모 클래스와 같은 이름의 메소드를 매개변수만 다르게 자식 클래스에 정의하는 것  
**C.** 부모 클래스로부터 상속받은 메소드의 내용을 자식 클래스에서 재정의하는 것 ✅  
**D.** 부모 클래스의 메소드를 호출하지 못하도록 막는 것

**해설:**  
오버라이딩은 부모 클래스의 메소드를 자식 클래스에서 동일한 시그니처(이름, 매개변수)로 재정의하는 것입니다. 이를 통해 자식 클래스만의 특정 동작을 구현할 수 있습니다.

**오버라이딩 vs 오버로딩 구분:**
```java
// 오버라이딩 (Overriding) - 상속 관계에서 메소드 재정의
class Animal {
    public void sound() { System.out.println("Some sound"); }
}

class Dog extends Animal {
    @Override
    public void sound() { System.out.println("Woof!"); } // 오버라이딩
}

// 오버로딩 (Overloading) - 같은 클래스 내에서 매개변수가 다른 동일 이름 메소드
class Calculator {
    public int add(int a, int b) { return a + b; }
    public double add(double a, double b) { return a + b; } // 오버로딩
}
```

---

### 퀴즈 5: super() 호출의 목적

**문제:** 자식 클래스의 생성자 첫 줄에서 super()를 호출하는 가장 주된 이유는 무엇일까요?

**A.** 자식 클래스의 멤버 변수를 초기화하기 위해  
**B.** 부모 클래스의 생성자를 호출하여 부모 부분을 초기화하기 위해 ✅  
**C.** 프로그램 실행 속도를 높이기 위해  
**D.** 메모리 공간을 미리 확보하기 위해

**해설:**  
객체 생성 시 자식 클래스 객체 내부에는 부모 클래스 부분도 함께 생성됩니다. super()는 이 부모 부분을 올바르게 초기화하기 위해 부모 클래스의 생성자를 호출하는 역할을 합니다.

**생성자 호출 순서 예제:**
```java
class GrandParent {
    public GrandParent() {
        System.out.println("1. GrandParent 생성자");
    }
}

class Parent extends GrandParent {
    public Parent() {
        super(); // 생략 가능
        System.out.println("2. Parent 생성자");
    }
}

class Child extends Parent {
    public Child() {
        super(); // 생략 가능
        System.out.println("3. Child 생성자");
    }
}

// new Child() 실행 시:
// 1. GrandParent 생성자
// 2. Parent 생성자  
// 3. Child 생성자
```

---

## 추가 학습 포인트

### 상속에서 중요한 개념들

1. **메모리 구조 이해**
    - 자식 객체 생성 시 부모와 자식이 모두 메모리에 생성됨
    - 하나의 참조값으로 접근하지만 내부적으로는 구분됨

2. **메소드 호출 메커니즘**
    - 동적 메소드 디스패치(Dynamic Method Dispatch)
    - 런타임에 실제 객체 타입에 따라 호출될 메소드 결정

3. **생성자 체이닝**
    - 자식 → 부모 → 조부모 순으로 생성자 호출
    - 초기화는 최상위 부모부터 시작

4. **접근 제어의 중요성**
    - 캡슐화 원칙 유지
    - 적절한 접근 제어자 선택