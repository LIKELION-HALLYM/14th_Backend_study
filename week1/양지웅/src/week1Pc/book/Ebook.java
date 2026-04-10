package week1Pc.book;

public class Ebook extends Book {


    int fileSize;

    public Ebook(String title, String author,  int price,int fileSize ) {
        super(title, author,price);
        this.fileSize = fileSize;
    }
    @Override
    void printInfo() {
        System.out.println("[전자책] 제목: " + title + "| 저자: " + author +
                "| 용량 "+ fileSize+"MB");
    }
}
