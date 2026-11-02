package 算法与综合;
import java.util.*;

public class CupPourBFS {
    static class State {
        int a, b, step;
        State(int a, int b, int s) {
            this.a = a;
            this.b = b;
            this.step = s;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.close();

        if (S % 2 != 0) {
            System.out.println("NO");
            return;
        }
        int target = S / 2;
        boolean[][] vis = new boolean[N + 1][M + 1];
        Queue<State> q = new LinkedList<>();
        q.add(new State(0, 0, 0));
        vis[0][0] = true;

        // 六种倒法
        while (!q.isEmpty()) {
            State cur = q.poll();
            int a = cur.a;
            int b = cur.b;
            int rest = S - a - b;

            if (a == target || b == target || rest == target) {
                System.out.println("YES " + cur.step);
                return;
            }

            // 原瓶 -> N杯
            int pour = Math.min(rest, N - a);
            int na = a + pour;
            int nb = b;
            if (!vis[na][nb]) {
                vis[na][nb] = true;
                q.add(new State(na, nb, cur.step + 1));
            }
            // 原瓶 -> M杯
            pour = Math.min(rest, M - b);
            na = a;
            nb = b + pour;
            if (!vis[na][nb]) {
                vis[na][nb] = true;
                q.add(new State(na, nb, cur.step + 1));
            }
            // N杯 -> 原瓶
            pour = a;
            na = 0;
            nb = b;
            if (!vis[na][nb]) {
                vis[na][nb] = true;
                q.add(new State(na, nb, cur.step + 1));
            }
            // M杯 -> 原瓶
            pour = b;
            na = a;
            nb = 0;
            if (!vis[na][nb]) {
                vis[na][nb] = true;
                q.add(new State(na, nb, cur.step + 1));
            }
            // N杯 -> M杯
            pour = Math.min(a, M - b);
            na = a - pour;
            nb = b + pour;
            if (!vis[na][nb]) {
                vis[na][nb] = true;
                q.add(new State(na, nb, cur.step + 1));
            }
            // M杯 -> N杯
            pour = Math.min(b, N - a);
            na = a + pour;
            nb = b - pour;
            if (!vis[na][nb]) {
                vis[na][nb] = true;
                q.add(new State(na, nb, cur.step + 1));
            }
        }
        System.out.println("NO");
    }
}
