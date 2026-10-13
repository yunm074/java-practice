package cl6;
import java.util.Scanner;
public class lianxi2 {
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("负数没有阶乘");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        // 创建键盘输入对象
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个整数 n：");
        // 读取你输入的数字，赋值给 n
        int n = sc.nextInt();
        sc.close();

        // 调用方法并输出结果
        System.out.println(n + " 的阶乘 = " + factorial(n));
    }
}
