package class_;

public class Class4 {
    public static void main(String[] args) {
        // Student 타입을 받을 수 있는 변수를 선언한다.
        Student student1;
        // new 키워드로 객체(인스턴스) 생성
        student1 = new Student();
        student1.name = "학생1";
        student1.age = 15;
        student1.grade = 90;

        Student student2 = new Student();
        student2.name = "학생2";
        student2.age = 18;
        student2.grade = 80;

        Student[] students = new Student[2];
        students[0] = student1;
        students[1] = student2;

        System.out.println("이름: " + student1.name + "나이: " + student1.age + "성적: " + student1.grade);
        System.out.println("이름: " + student2.name + "나이: " + student2.age + "성적: " + student2.grade);
    }
}
