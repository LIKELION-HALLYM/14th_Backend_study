package week1Pc.book;

public class Book {

    String title;
     String author;
    private int price;

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    int getPrice() {
        return price;
    }
    void setPrice(int price) {

        if(price < 0) {
            System.out.println("올바르지 않은 가격입니다.");
        }
        this.price = price;
    }


            void printInfo() {
                System.out.println("제목: "+ title + "| 저자: " + author +
                        "| 가격: " + price);
            }
}
