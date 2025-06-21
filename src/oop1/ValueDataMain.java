package oop1;

public class ValueDataMain {
    public static void main(String[] args) {
        ValueData valueData = new ValueData();

        add(valueData);
        add(valueData);
        add(valueData);
    }

    static void add(ValueData valueData){
        valueData.value++;
        System.out.println("숫자 증가: " + valueData.value);
    }
}
