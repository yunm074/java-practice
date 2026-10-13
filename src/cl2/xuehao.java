package cl2;
import java.util.Scanner;

public class xuehao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入学号后5位：");
        int num = sc.nextInt();


        int w = num / 10000;
        int q = num / 1000 % 10;
        int b = num / 100 % 10;
        int s = num / 10 % 10;
        int g = num % 10;

        int sum = w + q + b + s + g;
        System.out.println("各位数字："+w+" "+q+" "+b+" "+s+" "+g);
        System.out.println("各位数字之和："+sum);
        sc.close();
    }
}

