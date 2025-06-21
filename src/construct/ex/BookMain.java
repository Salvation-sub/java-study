package construct.ex;

public class BookMain {
    public static void main(String[] args) {
        // 기본 생성자 사용
        Book book1 = new Book();
        book1.displayInfo();

        Book book2 = new Book("Hello" , "Seo" );
        book2.displayInfo();

        Book book3 = new Book("JPA 프로그래밍" , "kim" , 709);
        book3.displayInfo();
    }
}
