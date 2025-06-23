package static2;

public class DeconMain1 {

    public static void main(String[] args) {
        String s = "hello java";

        DecoUtil1 decoUtil1 = new DecoUtil1();
        String deco = decoUtil1.deco(s);

        System.out.println("Before: " + s);
        System.out.println("After: " + deco);
    }
}
