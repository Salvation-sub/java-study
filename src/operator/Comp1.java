package operator;

public class Comp1 {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;

        System.out.println(a == b);
        System.out.println(a != b);
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a >= b);
        System.out.println(a <= b);

        String str1 = "문자열1";
        String str2 = "문자열2";

        boolean result1 = "hello1".equals("hello1"); // 리터럴 비교
        boolean result2 = str1.equals("문자열1"); // 문자열 변수, 리터럴 비교

        System.out.println(result1);
        System.out.println(result2);
    }
}
