package lianxi;
public class Cylinder {

    double radius;
    double height;
    double pi = 3.14;

    public double area(){
        return pi * radius * radius;
    }
    public double volumn(){
        return area() * height;
    }

    public static void main(String[] args) {
        Cylinder cy = new Cylinder();
        cy.radius = 4.2;
        cy.height = 5;
        System.out.println("底面积为"+cy.area());
        System.out.println("体积为"+cy.volumn());
    }
}
