package scope;

public class Casting2 {
    public static void main(String[] args) {
        // 큰 범위에서 작은 범위로 변환하면 명시적 형변환을 진행해줘야한다
        // int => (int) double
        double doubleValue = 1.5;
        int intValue = 0;

        // intValue = doubleValue; // int => double 컴파일 오류 발생
        intValue = (int) doubleValue; // 명시적 형변환
        System.out.println(intValue);
    }
}
