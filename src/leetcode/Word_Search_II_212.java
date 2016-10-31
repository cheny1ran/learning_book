package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p/>
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p/>
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 * <p/>
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * Return ["eat","oath"].
 *
 * @Author ewnit
 * @Date 16/10/31.
 */
public class Word_Search_II_212 {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if (words == null || words.length == 0 || board == null || board.length == 0) return ans;
        int[] valid = new int[words.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (int k = 0; k < words.length; k++) {
                    if (board[i][j] == words[k].charAt(0)) {
                        if (valid[k] == 0) {
                            int[][] visited = new int[board.length][board[0].length];
                            visited[i][j] = 1;
                            valid[k] = dfs(board, visited, i, j, words[k], 1);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < valid.length; i++) {
            if (valid[i] == 1 && !ans.contains(words[i])) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    int[][] walk = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int dfs(char[][] board, int[][] visited, int x, int y, String str, int index) {
        if (index >= str.length()) return 1;
        for (int i = 0; i < walk.length; i++) {
            int xx = x + walk[i][0];
            int yy = y + walk[i][1];
            if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length) {
                if (visited[xx][yy] == 1) continue;
                if (board[xx][yy] == str.charAt(index)) {
                    visited[xx][yy] = 1;
                    int valid = dfs(board, visited, xx, yy, str, index + 1);
                    visited[xx][yy] = 0;
                    if (valid == 1) return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
//        String[] words = {"oath", "pea", "eat", "rain"};

        char[][] board = {{'a', 'b','c'}, {'a', 'e','d'},{'a','f','g'}};
        String[] words = {"abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"};

        List<String> list = new Word_Search_II_212().findWords(board, words);
        for (String s : list) {
            System.out.println(s);
        }
    }


}
