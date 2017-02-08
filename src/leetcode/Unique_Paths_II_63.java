package leetcode;

/**
 * 功能描述:
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * <p>
 * Note: m and n will be at most 100.
 *
 * @Author chen.yiran
 * @Date 17/2/6.
 */
public class Unique_Paths_II_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int xlen = obstacleGrid.length;
        int ylen = obstacleGrid[0].length;
        if (xlen == 1 || ylen == 1) {
            for (int i = 0; i < xlen; i++) {
                for (int j = 0; j < ylen; j++) {
                    if (obstacleGrid[i][j] == 1) return 0;
                }
            }
            return 1;
        }

        int[][] ans = new int[xlen][ylen];
        ans[0][0] = 0;
        if (obstacleGrid[0][1] == 0) ans[0][1] = 1;
        if (obstacleGrid[1][0] == 0) ans[1][0] = 1;
        for (int i = 0; i < xlen; i++) {
            for (int j = 0; j < ylen; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                if (i - 1 >= 0) {
                    ans[i][j] += ans[i - 1][j];
                }
                if (j - 1 >= 0) {
                    ans[i][j] += ans[i][j - 1];
                }
            }
        }
        return ans[xlen - 1][ylen - 1];
    }

}
