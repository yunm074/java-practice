package lianxi;
public class Phone {

    private String brand;
    private double price;
    private String color;
    public Phone(){}
    public Phone(String brand, double price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public static void main(String[] args) {

        Phone p = new Phone("华为",3999,"黑色");
        System.out.println("品牌："+p.getBrand()+"，价格："+p.getPrice()+"，颜色："+p.getColor());
    }
}
