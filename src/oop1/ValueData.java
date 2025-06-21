package oop1;

public class ValueData {
    int value;

    // 메서드는 객체를 생성해야 호출 할수 있지만 static을 붙이면 객체를 생성하지 않고도 메서드 호출이 가능.
    void add() {
        value++;
        System.out.println("숫자 증가 value = " + value);
    }
}
