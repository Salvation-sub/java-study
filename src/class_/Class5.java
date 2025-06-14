package class_;

public class Class5 {
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

        Student[] students = new Student[]{student1, student2};

        // 기존 for 문 (itar)
        for(int i = 0; i < students.length; i++) {
            System.out.println(students[i].name + " " + students[i].age + " " + students[i].grade);
        }
        // 향상된 for 문 (iter)
        for (Student student : students) {
            System.out.println(student.name + " " + student.age + " " + student.grade);
        }
    }
}
