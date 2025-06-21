package ref;

public class VarChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        Data dataB = dataA; // dataA의 참조값을 복사해서 dataB에 대입

        // dataA를 통해 값 변경
        dataA.value = 20;
        System.out.println("dataA.value = " + dataA.value); // 20
        System.out.println("dataB.value = " + dataB.value); // 20 (함께 변경됨!)
    }
}
