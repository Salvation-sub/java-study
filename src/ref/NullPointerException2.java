package ref;

public class NullPointerException2 {
    public static void main(String[] args) {
        BigData bigData = new BigData();
        bigData.data = new Data();
        System.out.println("bigData.count = " + bigData.count); // count는 0으로 초기화
        System.out.println("bigData.data = " + bigData.data); // data는 참조형이기 떄문에 null로 초기화

        System.out.println("bigData.data.value = " + bigData.data.value); // null.value 를 부르기 떄문에 nullPointerException 에러가 뜬다
    }
}
