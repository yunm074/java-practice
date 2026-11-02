package 算法与综合;
import java.util.Scanner;

public class FactSumRec {
    // 递归求阶乘
    public static long fact(int x) {
        if (x == 1) return 1;
        return x * fact(x - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += fact(i);
        }
        System.out.println(sum);
        sc.close();
    }
}
