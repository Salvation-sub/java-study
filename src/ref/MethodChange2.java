package ref;

public class MethodChange2 {

    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        System.out.println("메서드 호출 전: a = " + dataA.value);
        changeReference(dataA);
        System.out.println("메서드 호출 후: a = " + dataA.value);
    }

    static void changeReference(Data dataA){
        dataA.value = 20;
    }
}
