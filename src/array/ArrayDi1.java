package array;

public class ArrayDi1 {

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6}
        }; // 행2, 열3

        for(int row = 0; row < arr.length; row++){
            for(int column = 0; column < arr[row].length; column++){
                System.out.println(arr[row][column] + " ");
            }
            System.out.println();
        }

    }
}
