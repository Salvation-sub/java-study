package poly.ex5;

public class SoundFlyMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Bird bird = new Bird();

        soundAnimal(dog);
        soundAnimal(bird);

        // dog는 fly 인터페이스가 없음.
        // flyAnimal(dog);
        flyAnimal(bird);
    }

    // AbstractAnimal 사용 가능
    private static void soundAnimal(AbstractAnimal animal){
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }

    // Fly 인터페이스가 있으면 사용 가능
    private static void flyAnimal(Fly fly){
        System.out.println("동물 소리 테스트 시작");
        fly.fly();
        System.out.println("동물 소리 테스트 종료");
    }
}
