## 🎯 객체 지향 프로그래밍 핵심 개념 정리

### 1. 절차 지향 vs 객체 지향의 근본적 차이

**정답: C - 문제를 바라보는 관점 및 구조화 방식**

| 구분 | 절차 지향 | 객체 지향 |
|------|-----------|-----------|
| **관점** | "어떻게(How)" 중심 | "무엇(What)" 중심 |
| **접근법** | 실행 순서와 절차 중시 | 객체의 역할과 관계 중시 |
| **구조** | Top-down 방식 | Bottom-up 방식 |

```java
// 절차 지향적 사고: "어떻게 실행할까?"
// 1. 데이터 준비
// 2. 계산 수행  
// 3. 결과 출력

// 객체 지향적 사고: "무엇이 있고, 어떤 관계인가?"
// 계산기 객체가 있고, 숫자를 입력받아 연산을 수행한다
```

### 2. 데이터와 기능의 관계

**정답: A - 데이터와 기능이 완전히 분리되어 있다 vs 데이터와 기능이 객체 안에 함께 묶여 있다**

```java
// 절차 지향: 데이터와 기능 분리
class PlayerData {
    int volume;
    boolean isOn;
}

static void volumeUp(PlayerData data) {  // 기능이 외부에 분리
    data.volume++;
}

// 객체 지향: 데이터와 기능 통합
class MusicPlayer {
    private int volume;     // 데이터
    private boolean isOn;
    
    public void volumeUp() {  // 기능이 내부에 포함
        this.volume++;
    }
}
```

### 3. 캡슐화(Encapsulation)

**정답: D - 캡슐화 (Encapsulation)**

```java
class BankAccount {
    private int balance;        // 데이터를 캡슐 안에 보호
    
    public void deposit(int amount) {    // 기능도 함께 캡슐화
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public int getBalance() {   // 안전한 방법으로만 데이터 접근 허용
        return balance;
    }
}
```

**캡슐화의 장점:**
- 🛡️ **데이터 보호**: 외부에서 직접 접근 차단
- 🔧 **유지보수성**: 내부 구현 변경이 외부에 영향 없음
- 📦 **모듈화**: 관련된 것들을 하나의 단위로 관리

### 4. 객체의 구성 요소

**정답: B - 속성(데이터)과 기능(메서드)**

```java
// 현실 세계의 자동차를 객체로 모델링
class Car {
    // 속성 (데이터): 자동차의 상태
    private String color;
    private int speed;
    private boolean engineOn;
    
    // 기능 (메서드): 자동차가 할 수 있는 행동
    public void startEngine() { engineOn = true; }
    public void accelerate() { speed += 10; }
    public void brake() { speed -= 10; }
}
```

**객체 모델링 예시:**

| 현실 객체 | 속성 | 기능 |
|-----------|------|------|
| **학생** | 이름, 학번, 성적 | 공부하다, 시험보다 |
| **계좌** | 잔액, 계좌번호 | 입금하다, 출금하다 |
| **게임캐릭터** | 레벨, HP, 아이템 | 이동하다, 공격하다 |

### 5. 메서드와 객체 데이터의 관계

**정답: C - 메서드가 속한 객체 자신의 데이터**

```java
class Account {
    private int balance = 1000;  // 이 객체의 고유한 데이터
    
    public void withdraw(int amount) {
        // 이 메서드는 자신이 속한 객체의 balance를 사용/변경
        if (this.balance >= amount) {
            this.balance -= amount;  // 자신의 데이터 변경
            System.out.println("출금 완료. 잔액: " + this.balance);
        }
    }
}

// 사용 예시
Account myAccount = new Account();
Account yourAccount = new Account();

myAccount.withdraw(500);    // myAccount의 balance만 변경됨
yourAccount.withdraw(300);  // yourAccount의 balance만 변경됨
```

## 🔑 핵심 원칙 요약

### 객체 지향의 핵심 사상

1. **현실 모델링**: 프로그램을 현실 세계의 객체들과 그들의 상호작용으로 설계
2. **책임 분산**: 각 객체가 자신의 데이터와 행동에 대한 책임을 가짐
3. **정보 은닉**: 객체의 내부 구현을 외부에서 접근하지 못하게 보호
4. **재사용성**: 잘 설계된 객체는 여러 곳에서 재사용 가능

### 설계 질문들

객체를 설계할 때 스스로에게 물어보세요:

- 🤔 **"이 객체는 무엇인가?"** (정체성)
- 📊 **"이 객체는 어떤 상태를 가지는가?"** (속성)
- ⚡ **"이 객체는 무엇을 할 수 있는가?"** (기능)
- 🔒 **"외부에서 어떤 것까지 접근해도 될까?"** (캡슐화)

