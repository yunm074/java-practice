package 算法与综合;
import java.util.Scanner;
//原地选择排序：每轮找最大值放到未排序末尾
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 原地选择排序：找最大，放到未排序区间末尾
        for (int end = n - 1; end > 0; end--) {
            int maxIdx = 0;
            for (int i = 1; i <= end; i++) {
                if (arr[i] > arr[maxIdx]) {
                    maxIdx = i;
                }
            }
            // 交换最大值和end位置
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[end];
            arr[end] = temp;
        }

        // 输出，末尾无空格
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(arr[i]);
        }
    }
}

