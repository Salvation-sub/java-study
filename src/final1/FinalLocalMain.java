package final1;

public class FinalLocalMain {

    public static void main(String[] args) {
        // final 지역 변수
        final int data1;
        data1 = 10; // 최초 한번만 할당 가능
        // data1 = 20; // 재할당시 컴파일 오류 발생

        method(10);
    }

    static void method(final int parameter){
        // parameter = 20; 매소드 내부에서 해당 값을 변경할 수 없다.
    }
}
