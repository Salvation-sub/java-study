package static2;

public class DeconMain2 {

    public static void main(String[] args) {
        String s = "hello java";
        String deco = DecoUtil2.deco(s);

        System.out.println("Before: " + s);
        System.out.println("After: " + deco);
    }
}
