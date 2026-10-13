package cl2;
import java.util.Scanner;

public class Rectange {
    public static void main(String[] args){
        int width,height;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入宽：");
        width = sc.nextInt();
        System.out.print("请输入高：");
        height = sc.nextInt();
        int area = width * height;
        System.out.println("长方形面积："+area);
        sc.close();
    }
}
