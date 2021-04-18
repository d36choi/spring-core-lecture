package shop.core.singleton;

public class StatefulService {

    // state 가 있으면 안된다. 해당 필드를 주석처리하고
    private int price; // 상태 유지 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;
    // return price 하는 방식으로 해결하면 된다.
    }

    public int getPrice() {
        return price;
    }
}
