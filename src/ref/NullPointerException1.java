package ref;

public class NullPointerException1 {
    public static void main(String[] args) {
        Data data = null;
        // null.value = 10; 이랑 같다
        data.value = 10; // NullPointerException 예외 발생
        System.out.println("data = " + data.value);
    }
}
