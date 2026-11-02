package 算法与综合;
import java.util.Scanner;
//选择排序
public class SelectSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int end = n - 1; end > 0; end--) {
            int maxPos = 0;
            for (int i = 1; i <= end; i++) {
                if (a[i] > a[maxPos]) {
                    maxPos = i;
                }
            }
            int t = a[maxPos];
            a[maxPos] = a[end];
            a[end] = t;
        }

        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        sc.close();
    }
}
