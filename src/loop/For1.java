package loop;

public class For1 {
    public static void main(String[] args) {
        int sum = 0;
        int endNum = 3;

        for(int i = 1; i <= endNum; i++){
            sum = sum + 1;
            System.out.println("i=" + i + " sum=" + sum);
        }
    }
}
