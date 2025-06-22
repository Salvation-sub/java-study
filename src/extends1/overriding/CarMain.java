package extends1.overriding;

public class CarMain {
    public static void main(String[] args) {
        // 상속관계를 생성하면 인스턴스에 상속관계의 부모와 자식 모두가 자동 생성된다.
        // 상송 관계의 객체를 호출할떄 호출자의 타입을 통해 대상 타입을 찾는다.
        // 현재 타입에서 기능을 찾지 못하면 상위 타입으로 기능을 찾아서 실행.
        ElectricCar electricCar = new ElectricCar();
        electricCar.move();
        electricCar.charge();

        GasCar gasCar = new GasCar();
        gasCar.move();
        gasCar.fillUp();
        gasCar.openDoor();

        HydrogenCar hydrogenCar = new HydrogenCar();
        hydrogenCar.move();
        hydrogenCar.openDoor();
        hydrogenCar.fillHydrogen();
    }
}
