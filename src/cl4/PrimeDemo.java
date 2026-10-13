package cl4;
import java.util.Scanner;

public class PrimeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入整数n：");
        int n = sc.nextInt();

        System.out.println("1到" + n + "之间的素数：");

        // 遍历1~n每一个数字
        for (int num = 2; num <= n; num++) {
            boolean primeFlag = true; // 标记是否为素数，默认true

            // 判断num是不是素数：从2循环到根号num
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    primeFlag = false; // 能整除，不是素数
                    break;
                }
            }

            if (primeFlag) {
                System.out.print(num + " ");
            }
        }
        sc.close();
    }
}
