package method;

public class Method1 {

    public static void main(String[] args) {
        int sum1 = add(5, 10);
        System.out.println("결과1 출력: " + sum1);
    }

    // public: 다른 클래스에서 호출할 수 있는 메서드라는 뜻
    // static: 객체를 생성하지 않고 호출할 수 있는 정적 메서드라는 뜻이다
    // int: 반환 타입 정의
    // add: 메서드 이름
    public static int add(int a, int b){
        System.out.println(a + " + " + b + " 연산 수행");
        int sum = a + b;
        return sum;
    }
}
