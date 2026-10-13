package lianxi;
public class Circle {
    private double radius;
    final double pi = 3.14;
    public double getArea(){
        return pi * radius * radius;
    }

    public void setRadius(double r){
        if(r >= 0){
            radius = r;
        }else{
            System.out.println("半径不能为负数");
        }
    }
    public static void main(String[] args) {
        Circle c = new Circle();
        c.setRadius(5);
        System.out.println(c.getArea());
    }
}
