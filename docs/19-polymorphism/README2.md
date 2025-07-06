# 다형성과 설계 (Polymorphism)

## 목차
- [좋은 객체 지향 프로그래밍이란?](#좋은-객체-지향-프로그래밍이란)
- [다형성의 실세계 비유](#다형성의-실세계-비유)
- [역할과 구현을 분리](#역할과-구현을-분리)
- [자바 언어의 다형성](#자바-언어의-다형성)
- [다형성의 본질](#다형성의-본질)
- [OCP(Open-Closed Principle) 원칙](#ocpopen-closed-principle-원칙)
- [전략 패턴(Strategy Pattern)](#전략-패턴strategy-pattern)
- [문제와 풀이](#문제와-풀이)

## 좋은 객체 지향 프로그래밍이란?

### 객체 지향 특징
- **추상화**: 복잡한 현실을 단순화하여 모델링
- **캡슐화**: 데이터와 메서드를 하나로 묶어 관리
- **상속**: 기존 클래스의 특성을 물려받아 재사용
- **다형성**: 같은 인터페이스로 다양한 구현체 사용

### 객체 지향 프로그래밍

객체 지향 프로그래밍은 컴퓨터 프로그램을 명령어의 목록으로 보는 시각에서 벗어나 여러 개의 독립된 단위, 즉 "객체"들의 모임으로 파악하고자 하는 것이다. 각각의 객체는 메시지를 주고받고, 데이터를 처리할 수 있다.

객체 지향 프로그래밍은 프로그램을 유연하고 변경이 용이하게 만들기 때문에 대규모 소프트웨어 개발에 많이 사용된다.

### 유연하고, 변경이 용이?

- 레고 블럭 조립하듯이
- 키보드, 마우스 같아 끼우듯이
- 컴퓨터 부품 같아 끼우듯이
- 컴포넌트를 쉽고 유연하게 변경하면서 개발할 수 있는 방법

## 다형성의 실세계 비유

### 운전자 - 자동차

**실세계와 객체 지향을 1:1로 매칭**
- 그래도 실세계의 비유로 이해하기에는 좋음
- **역할과 구현으로 세상을 구분**

**공연 무대**
**로미오와 줄리엣 공연**

- 로미오 역할 → 줄리엣 역할
- 장동건 원빈 → 김태희 송혜교

운전자는 자동차(Car)의 역할에만 의존한다. 구현인 K3, Model3 자동차에 의존하지 않는다. 자동차의 역할만 알고 있어도 충분하다.

## 역할과 구현을 분리

### 역할과 구현을 분리한 장점

**역할과 구현으로 구분하면 세상이 단순해지고, 유연해져서 변경도 편리해진다.**

장점:
- **클라이언트는 대상의 역할(인터페이스)만 알면 된다.**
- **클라이언트는 구현 대상의 내부 구조를 몰라도 된다.**
- **클라이언트는 구현 대상의 내부 구조가 변경되어도 영향을 받지 않는다.**
- **클라이언트는 구현 대상 자체를 변경해도 영향을 받지 않는다.**

### 역할과 구현을 분리 - 자바 언어

자바 언어의 다형성 활용:
- **역할 = 인터페이스**
- **구현 = 인터페이스를 구현한 클래스, 구현 객체**

객체를 설계할 때 역할과 구현을 명확히 분리해야 한다.

객체 설계시 역할(인터페이스)을 먼저 부여하고, 그 역할을 수행하는 구현 객체 만들기

### 객체의 협력이라는 관계부터 생각

- 혼자 있는 객체는 없다.
- **클라이언트: 요청, 서버: 응답**
- 수 많은 객체 클라이언트와 객체 서버는 서로 협력 관계를 가진다.

## 자바 언어의 다형성

- **오버라이딩을 떠올려보자**
- **오버라이딩은 자바 기본 문법**
- **오버라이딩 된 메서드가 실행**
- **다형성으로 인터페이스를 구현한 객체를 실행 시점에 유연하게 변경할 수 있다.**
- **물론 클래스 상속 관계도 다형성, 오버라이딩 적용가능**

## 다형성의 본질

- **인터페이스를 구현한 객체 인스턴스를 실행 시점에 유연하게 변경할 수 있다.**
- 다형성의 본질을 이해하려면 **협력**이라는 객체사이의 관계에서 시작해야함
- **클라이언트를 변경하지 않고, 서버의 구현 기능을 유연하게 변경할 수 있다.**

### 역할과 구현을 분리 - 정리

- 실세계의 역할과 구현이라는 편리한 컨셉을 다형성을 통해 객체 세상으로 가져올 수 있음
- 유연하고, 변경이 용이
- 확장 가능한 설계
- 클라이언트에 영향을 주지 않는 변경 가능
- **인터페이스를 안정적으로 잘 설계하는 것이 중요**

## OCP(Open-Closed Principle) 원칙

좋은 객체 지향 설계 원칙 중 하나로 OCP 원칙이라는 것이 있다.

- **Open for extension**: 새로운 기능의 추가나 변경 사항이 생겼을 때, 기존 코드는 확장할 수 있어야 한다.
- **Closed for modification**: 기존의 코드는 수정되지 않아야 한다.

확장에는 열려있고, 변경에는 닫혀 있다는 뜻인데, 쉽게 이야기해서 기존의 코드 수정 없이 새로운 기능을 추가할 수 있다는 의미다.

### 새로운 차량의 추가

새로운 차량을 추가해도 Driver의 코드는 전혀 변경하지 않는다. 운전할 수 있는 차량의 종류가 계속 늘어나도 Car를 사용하는 Driver의 코드는 전혀 변경하지 않는다. 기능을 확장해도 main() 일부를 제외한 프로그램의 핵심 부분의 코드는 전혀 수정하지 않아도 된다.

### 확장에 열려있다는 의미
Car 인터페이스를 사용해서 새로운 차량을 자유롭게 추가할 수 있다. Car 인터페이스를 구현해서 기능을 추가할 수 있다는 의미이다. 그리고 Car 인터페이스를 사용하는 클라이언트 코드인 Driver도 Car 인터페이스를 통해 새롭게 추가된 차량을 자유롭게 호출할 수 있다. 이것이 확장에 열려있다는 의미이다.

### 코드 수정은 닫혀 있다는 의미
새로운 차를 추가하게 되면 기능이 추가되기 때문에 기존 코드의 수정은 불가피하다. 당연히 어딘가의 코드는 수정해야 한다.

### 변하지 않는 부분
새로운 자동차를 추가할 때 가장 영향을 받는 중요한 클라이언트는 바로 Car의 기능을 사용하는 Driver이다. 핵심은 Car 인터페이스를 사용하는 클라이언트인 Driver의 코드를 수정하지 않아도 된다는 뜻이다.

### 변하는 부분
main()과 같이 새로운 차를 생성하고 Driver에게 필요한 차를 전달해주는 역할은 당연히 코드 수정이 발생한다. main()은 전체 프로그램을 설정하고 조율하는 역할을 한다. 이런 부분은 OCP를 지켜도 변경이 필요하다.

### 정리
- Car를 사용하는 클라이언트 코드인 Driver 코드의 변경없이 새로운 자동차를 확장할 수 있다.
- 다형성을 활용하고 역할과 구현을 잘 분리한 덕분에 새로운 자동차를 추가해도 대부분의 핵심 코드들을 그대로 유지할 수 있게 되었다.

## 전략 패턴(Strategy Pattern)

디자인 패턴 중에 가장 중요한 패턴을 하나 뽑으라고 하면 전략 패턴을 뽑을 수 있다. 전략 패턴은 알고리즘을 클라이언트 코드의 변경 없이 쉽게 교체할 수 있다. 방금 설명한 코드가 바로 전략 패턴을 사용한 코드이다. Car 인터페이스가 바로 전략을 정의하는 인터페이스가 되고, 각각의 차량이 전략의 구체적인 구현이 된다. 그리고 전략을 클라이언트 코드(Driver)의 변경 없이 손쉽게 교체할 수 있다.

## 문제와 풀이

### 문제1: 다중 메시지 발송

한번에 여러 곳에 메시지를 발송하는 프로그램을 개발하자.

**요구사항:**
- 다형성을 활용하세요.
- Sender 인터페이스를 사용하세요.
- EmailSender, SmsSender, FaceBookSender를 구현하세요.

**실행 결과:**
```
메일을 발송합니다: 환영합니다!
SMS를 발송합니다: 환영합니다!
페이스북에 발송합니다: 환영합니다!
```

**정답:**

```java
// Sender 인터페이스
public interface Sender {
    void sendMessage(String message);
}

// EmailSender 구현체
public class EmailSender implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("메일을 발송합니다: " + message);
    }
}

// SmsSender 구현체
public class SmsSender implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS를 발송합니다: " + message);
    }
}

// FaceBookSender 구현체
public class FaceBookSender implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("페이스북에 발송합니다: " + message);
    }
}

// 메인 클래스
public class SendMain {
    public static void main(String[] args) {
        Sender[] senders = {new EmailSender(), new SmsSender(), new FaceBookSender()};
        for (Sender sender : senders) {
            sender.sendMessage("환영합니다!");
        }
    }
}
```

### 문제2: 결제 시스템 개발

여러분은 기대하던 결제 시스템 개발팀에 입사하게 되었다. 이 팀은 현재 2가지 결제 수단을 지원한다. 앞으로 5개의 결제 수단을 추가로 지원할 예정이다. 새로운 결제수단을 쉽게 추가할 수 있도록, 기존 코드를 리팩토링해라.

**요구사항:**
- OCP 원칙을 지키세요.
- 메서드를 포함한 모든 코드를 변경해도 됩니다.
- PayMain0 코드는 변경하지 않고, 그대로 유지해야 합니다.
- 리팩토링 후에도 실행 결과는 기존과 같아야 합니다.

**정답:**

```java
// Pay 인터페이스
public interface Pay {
    boolean pay(int amount);
}

// KakaoPay 구현체
public class KakaoPay implements Pay {
    @Override
    public boolean pay(int amount) {
        System.out.println("카카오페이 시스템과 연결합니다.");
        System.out.println(amount + "원 결제를 시도합니다.");
        return true;
    }
}

// NaverPay 구현체
public class NaverPay implements Pay {
    @Override
    public boolean pay(int amount) {
        System.out.println("네이버페이 시스템과 연결합니다.");
        System.out.println(amount + "원 결제를 시도합니다.");
        return true;
    }
}

// DefaultPay 구현체 (결제 수단이 없을 때)
public class DefaultPay implements Pay {
    @Override
    public boolean pay(int amount) {
        System.out.println("결제 수단이 없습니다.");
        return false;
    }
}

// PayStore - 결제 수단 찾기
public abstract class PayStore {
    public static Pay findPay(String option) {
        if (option.equals("kakao")) {
            return new KakaoPay();
        } else if (option.equals("naver")) {
            return new NaverPay();
        } else {
            return new DefaultPay();
        }
    }
}

// PayService - 결제 처리
public class PayService {
    public void processPay(String option, int amount) {
        System.out.println("결제를 시작합니다: option=" + option + ", amount=" + amount);
        
        Pay pay = PayStore.findPay(option);
        boolean result = pay.pay(amount);
        
        if (result) {
            System.out.println("결제가 성공했습니다.");
        } else {
            System.out.println("결제가 실패했습니다.");
        }
    }
}
```

### 문제3: 결제 시스템 개발 - 사용자 입력

기존 결제 시스템이 사용자 입력을 받도록 수정하세요.

**정답:**

```java
import java.util.Scanner;

public class PayMain2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayService payService = new PayService();
        
        while (true) {
            System.out.print("결제 수단을 입력하세요:");
            String payOption = scanner.nextLine();
            
            if (payOption.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }
            
            System.out.print("결제 금액을 입력하세요:");
            int amount = scanner.nextInt();
            scanner.nextLine();
            
            payService.processPay(payOption, amount);
        }
    }
}
```

## 정리

- **다형성이 가장 중요하다!**
- 디자인 패턴 대부분은 다형성을 활용하는 것이다.
- 스프링의 핵심인 제어의 역전(IoC), 의존관계 주입(DI)도 결국 다형성을 활용하는 것이다.
- 스프링을 사용하면 마치 레고 블럭 조립하듯이 공연 무대의 배우를 선택하듯이 구현을 편리하게 변경할 수 있다.