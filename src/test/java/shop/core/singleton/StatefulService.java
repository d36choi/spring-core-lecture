package shop.core.singleton;

public class StatefulService {

    // state �� ������ �ȵȴ�. �ش� �ʵ带 �ּ�ó���ϰ�
    private int price; // ���� ���� �ʵ�

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;
    // return price �ϴ� ������� �ذ��ϸ� �ȴ�.
    }

    public int getPrice() {
        return price;
    }
}
