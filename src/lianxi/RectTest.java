package lianxi;
import java.util.Scanner;
public class RectTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入长：");
        int length = sc.nextInt();
        System.out.print("输入宽：");
        int width = sc.nextInt();

        int area = length * width;
        int perimeter = 2*(length + width);

        System.out.println("矩形面积："+area);
        System.out.println("矩形周长："+perimeter);
        sc.close();
    }
}
