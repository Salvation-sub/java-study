package extends1.overriding;

public class ElectricCar extends Car {

    // 오버라이드 애노테이션을 통해 메서드 오버라이드 즉 상속받은 메서드를 새로 재정의하는 것
    // 부모의 기능을 오버라이드할거라고 표식을 두는거다. 그렇기에 제대로 안되어 있을 경우 컴파일 오류를 내게 할 수 있다.
    // 애노테이션 자체가 없어도 오버라이딩은 가능하다.
    @Override
    public void move() {
        System.out.println("전기차를 빠르게 이동합니다");
    }

    public void charge(){
        System.out.println("충전합니다");
    }
}
