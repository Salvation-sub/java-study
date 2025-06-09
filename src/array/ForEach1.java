package array;

public class ForEach1 {

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6}
        }; // 행2, 열3

        // 향상된 for문 사용
        for(int[] row : arr) {
            for(int value : row) {
                System.out.println(value + " ");
            }
            System.out.println();
        }
    }
}
