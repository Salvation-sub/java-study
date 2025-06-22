package extends1.super2;

public class ClassC extends ClassB{

    public ClassC(){
        // 부모 클래스의 생성자를 먼저 호출해준다
        super(10,20);
        System.out.println("ClassC 생성자");
    }
}
