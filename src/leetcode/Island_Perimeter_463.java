package leetcode;

import java.util.LinkedList;

/**
 * 功能描述:
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * <p/>
 * Example:
 * <p/>
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p/>
 * Answer: 16
 *
 * @Author ewnit
 * @Date 16/11/28.
 */
public class Island_Perimeter_463 {
    /**
     * exactly one island with no lake make this question simple
     * <p/>
     * bfs with count border is not 1
     * <p/>
     * if(1){
     * judge( up down left right ==1? +1:0)
     * push 1;
     * }
     */
    class N {
        int x, y;

        N(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int islandPerimeter(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int[][] walk = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int ans = 0;
        LinkedList<N> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    N n = new N(i, j);
                    q.push(n);
                    while (!q.isEmpty()) {
                        N tem = q.poll();
                        int x = tem.x;
                        int y = tem.y;
                        if (visited[x][y] == 0) {
                            visited[x][y] = 1;
                            for (int ii = 0; ii < walk.length; ii++) {
                                int xx = x + walk[ii][0];
                                int yy = y + walk[ii][1];
                                if (xx >= 0 && xx < grid.length && yy >= 0 && yy < grid[0].length) {
                                    if (grid[xx][yy] == 1) {
                                        N nn = new N(xx, yy);
                                        q.push(nn);
                                    } else ans++;
                                } else ans++;

                            }
                        }
                    }
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(new Island_Perimeter_463().islandPerimeter(grid));
    }
}
