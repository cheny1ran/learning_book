package basic;

import java.util.Scanner;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/7/21.
 */
public class FordFulkerson {
    final static int MAXN = 300;
    final static int INF = 19930317;

    static int[][] c = new int[MAXN][MAXN];
    static int s = 0, t = 0, i = 0, k = 0, u = 0, v = 0, w = 0, n = 0, m = 0;
    static int flow, maxflow;
    static int[] vis = new int[MAXN];

    static int dfs(int u, int low) {
        int i, flow;
        if (u == t)
            return low;
        if (vis[u] == 1)
            return 0;
        vis[u] = 1;
        for (i = 1; i <= n; i++)
            if (c[u][i] > 0 && (flow = dfs(i, low < c[u][i] ? low : c[u][i])) > 0) {
                c[u][i] -= flow;
                c[i][u] += flow;
                return flow;
            }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            m = sc.nextInt();
            n = sc.nextInt();
            for (i = 1; i <= m; i++) {
                u = sc.nextInt();
                v = sc.nextInt();
                w = sc.nextInt();
                c[u][v] += w;
            }
            s = 1;
            t = n;
            while ((flow = dfs(s, INF)) > 0) {
                maxflow += flow;
                vis = new int[MAXN];
            }
            System.out.println(maxflow);
        }

    }

}
