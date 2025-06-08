package scope;

public class Casting1 {
    public static void main(String[] args) {
        // 작은 범위에서 큰 범위 대입은 자동 형변환이 이러난다
        // int => long 자동으로 변환
        int intValue = 10;
        long longValue;
        double doubleValue;

        longValue = intValue; // int => long
        System.out.println(longValue);

        doubleValue = intValue; // int => double
        System.out.println(doubleValue);

        doubleValue = 20L; // long => double
        System.out.println(doubleValue);
    }
}
