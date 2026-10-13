package lianxi;
import java.util.Scanner;
public class Rectangle {
    double length;

    public double getArea(){
        return length * length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangle rect = new Rectangle();
        rect.length = sc.nextDouble();
        System.out.println(rect.getArea());
        sc.close();
    }
}

