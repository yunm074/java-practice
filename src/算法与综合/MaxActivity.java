package 算法与综合;
import java.io.*;
import java.util.*;
//贪心
public class MaxActivity {
    static class Act {
        int s, t;
        Act(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Act[] acts = new Act[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            acts[i] = new Act(s, t);
        }
        // 按结束时间升序排序（贪心策略）
        Arrays.sort(acts, Comparator.comparingInt(a -> a.t));

        int count = 0;
        int lastEnd = -1;
        for (Act a : acts) {
            if (a.s >= lastEnd) {
                count++;
                lastEnd = a.t;
            }
        }
        System.out.println(count);
    }
}

