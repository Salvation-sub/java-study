package poly.basic;

public class CastingMain6 {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        call(parent1);

        Parent parent2 = new Child();
        call(parent2);
    }

    private static void call(Parent parent){
        parent.parentMethod();
        // Child 인스터스의 경우 childMethod() 실행
        // 자바 16 버전부터 instanceof 메소드와 함께 변수 실행 가능
        if(parent instanceof Child child){
            System.out.println("Child 인스턴스 맞음");
            child.childMethod();
        }
    }
}
