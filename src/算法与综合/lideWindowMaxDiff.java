package 算法与综合;
import java.io.*;
import java.util.*;
//滑动窗口
public class lideWindowMaxDiff {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        // 遍历每个窗口起点
        for (int l = 0; l <= n - k; l++) {
            int max = a[l];
            int min = a[l];
            for (int i = l; i < l + k; i++) {
                if (a[i] > max) max = a[i];
                if (a[i] < min) min = a[i];
            }
            int diff = max - min;
            if (diff > ans) ans = diff;
        }
        System.out.println(ans);
    }
}
