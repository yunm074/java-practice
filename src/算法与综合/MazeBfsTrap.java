package 算法与综合;
import java.io.*;
import java.util.*;

public class MazeBfsTrap {
    static class Node {
        int x, y, time;
        Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.time = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        // 上下左右
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] vis = new boolean[N][N];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        vis[0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int t = cur.time;

            // 到达右下角终点
            if (x == N - 1 && y == N - 1) {
                System.out.println(t);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (vis[nx][ny]) continue;
                if (map[nx][ny] == '1') continue; // 墙壁

                vis[nx][ny] = true;
                int add = 1;
                if (map[nx][ny] == '#') {
                    add += K;
                }
                q.add(new Node(nx, ny, t + add));
            }
        }
        // 走不通
        System.out.println(-1);
    }
}
