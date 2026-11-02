package 算法与综合;
import java.io.*;
import java.util.*;
//差分
public class DiffZero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n + 2]; // 下标1~n
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        long sumPos = 0;
        int pre = 0;
        for (int i = 1; i <= n; i++) {
            int d = a[i] - pre;
            if (d > 0) sumPos += d;
            pre = a[i];
        }
        // d[n+1] = 0 - a[n]，这里不需要额外处理，公式只统计前面正差分和
        System.out.println(sumPos);
    }
}
