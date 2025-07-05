package poly.ex3;

public class AbstractMain {
    public static void main(String[] args) {
        // 추상클래스 생성 불가
//        AbstractAnimal animal = new AbstractAnimal();

        Dog dog = new Dog();

        dog.move();
        dog.sound();
    }
}
