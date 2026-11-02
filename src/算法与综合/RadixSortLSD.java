package 算法与综合;
import java.util.Scanner;

public class RadixSortLSD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int max = getMax(arr);
        // exp：1 个位，10十位，100百位...
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }

        // 输出
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(arr[i]);
        }
    }

    static int getMax(int[] a) {
        int m = a[0];
        for (int val : a) {
            if (val > m) m = val;
        }
        return m;
    }

    // 对当前exp这一位做稳定计数排序
    static void countSort(int[] a, int n, int exp) {
        int[] output = new int[n];
        int[] cnt = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (a[i] / exp) % 10;
            cnt[digit]++;
        }
        // 前缀和，稳定排序关键
        for (int i = 1; i < 10; i++) {
            cnt[i] += cnt[i - 1];
        }
        // 逆序放，保证稳定
        for (int i = n - 1; i >= 0; i--) {
            int digit = (a[i] / exp) % 10;
            output[cnt[digit] - 1] = a[i];
            cnt[digit]--;
        }
        // 复制回原数组
        System.arraycopy(output, 0, a, 0, n);
    }
}
