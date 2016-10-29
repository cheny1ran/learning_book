package leetcode;

/**
 * 功能描述:
 * Given an 2D board, count how many different battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
 * <p/>
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 *
 * @Author ewnit
 * @Date 16/10/29.
 */
public class Battleships_in_a_Board_419 {

    int ans = 0;
    int[][] visited;

    public int countBattleships(char[][] board) {
        //bfs one direction
        ans = 0;

        visited = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]=='X'&&visited[i][j]!=1) {
                    visited[i][j]=1;
                    int valid = dfs(board, 0, i, j);
                    if (valid == -1) return -1;
                    ans++;
                }
            }
        }
        return ans;
    }

    //0 is not sure, -1 is horizontal, 1 is vertical
    public int dfs(char[][] board, int direction, int x, int y) {
        int[][] walk = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int i = 0; i < walk.length; i++) {
                int xx = x + walk[i][0];
                int yy = y + walk[i][1];
                if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length) {
                    if (visited[xx][yy] == 1) continue;
                    if (board[xx][yy] == 'X') {
                        if (direction == -1 && i >= 2) return -1;
                        if (direction == 1 && i < 2) return -1;
                        if (direction == 0) {
                            if (i < 2) direction = -1;
                            else direction = 1;
                        }

                        visited[xx][yy] = 1;
                        int valid = dfs(board, direction, xx, yy);
                        if (valid == -1) return -1;
                    }
                }
            }
        return 1;
    }

    public static void main(String[] args) {
        char[][] board = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        System.out.println(new Battleships_in_a_Board_419().countBattleships(board));
    }
}
