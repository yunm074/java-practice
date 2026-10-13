package lian;
import java.util.Scanner;
public class sumtwo{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个整数");
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        int sum = a + b;
        System.out.println("两数之和为"+sum);
    }
}
