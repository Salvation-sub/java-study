package static1;

public class DataCountMain2 {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Data2 data1 = new Data2("A", counter);
        System.out.println("A count = "  + counter.count);

        Data2 data2 = new Data2("B", counter);
        System.out.println("A count = "  + counter.count);
    }
}
