package poly.ex3;

public abstract class AbstractAnimal {
    // 추상 메서드가 하나라도 있으면 추상 클래스로 선언되어야 한다.
    public abstract void sound();

    public void move() {
        System.out.println("동물이 움직입니다.");
    }
}
