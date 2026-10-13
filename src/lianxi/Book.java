package lianxi;
public class Book {
    int pageCount;

    public boolean isThin(){
        return pageCount < 100;
    }

    public static void main(String[] args) {
        Book b = new Book();
        b.pageCount = 80;
        System.out.println(b.isThin());
    }
}

