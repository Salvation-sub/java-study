package construct;

public class MethodInitMain1 {

    public static void main(String[] args) {
        MemberInit member = new MemberInit();
        member.name = "user1";
        member.age = 18;
        member.grade = 80;

        MemberInit[] members = {member};

        for (MemberInit s : members) {
            System.out.println("이름: "  + s.name + "나이 : "  + s.age + "성적: " + s.grade);
        }
    }
}
