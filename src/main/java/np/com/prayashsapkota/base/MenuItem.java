package main.java.np.com.prayashsapkota.base;

public class MenuItem {
    private final String name;
    private final double price;
    private double quantity;


    public MenuItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return getQuantity() * getPrice();
    }

    public void seQuantity(int quantity) {
        this.quantity = quantity;
    }

}
