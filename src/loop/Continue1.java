package loop;

public class Continue1 {

    public static void main(String[] args) {
        int i = 1;
        // continue를 만나면 아래 내용을 실행하지 않고 while의 조건문으로 돌아간다.
        while(i <= 5){
            if(i == 3){
                i++;
                continue;
            }

            System.out.println(i);
            i++;
        }
    }
}
