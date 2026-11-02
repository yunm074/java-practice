package 算法与综合;
import java.util.Scanner;
//冒泡排序
public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        //冒泡排序，带提前有序优化
        for (int end = n - 1; end > 0; end--) {
            boolean flag = false;
            for (int i = 0; i < end; i++) {
                if (a[i] > a[i + 1]) {
                    int t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                    flag = true;
                }
            }
            if (!flag) break;
        }

        //逗号分隔输出，末尾无逗号
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(",");
            System.out.print(a[i]);
        }
        sc.close();
    }
}
