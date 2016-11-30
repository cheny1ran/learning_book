package leetcode;

/**
 * 功能描述:
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p/>
 * For example, given the following matrix:
 * <p/>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 *
 * @Author ewnit
 * @Date 16/11/29.
 */
public class Maximal_Square_221 {
    /**
     * feels like a dp problem
     * min(up above left) + (up&above&left==1?1:0)
     * store len check above and up--len left--len
     * <p/>
     * dont fit situations like
     * 0 0 1
     * 0 1 1
     * 1 1 1
     * <p/>
     * 状态 max matrix
     * 状态转移
     * 1 0 1 0 0    1 0 1 0 0
     * 1 0 1 1 1    1 0 1 1 1
     * 1 1 1 1 1    1 1 1 2 2
     * 1 0 0 1 0    1 0 0 1 0
     * <p/>
     * 1 0 1 0 0
     * 1 0 0 1 0
     * 1 1 0 0 2
     * 1 0 0 0 0
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxlen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') continue;
                int x = i - 1;
                int y = j - 1;
                if (x >= 0 && y >= 0) {
                    int len = dp[x][y];
                    int ll=1;
                    outer:
                    if (len > 0) {
                        for (int k = 1; k <= len; k++) {
                            if (matrix[i - k][j] == '0' || matrix[i][j - k] == '0')
                                break outer;
                            ll++;
                        }
                    }
                    dp[i][j] = ll;
                } else {
                    dp[i][j] = 1;
                }
                maxlen = Math.max(dp[i][j], maxlen);
            }
        }
        return maxlen * maxlen;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] mm = {
                "110".toCharArray(),
                "111".toCharArray(),
                "101".toCharArray()};
        System.out.println(new Maximal_Square_221().maximalSquare(mm));
    }
}
