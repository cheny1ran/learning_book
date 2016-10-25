package leetcode;

/**
 * Created by ewnit <chenyr626@gmail.com> on 2016/10/25.
 * function:
 */
public class Game_Of_Life_289 {
    /**
     * 　other's good work
     * [2nd bit, 1st bit] = [next state, current state]
     * <p>
     * - 00  dead (next) <- dead (current)
     * - 01  dead (next) <- live (current)
     * - 10  live (next) <- dead (current)
     * - 11  live (next) <- live (current)
     */


    public void gameOfLife(int[][] board) {
        int[][] ans = new int[board.length][board[0].length];
        int[][] step = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live = 0;
                for (int[] stp : step) {
                    int crti = i + stp[0];
                    int crtj = j + stp[1];
                    if (crti >= 0 && crti < board.length && crtj >= 0 && crtj < board[0].length) {
                        if (board[crti][crtj] == 1) live++;
                    }
                }
                if (live == 3 || (live == 2 && board[i][j] == 1)) {
                    ans[i][j] = 1;
                } else {
                    ans[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ans[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {{1}};
        new Game_Of_Life_289().gameOfLife(board);
        for (int[] a : board) {
            for (int i = 0; i < a.length; i++)
                System.out.println(a[0]);
        }
    }
}
