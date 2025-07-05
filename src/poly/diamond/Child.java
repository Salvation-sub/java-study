package poly.diamond;

public class Child implements InterfaceA , InterfaceB {
    @Override
    public void methodA() {
        System.out.println("methodA");
    }

    @Override
    public void methodCommon() {
        System.out.println("methodCommon");
    }

    @Override
    public void methodB() {
        System.out.println("methodB");
    }
}
