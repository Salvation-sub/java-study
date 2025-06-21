package construct;

public class MemberConstruct {
    String name;
    int age;
    int grade;


    // 생성자 오버로딩
    MemberConstruct(String name , int age){
        this(name,age,50);
    }
    // 생성자
    // 생성자는 인스턴스를 생성하고 나서 즉시 호출된다. 생성자를 호출받은 방법은 new 명령어 다음에 생성자 이름과 매개변수에 맞추어 인수를 전달 하면 된다.
    // new 키워드를 사용해서 객체를 생성할 때 마지막 괄호 ()를 포함해야하는 이유는 생성자 때문
    MemberConstruct(String name, int age, int grade){
        System.out.println("생성장 호출 name = " + name + " age = " + age + " grade = " + grade);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
