package extends1.super1;

public class Child extends Parent {
    public String value = "child";

    @Override
    public void hello(){
        System.out.println("Child.hello");
    }

    public void call(){
        // this는 본인꺼에서 찾는다
        // super은 부모(상위)꺼에서 찾아서 호출한다
        System.out.println("this value = " + this.value); // this 생략 가능
        System.out.println("super value = " + super.value);

        this.hello(); // this 생략 가능
        super.hello();
    }
}
