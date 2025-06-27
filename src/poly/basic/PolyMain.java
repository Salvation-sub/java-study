package poly.basic;

public class PolyMain {
    public static void main(String[] args) {
        // 부모 변수가 부모 인스턴스 참조
        System.out.println("Parent -> Parent");
        Parent parent = new Parent();
        parent.parentMethod();

        // 자식 변수가 자식 인스턴스 참조
        System.out.println("Child -> Child");
        Child child = new Child();
        child.parentMethod();
        child.childMethod();

        // 부모 변수가 자식 인스턴스 참조(다형적 참조)
        System.out.println("Parent -> Child");
        // 부모타입은 자식 타입을 담을 수 있다.
        Parent poly = new Child();
        poly.parentMethod();

        // 자식 타입은 부모를 담을수 없다.
//        Child child1 = new Parent();
    }
}
