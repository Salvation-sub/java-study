package class_;

public class Class2 {

    public static void main(String[] args) {
        String[] studentNames = {"학생1" , "학생2"};
        int[] studentAges = {15, 16};
        int[] studentGrades = {90, 80};

        for(int i = 0; i < studentNames.length; i++){
            System.out.println("이름: " + studentNames[i] + " 나이: " + studentAges[i] + " 성적: " + studentGrades[i]);
        }
    }
}
