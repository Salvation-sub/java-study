# Java 패키지(Package) 완전 가이드

## 목차
- [패키지 시작](#패키지-시작)
- [패키지 import](#패키지-import)
- [패키지 규칙](#패키지-규칙)
- [패키지 활용](#패키지-활용)
- [정리](#정리)

## 패키지 시작

쇼핑몰 시스템을 개발한다고 가정해보겠습니다. 프로그램이 작고 단순할 때는 문제없지만, 기능이 점점 추가되어 프로그램이 아주 커지게 되면 어떻게 될까요?

### 프로그램 규모별 비교

**아주 작은 프로그램**
```
Order
User
Product
```

**큰 프로그램**
```
User
UserManager
UserHistory
Product
ProductCatalog
ProductImage
Order
OrderService
OrderHistory
ShoppingCart
CartItem
Payment
PaymentHistory
Shipment
ShipmentTracker
```

매우 많은 클래스가 등장하면서 관련 있는 기능들을 분류해서 관리하고 싶을 것입니다.

컴퓨터는 보통 파일을 분류하기 위해 폴더, 디렉토리라는 개념을 제공합니다. 자바도 이런 개념을 제공하는데, 이것이 바로 **패키지**입니다.

### 패키지로 분류하기

```
* user
  * User
  * UserManager
  * UserHistory
* product
  * Product
  * ProductCatalog
  * ProductImage
* order
  * Order
  * OrderService
  * OrderHistory
* cart
  * ShoppingCart
  * CartItem
* payment
  * Payment
  * PaymentHistory
* shipping
  * Shipment
  * ShipmentTracker
```

여기서 `user`, `product` 등이 바로 패키지입니다. 해당 패키지 안에 관련된 자바 클래스들을 넣으면 됩니다.

**패키지(package)**는 이름 그대로 물건을 운송하기 위한 포장 용기나 그 포장 묶음을 뜻합니다.

### 패키지 사용법

패키지 사용법을 코드로 확인해보겠습니다.

⚠️ **중요:** 패키지를 먼저 만들고 그 다음에 클래스를 만들어야 합니다.

**pack.Data**
```java
package pack;

public class Data {
    public Data() {
        System.out.println("패키지 pack Data 생성");
    }
}
```

- 패키지를 사용하는 경우 항상 코드 첫줄에 `package pack`과 같이 패키지 이름을 적어주어야 합니다.
- 여기서는 `pack` 패키지에 `Data` 클래스를 만들었습니다.
- 이후에 `Data` 인스턴스가 생성되면 생성자를 통해 정보를 출력합니다.

**pack.a.User**
```java
package pack.a;

public class User {
    public User() {
        System.out.println("패키지 pack.a 회원 생성");
    }
}
```

- `pack` 하위에 `a`라는 패키지를 먼저 만듭니다.
- `pack.a` 패키지에 `User` 클래스를 만들었습니다.

> 💡 **참고:** 생성자에 `public`을 사용했습니다. 다른 패키지에서 이 클래스의 생성자를 호출하려면 `public`을 사용해야 합니다.

**pack.PackageMain1**
```java
package pack;

public class PackageMain1 {
    public static void main(String[] args) {
        Data data = new Data();
        pack.a.User user = new pack.a.User();
    }
}
```

**실행 결과:**
```
패키지 pack Data 생성
패키지 pack.a 회원 생성
```

### 패키지 사용 규칙

- **사용자와 같은 위치:** `PackageMain1`과 `Data`는 같은 `pack` 패키지에 소속되어 있습니다. 같은 패키지에 있는 경우에는 패키지 경로를 생략해도 됩니다.

- **사용자와 다른 위치:** `PackageMain1`과 `User`는 서로 다른 패키지입니다. 패키지가 다르면 `pack.a.User`와 같이 패키지 전체 경로를 포함해서 클래스를 적어주어야 합니다.

## 패키지 import

### import 사용하기

패키지가 다르다고 `pack.a.User`와 같이 항상 전체 경로를 적어주는 것은 불편합니다. 이때는 `import`를 사용하면 됩니다.

**PackageMain2.java**
```java
package pack;

import pack.a.User;

public class PackageMain2 {
    public static void main(String[] args) {
        Data data = new Data();
        User user = new User(); // import 사용으로 패키지 명 생략 가능
    }
}
```

**실행 결과:**
```
패키지 pack Data 생성
패키지 pack.a 회원 생성
```

### import 사용법

- 코드에서 첫줄에는 `package`를 사용하고, 다음 줄에는 `import`를 사용할 수 있습니다.
- `import`를 사용하면 다른 패키지에 있는 클래스를 가져와서 사용할 수 있습니다.
- `import`를 사용한 덕분에 코드에서는 패키지 명을 생략하고 클래스 이름만 적을 수 있습니다.

### 패키지 별(*) 사용

특정 패키지에 포함된 모든 클래스를 포함해서 사용하고 싶으면 `import` 시점에 `*(별)`을 사용하면 됩니다.

```java
package pack;

import pack.a.*; // pack.a의 모든 클래스 사용

public class PackageMain2 {
    public static void main(String[] args) {
        Data data = new Data();
        User user = new User(); // import 사용으로 패키지 명 생략 가능
    }
}
```

이렇게 하면 `pack.a` 패키지에 있는 모든 클래스를 패키지 명을 생략하고 사용할 수 있습니다.

### 클래스 이름 중복

패키지 덕분에 클래스 이름이 같아도 패키지 이름으로 구분해서 같은 이름의 클래스를 사용할 수 있습니다.

```
pack.a.User
pack.b.User
```

이런 경우 클래스 이름이 둘다 `User`이지만 패키지 이름으로 대상을 구분할 수 있습니다.

**pack.b.User**
```java
package pack.b;

public class User {
    public User() {
        System.out.println("패키지 pack.b 회원 생성");
    }
}
```

**중복된 클래스명 처리**
```java
package pack;

import pack.a.User;

public class PackageMain3 {
    public static void main(String[] args) {
        User userA = new User();
        pack.b.User userB = new pack.b.User();
    }
}
```

같은 이름의 클래스가 있다면 `import`는 둘 중 하나만 선택할 수 있습니다. 이때는:
- 자주 사용하는 클래스를 `import` 하고
- 나머지를 패키지를 포함한 전체 경로를 적어주면 됩니다.
- 물론 둘다 전체 경로를 적어준다면 `import`를 사용하지 않아도 됩니다.

## 패키지 규칙

### 패키지 규칙

1. **패키지의 이름과 위치는 폴더(디렉토리) 위치와 같아야 합니다.** (필수)

2. **패키지 이름은 모두 소문자를 사용합니다.** (관례)

3. **패키지 이름의 앞 부분에는 일반적으로 회사의 도메인 이름을 거꾸로 사용합니다.**
    - 예: `com.company.myapp`과 같이 사용 (관례)
    - 이 부분은 필수는 아닙니다. 하지만 수많은 외부 라이브러리가 함께 사용되면 같은 패키지에 같은 클래스 이름이 존재할 수도 있습니다.
    - 도메인 이름을 거꾸로 사용하면 이런 문제를 방지할 수 있습니다.

### 도메인 이름 사용 가이드

- **오픈소스나 라이브러리를 만들어서 외부에 제공한다면** 꼭 지키는 것이 좋습니다.
- **내가 만든 애플리케이션을 다른 곳에 공유하지 않고, 직접 배포한다면** 보통 문제가 되지 않습니다.

### 패키지와 계층 구조

패키지는 보통 다음과 같이 계층 구조를 이룹니다.

```
a
├── b
└── c
```

이렇게 하면 다음과 같이 총 3개의 패키지가 존재합니다:
- `a`
- `a.b`
- `a.c`

계층 구조상 `a` 패키지 하위에 `a.b` 패키지와 `a.c` 패키지가 있습니다.

⚠️ **중요:** 이것은 우리 눈에 보기에 계층 구조를 이룰 뿐입니다. `a` 패키지와 `a.b`, `a.c` 패키지는 서로 완전히 다른 패키지입니다.

따라서:
- `a` 패키지의 클래스에서 `a.b` 패키지의 클래스가 필요하면 `import` 해서 사용해야 합니다.
- 반대도 물론 마찬가지입니다.

**정리하면 패키지가 계층 구조를 이루더라도 모든 패키지는 서로 다른 패키지입니다.**

## 패키지 활용

실제 패키지가 어떤 식으로 사용되는지 예제를 통해서 알아보겠습니다. 실제 동작하는 코드는 아니지만, 큰 애플리케이션은 대략 이런 식으로 패키지를 구성한다고 이해하면 됩니다.

### 전체 구조도

```
com.helloshop
├── user
│   ├── User
│   └── UserService
├── product
│   ├── Product
│   └── ProductService
└── order
    ├── Order
    ├── OrderService
    └── OrderHistory
```

### com.helloshop.user 패키지

**User.java**
```java
package com.helloshop.user;

public class User {
    String userId;
    String name;
}
```

**UserService.java**
```java
package com.helloshop.user;

public class UserService {
}
```

### com.helloshop.product 패키지

**Product.java**
```java
package com.helloshop.product;

public class Product {
    String productId;
    int price;
}
```

**ProductService.java**
```java
package com.helloshop.product;

public class ProductService {
}
```

### com.helloshop.order 패키지

**Order.java**
```java
package com.helloshop.order;

import com.helloshop.product.Product;
import com.helloshop.user.User;

public class Order {
    User user;
    Product product;

    public Order(User user, Product product) {
        this.user = user;
        this.product = product;
    }
}
```

- 다른 패키지의 기능이 필요하면 `import`를 사용하면 됩니다.
- 생성자를 보면 `public`이 붙어있습니다. `public`이 붙어있어야 다른 패키지에서 생성자를 호출할 수 있습니다.

**OrderService.java**
```java
package com.helloshop.order;

import com.helloshop.product.Product;
import com.helloshop.user.User;

public class OrderService {
    public void order() {
        User user = new User();
        Product product = new Product();
        Order order = new Order(user, product);
    }
}
```

**OrderHistory.java**
```java
package com.helloshop.order;

public class OrderHistory {
}
```

### 패키지 구성 원칙

패키지를 구성할 때:
- **서로 관련된 클래스는 하나의 패키지에 모으고**
- **관련이 적은 클래스는 다른 패키지로 분리하는 것이 좋습니다**

## 정리

### 패키지 핵심 개념

1. **패키지는 클래스를 논리적으로 그룹화하는 메커니즘입니다**
2. **같은 패키지 내의 클래스는 패키지명 없이 직접 사용 가능합니다**
3. **다른 패키지의 클래스는 전체 경로를 명시하거나 import를 사용해야 합니다**
4. **패키지는 물리적 디렉토리 구조와 일치해야 합니다**
5. **계층 구조로 보이지만 각 패키지는 독립적입니다**

### 베스트 프랙티스

- **도메인 기반으로 패키지를 구성하세요** (user, product, order 등)
- **기능별로 관련 클래스들을 같은 패키지에 배치하세요**
- **패키지명은 소문자를 사용하고 의미있는 이름을 선택하세요**
- **외부 배포용 라이브러리는 도메인 역순 명명 규칙을 따르세요**

### 주의사항

- **패키지 선언은 반드시 파일의 첫 번째 비주석 줄에 위치해야 합니다**
- **하나의 파일에는 하나의 패키지만 선언할 수 있습니다**
- **패키지와 디렉토리 구조는 정확히 일치해야 합니다**
- **대소문자를 구분하므로 정확한 패키지명을 사용해야 합니다**