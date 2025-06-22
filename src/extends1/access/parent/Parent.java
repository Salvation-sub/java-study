package extends1.access.parent;

public class Parent {

    public int publicValue;
    protected int protectedValue;
    private int privateValue;
    int defaultValue;

    public void publicMethod() {
        System.out.println("Parent.publicMethod()");
    }

    protected void protectedMethod() {
        System.out.println("Parent.protectedMethod()");
    }

    void defaultMethod() {
        System.out.println("Parent.defaultMethod()");
    }

    private void privateMethod() {
        System.out.println("Parent.privateMethod()");
    }

    public void printParent(){
        System.out.println("===Parent 메서드 안 ===");
        System.out.println("publicValue = " + publicValue);
        System.out.println("protectedValue = " + protectedValue);
        System.out.println("privateValue = " + privateValue);
        System.out.println("defaultValue = " + defaultValue);

        // 부모 메서드 안에서 접근 가능
        defaultMethod();
        privateMethod();
    }
}
