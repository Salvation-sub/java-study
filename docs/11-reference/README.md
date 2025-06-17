# Java 기본형과 참조형 완벽 가이드

## 목차
- [기본형 vs 참조형1 - 시작](#기본형-vs-참조형1---시작)
- [기본형 vs 참조형2 - 변수 대입](#기본형-vs-참조형2---변수-대입)
- [기본형 vs 참조형3 - 메서드 호출](#기본형-vs-참조형3---메서드-호출)
- [참조형과 메서드 호출 - 활용](#참조형과-메서드-호출---활용)
- [변수와 초기화](#변수와-초기화)
- [null](#null)
- [NullPointerException](#nullpointerexception)
- [문제와 풀이](#문제와-풀이)
- [정리](#정리)

## 기본형 vs 참조형1 - 시작

자바에서 참조형을 제대로 이해하는 것은 정말 중요하다. 변수의 데이터 타입을 가장 크게 보면 기본형과 참조형으로 분류할 수 있다.

### 기본형과 참조형의 정의

- **기본형(Primitive Type)**: `int`, `long`, `double`, `boolean` 처럼 변수에 사용할 값을 직접 넣을 수 있는 데이터 타입
- **참조형(Reference Type)**: `Student student1`, `int[] students`와 같이 데이터에 접근하기 위한 참조(주소)를 저장하는 데이터 타입

기본형 변수에는 직접 사용할 수 있는 값이 들어있지만 참조형 변수에는 위치(참조값)가 들어가 있다.

### 기본형과 참조형의 특징

#### 기본형
- 숫자 10, 20과 같이 실제 사용하는 값을 변수에 담을 수 있다
- 해당 값을 바로 사용할 수 있다
- 들어있는 값을 그대로 계산에 사용할 수 있다

```java
int a = 10, b = 20;
int sum = a + b; // 연산 가능
```

#### 참조형
- 실제 사용하는 값을 변수에 담는 것이 아니다
- 실제 객체의 위치(참조, 주소)를 저장한다
- 객체는 `.`(dot)을 통해서 메모리 상에 생성된 객체를 찾아가야 사용할 수 있다
- 들어있는 참조값을 그대로 사용할 수 없다

```java
Student s1 = new Student();
Student s2 = new Student();
s1 + s2 // 오류 발생 - 연산 불가능
```

### 쉽게 이해하는 팁

- **기본형을 제외한 나머지는 모두 참조형이다**
- 기본형은 **소문자**로 시작한다: `int`, `long`, `double`, `boolean`
- 클래스는 **대문자**로 시작한다: `Student`
- 클래스는 모두 참조형이다

### 참고 - String

자바에서 `String`은 특별하다. `String`은 사실은 클래스다. 따라서 참조형이다. 그런데 기본형처럼 문자 값을 바로 대입할 수 있다. 문자는 매우 자주 다루기 때문에 자바에서 특별하게 편의 기능을 제공한다.

## 기본형 vs 참조형2 - 변수 대입

### 대원칙: 자바는 항상 변수의 값을 복사해서 대입한다

자바에서 변수에 값을 대입하는 것은 변수에 들어 있는 값을 복사해서 대입하는 것이다.

- 기본형이면 변수에 들어 있는 실제 사용하는 값을 복사해서 대입
- 참조형이면 변수에 들어 있는 참조값을 복사해서 대입

### 기본형 대입 예시

```java
int a = 10;
int b = a; // a의 값 10을 복사해서 b에 대입
```

### 참조형 대입 예시

```java
Student s1 = new Student();
Student s2 = s1; // s1의 참조값을 복사해서 s2에 대입
```

### 기본형과 변수 대입 실습

```java
package ref;

public class VarChange1 {
    public static void main(String[] args) {
        int a = 10;
        int b = a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // a 변경
        a = 20;
        System.out.println("변경 a = 20");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // b 변경
        b = 30;
        System.out.println("변경 b = 30");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
```

**실행 결과:**
```
a = 10
b = 10
변경 a = 20
a = 20
b = 10
변경 b = 30
a = 20
b = 30
```

변수의 대입은 변수에 들어있는 값을 복사해서 대입한다. 따라서 각각 본인의 값만 변경된다.

### 참조형과 변수 대입 실습

```java
package ref;

public class Data {
    int value;
}
```

```java
package ref;

public class VarChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        Data dataB = dataA;

        System.out.println("dataA 참조값=" + dataA);
        System.out.println("dataB 참조값=" + dataB);
        System.out.println("dataA.value = " + dataA.value);
        System.out.println("dataB.value = " + dataB.value);

        // dataA 변경
        dataA.value = 20;
        System.out.println("변경 dataA.value = 20");
        System.out.println("dataA.value = " + dataA.value);
        System.out.println("dataB.value = " + dataB.value);

        // dataB 변경
        dataB.value = 30;
        System.out.println("변경 dataB.value = 30");
        System.out.println("dataA.value = " + dataA.value);
        System.out.println("dataB.value = " + dataB.value);
    }
}
```

**실행 결과:**
```
dataA 참조값=ref.Data@x001
dataB 참조값=ref.Data@x001
dataA.value = 10
dataB.value = 10
변경 dataA.value = 20
dataA.value = 20
dataB.value = 20
변경 dataB.value = 30
dataA.value = 30
dataB.value = 30
```

참조형의 경우 실제 사용하는 객체가 아니라 객체의 위치를 가리키는 참조값만 복사된다. 따라서 같은 객체를 참조하게 되어 한쪽에서 값을 변경하면 다른 쪽에도 영향을 준다.

## 기본형 vs 참조형3 - 메서드 호출

### 대원칙: 자바는 항상 변수의 값을 복사해서 대입한다

메서드 호출도 마찬가지이다. 메서드를 호출할 때 사용하는 매개변수(파라미터)도 결국 변수일 뿐이다.

### 기본형과 메서드 호출

```java
package ref;

public class MethodChange1 {
    public static void main(String[] args) {
        int a = 10;
        System.out.println("메서드 호출 전: a = " + a);
        changePrimitive(a);
        System.out.println("메서드 호출 후: a = " + a);
    }

    static void changePrimitive(int x) {
        x = 20;
    }
}
```

**실행 결과:**
```
메서드 호출 전: a = 10
메서드 호출 후: a = 10
```

메서드를 호출할 때 매개변수 `x`에 변수 `a`의 값을 전달한다. 자바에서 변수에 값을 대입하는 것은 항상 값을 복사해서 대입한다. 따라서 `x`의 값만 20으로 변경되고, `a`의 값은 10으로 유지된다.

### 참조형과 메서드 호출

```java
package ref;

public class MethodChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        System.out.println("메서드 호출 전: dataA.value = " + dataA.value);
        changeReference(dataA);
        System.out.println("메서드 호출 후: dataA.value = " + dataA.value);
    }

    static void changeReference(Data dataX) {
        dataX.value = 20;
    }
}
```

**실행 결과:**
```
메서드 호출 전: dataA.value = 10
메서드 호출 후: dataA.value = 20
```

참조형의 경우 참조값이 복사되어 전달된다. 따라서 메서드 내부에서 매개변수로 전달된 객체의 멤버 변수를 변경하면, 호출자의 객체도 변경된다.

### 기본형과 참조형의 메서드 호출 정리

- **기본형**: 메서드로 기본형 데이터를 전달하면, 해당 값이 복사되어 전달된다. 메서드 내부에서 매개변수의 값을 변경해도, 호출자의 변수 값에는 영향이 없다.
- **참조형**: 메서드로 참조형 데이터를 전달하면, 참조값이 복사되어 전달된다. 메서드 내부에서 매개변수로 전달된 객체의 멤버 변수를 변경하면, 호출자의 객체도 변경된다.

## 참조형과 메서드 호출 - 활용

### 중복 제거를 위한 메서드 활용

기존 코드에서 중복되는 부분들을 메서드를 통해 제거할 수 있다:
- `name`, `age`, `grade`에 값을 할당하는 부분
- 학생 정보를 출력하는 부분

### Student 클래스

```java
package ref;

public class Student {
    String name;
    int age;
    int grade;
}
```

### 메서드에 객체 전달

```java
package ref;

public class Method1 {
    public static void main(String[] args) {
        Student student1 = new Student();
        initStudent(student1, "학생1", 15, 90);

        Student student2 = new Student();
        initStudent(student2, "학생2", 16, 80);

        printStudent(student1);
        printStudent(student2);
    }

    static void initStudent(Student student, String name, int age, int grade) {
        student.name = name;
        student.age = age;
        student.grade = grade;
    }

    static void printStudent(Student student) {
        System.out.println("이름:" + student.name + " 나이:" + student.age + " 성적:" + student.grade);
    }
}
```

참조형은 메서드를 호출할 때 참조값을 전달한다. 따라서 메서드 내부에서 전달된 참조값을 통해 객체의 값을 변경하거나, 값을 읽어서 사용할 수 있다.

### 메서드에서 객체 반환

```java
package ref;

public class Method2 {
    public static void main(String[] args) {
        Student student1 = createStudent("학생1", 15, 90);
        Student student2 = createStudent("학생2", 16, 80);

        printStudent(student1);
        printStudent(student2);
    }

    static Student createStudent(String name, int age, int grade) {
        Student student = new Student();
        student.name = name;
        student.age = age;
        student.grade = grade;
        return student;
    }

    static void printStudent(Student student) {
        System.out.println("이름:" + student.name + " 나이:" + student.age + " 성적:" + student.grade);
    }
}
```

`createStudent()` 메서드는 객체를 생성하고 초기값을 설정한 후, 생성한 객체의 참조값을 반환한다.

## 변수와 초기화

### 변수의 종류

1. **멤버 변수(필드)**: 클래스에 선언
2. **지역 변수**: 메서드에 선언, 매개변수도 지역 변수의 한 종류

### 멤버 변수 예시

```java
public class Student {
    String name;  // 멤버 변수
    int age;      // 멤버 변수
    int grade;    // 멤버 변수
}
```

### 지역 변수 예시

```java
public class ClassStart3 {
    public static void main(String[] args) {
        Student student1;                    // 지역 변수
        student1 = new Student();
        Student student2 = new Student();    // 지역 변수
    }
}
```

### 변수의 값 초기화

#### 멤버 변수: 자동 초기화
- 인스턴스의 멤버 변수는 인스턴스를 생성할 때 자동으로 초기화된다
- 숫자(`int`) = 0, `boolean` = false, 참조형 = `null`
- 개발자가 초기값을 직접 지정할 수 있다

#### 지역 변수: 수동 초기화
- 지역 변수는 항상 직접 초기화해야 한다

### 멤버 변수 초기화 예시

```java
package ref;

public class InitData {
    int value1;      // 초기화 하지 않음
    int value2 = 10; // 10으로 초기화
}
```

```java
package ref;

public class InitMain {
    public static void main(String[] args) {
        InitData data = new InitData();
        System.out.println("value1 = " + data.value1);
        System.out.println("value2 = " + data.value2);
    }
}
```

**실행 결과:**
```
value1 = 0
value2 = 10
```

## null

### null의 개념

참조형 변수에서 아직 가리키는 대상이 없다면 `null`이라는 특별한 값을 넣어둘 수 있다. `null`은 값이 존재하지 않는, 없다는 뜻이다.

### null 값 할당 예시

```java
package ref;

public class NullMain1 {
    public static void main(String[] args) {
        Data data = null;
        System.out.println("1. data = " + data);
        
        data = new Data();
        System.out.println("2. data = " + data);
        
        data = null;
        System.out.println("3. data = " + data);
    }
}
```

**실행 결과:**
```
1. data = null
2. data = ref.Data@x001
3. data = null
```

### GC - 아무도 참조하지 않는 인스턴스의 최후

`data`에 `null`을 할당했다. 따라서 앞서 생성한 Data 인스턴스를 더는 아무도 참조하지 않는다. 이렇게 아무도 참조하지 않게 되면 해당 인스턴스에 다시 접근할 방법이 없다.

자바는 이런 과정을 자동으로 처리해준다. 아무도 참조하지 않는 인스턴스가 있으면 JVM의 GC(가비지 컬렉션)가 더 이상 사용하지 않는 인스턴스라 판단하고 해당 인스턴스를 자동으로 메모리에서 제거해준다.

## NullPointerException

### NullPointerException이란?

`NullPointerException`은 이름 그대로 `null`을 가리키다(Pointer)인데, 이때 발생하는 예외(Exception)다. `null`은 없다는 뜻이므로 결국 주소가 없는 곳을 찾아갈 때 발생하는 예외이다.

### NullPointerException 발생 예시

```java
package ref;

public class NullMain2 {
    public static void main(String[] args) {
        Data data = null;
        data.value = 10; // NullPointerException 예외 발생
        System.out.println("data = " + data.value);
    }
}
```

**실행 결과:**
```
Exception in thread "main" java.lang.NullPointerException: Cannot assign field "value" because "data" is null
```

### 멤버 변수와 null

```java
package ref;

public class BigData {
    Data data;
    int count;
}
```

```java
package ref;

public class NullMain3 {
    public static void main(String[] args) {
        BigData bigData = new BigData();
        System.out.println("bigData.count=" + bigData.count);
        System.out.println("bigData.data=" + bigData.data);
        
        // NullPointerException
        System.out.println("bigData.data.value=" + bigData.data.value);
    }
}
```

`BigData`를 생성하면 `data` 멤버 변수는 참조형이므로 `null`로 초기화된다. `count` 멤버 변수는 숫자이므로 0으로 초기화된다.

### 해결 방법

```java
package ref;

public class NullMain4 {
    public static void main(String[] args) {
        BigData bigData = new BigData();
        bigData.data = new Data(); // Data 인스턴스 생성 후 할당
        
        System.out.println("bigData.count=" + bigData.count);
        System.out.println("bigData.data=" + bigData.data);
        System.out.println("bigData.data.value=" + bigData.data.value);
    }
}
```

## 문제와 풀이

### 문제: 상품 주문 시스템 개발 - 리팩토링

당신은 온라인 상점의 주문 관리 시스템을 만들려고 한다.

#### 요구 사항

`ProductOrder` 클래스는 다음과 같은 멤버 변수를 포함해야 한다:
- 상품명 (`productName`)
- 가격 (`price`)
- 주문 수량 (`quantity`)

#### ProductOrder 클래스

```java
package ref.ex;

public class ProductOrder {
    String productName;
    int price; 
    int quantity;
}
```

#### ProductOrderMain2 클래스

```java
package ref.ex;

public class ProductOrderMain2 {
    public static void main(String[] args) {
        ProductOrder[] orders = new ProductOrder[3];
        orders[0] = createOrder("두부", 2000, 2);
        orders[1] = createOrder("김치", 5000, 1);
        orders[2] = createOrder("콜라", 1500, 2);

        printOrders(orders);
        int totalAmount = getTotalAmount(orders);
        System.out.println("총 결제 금액: " + totalAmount);
    }

    static ProductOrder createOrder(String productName, int price, int quantity) {
        ProductOrder order = new ProductOrder();
        order.productName = productName;
        order.price = price;
        order.quantity = quantity;
        return order;
    }

    static void printOrders(ProductOrder[] orders) {
        for (ProductOrder order : orders) {
            System.out.println("상품명: " + order.productName + ", 가격: " + order.price + ", 수량: " + order.quantity);
        }
    }

    static int getTotalAmount(ProductOrder[] orders) {
        int totalAmount = 0;
        for (ProductOrder order : orders) {
            totalAmount += order.price * order.quantity;
        }
        return totalAmount;
    }
}
```

### 문제: 상품 주문 시스템 개발 - 사용자 입력

#### 요구 사항
- 주문 수량을 입력 받자
- 가격, 수량, 상품명을 입력 받자
- 입력이 끝나면 등록한 상품과 총 결제 금액을 출력하자

#### 해답

```java
package ref.ex;

import java.util.Scanner;

public class ProductOrderMain3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        ProductOrder[] orders = new ProductOrder[n];

        for (int i = 0; i < orders.length; i++) {
            System.out.println((i + 1) + "번째 주문 정보를 입력하세요.");
            System.out.print("상품명: ");
            String productName = scanner.nextLine();
            System.out.print("가격: ");
            int price = scanner.nextInt();
            System.out.print("수량: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // 입력 버퍼를 비우기 위한 코드

            orders[i] = createOrder(productName, price, quantity);
        }

        printOrders(orders);
        int totalAmount = getTotalAmount(orders);
        System.out.println("총 결제 금액: " + totalAmount);
    }

    static ProductOrder createOrder(String productName, int price, int quantity) {
        ProductOrder order = new ProductOrder();
        order.productName = productName;
        order.price = price;
        order.quantity = quantity;
        return order;
    }

    static void printOrders(ProductOrder[] orders) {
        for (ProductOrder order : orders) {
            System.out.println("상품명: " + order.productName + ", 가격: " + order.price + ", 수량: " + order.quantity);
        }
    }

    static int getTotalAmount(ProductOrder[] orders) {
        int totalAmount = 0;
        for (ProductOrder order : orders) {
            totalAmount += order.price * order.quantity;
        }
        return totalAmount;
    }
}
```

## 정리

### 대원칙: 자바는 항상 변수의 값을 복사해서 대입한다

자바에서 변수에 값을 대입하는 것은 변수에 들어 있는 값을 복사해서 대입하는 것이다. 기본형, 참조형 모두 항상 변수에 있는 값을 복사해서 대입한다.

### 기본형 vs 참조형 - 기본

- 자바의 데이터 타입을 가장 크게 보면 기본형과 참조형으로 나눌 수 있다
- 기본형을 제외한 나머지 변수는 모두 참조형이다
- 기본형 변수는 값을 직접 저장하지만, 참조형 변수는 참조(주소)를 저장한다
- 기본형 변수는 산술 연산을 수행할 수 있지만, 참조형 변수는 산술 연산을 수행할 수 없다
- 기본형 변수는 `null`을 할당할 수 없지만, 참조형 변수는 `null`을 할당할 수 있다

### 기본형 vs 참조형 - 대입

- 기본형과 참조형 모두 대입시 변수 안에 있는 값을 읽고 복사해서 전달한다
- 기본형은 사용하는 값을 복사해서 전달하고, 참조형은 참조값을 복사해서 전달한다
- 실제 인스턴스가 복사되는 것이 아니다. 인스턴스를 가리키는 참조값을 복사해서 전달하는 것이다

### 기본형 vs 참조형 - 메서드 호출

- 메서드 호출시 기본형은 메서드 내부에서 매개변수의 값을 변경해도 호출자의 변수 값에는 영향이 없다
- 메서드 호출시 참조형은 메서드 내부에서 매개변수로 전달된 객체의 멤버 변수를 변경하면, 호출자의 객체도 변경된다

---
