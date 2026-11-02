package 算法与综合;
import java.util.Scanner;

public class CountSortDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] cnt = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            cnt[x]++;
        }
        boolean first = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                if (!first) System.out.print(" ");
                first = false;
                System.out.print(i);
            }
        }
        sc.close();
    }
}
