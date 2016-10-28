package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 功能描述:
 *
 * @Author ewnit
 * @Date 16/10/26.
 */
public class Number_Of_Islands_200 {


    /**
     * bfs 效率低 12ms
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int ans = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<int[]> pos = new LinkedList<>();
        int[][] walk = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    int[] n = {i, j};
                    pos.add(n);
                    ans++;
                    visited[i][j] = 1;
                    while (!pos.isEmpty()) {
                        int[] pik = pos.poll();
                        int ii = pik[0];
                        int jj = pik[1];
                        for (int k = 0; k < walk.length; k++) {
                            int crti = ii + walk[k][0];
                            int crtj = jj + walk[k][1];
                            if (crti >= 0 && crti < grid.length && crtj >= 0 && crtj < grid[0].length) {
                                if (grid[crti][crtj] == '1' && visited[crti][crtj] == 0) {
                                    int[] m = {crti, crtj};
                                    pos.add(m);
                                    visited[crti][crtj] = 1;
                                }
                            }
                        }
                    }

                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] seq = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(new Number_Of_Islands_200().numIslands(seq));
    }
}
