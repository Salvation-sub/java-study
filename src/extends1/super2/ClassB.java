package extends1.super2;

public class ClassB extends ClassA{

    public ClassB(int a){
        // 부모 클래스의 생성자를 먼저 호출해준다
        super(); // 기본 생성자 생략 가능
        System.out.println("ClassB 생성자 a = " + a);
    }

    public ClassB(int a, int b){
        // 부모 클래스의 생성자를 먼저 호출해준다
        super(); // 기본 생성자 생략 가능
        System.out.println("ClassB 생성자 a= " + a + " b = "  + b);
    }
}
