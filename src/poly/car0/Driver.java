package poly.car0;

public class Driver {
    private K3Car k3Car;
    private Model3 model3;

    public void setK3Car(K3Car k3Car) {
        this.k3Car = k3Car;
    }

    public void setModel3(Model3 model3) {
        this.model3 = model3;
    }

    public void drive() {
        System.out.println("자동차를 운전합니다");
        if (k3Car != null) {
            k3Car.startEngine();
            k3Car.pressAccelerator();
            k3Car.offEngine();
        } else if(model3 != null) {
            model3.startEngine();
            model3.pressAccelerator();
            model3.offEngine();
        }

    }
}
