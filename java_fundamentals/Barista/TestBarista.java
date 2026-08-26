package Barista;

public class TestBarista {
    public static void main(String[] args) {
        Order order1 = new Order();
        Item item1 = new Item("cup", 5);
        Item item2 = new Item("latte", 6.5);
        order1.addItem(item1);
        order1.addItem(item2);
        order1.display();
    }
}
