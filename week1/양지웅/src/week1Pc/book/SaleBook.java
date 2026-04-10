package week1Pc.book;

import java.io.Serializable;

public class SaleBook extends Book implements Discountable{
    public SaleBook(String title, String author, int price) {
        super(title, author, price);
    }

    @Override
    public void discount(int percent) {
        int originalMoney = getPrice();
        int discountMoney = originalMoney - (originalMoney * percent /100);
        setPrice(discountMoney);

        System.out.println("할인 적용: " +originalMoney+"원 에서 "+percent+"% 할인된 가격은 " + discountMoney+"원");
    }
}
