package week1Pc.book;

public class Homework2_MiniProject {
//    main에서 실행하기
//
//    Book 2개, EBook 1개, SaleBook 1개를 Book[] 배열에 담기
//for-each로 전체 목록 printInfo() 출력
//    SaleBook의 가격을 setPrice()로 변경 후 출력
//    잘못된 가격(-1)도 한 번 시도해보기
//    SaleBook에 20% 할인 적용해서 출력
    public static void main(String[] args) {
        Book[] book = new  Book[4];
        book[0] = new Book("책1", "길동",10000);
        book[1] = new Book("책2", "기영",20000);
        book[2] = new Ebook("자식책", "기철",30000, 60);
        book[3] = new SaleBook("할인책", "떙구", 50000);

        System.out.println("=== 전체 도서 목록 ===");

        for(Book books : book) {
            books.printInfo();
        }
        System.out.println();
        System.out.println("=== 가격 수정 ===");
        book[3].setPrice(9900);
        book[3].printInfo();
        book[3].setPrice(-1);

        System.out.println();
        System.out.println("=== 할인 적용 ===");
        SaleBook sale = new SaleBook("할인책1", "심슨", 10000);

        sale.discount(30);
    }
}
