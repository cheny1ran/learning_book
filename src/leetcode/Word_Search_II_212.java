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

    // 直接dfs不使用Trie的话会TLE
    // TrieNode structure and buildTrie src:
    // https://discuss.leetcode.com/topic/33246/java-15ms-easiest-solution-100-00/2
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if (words == null || words.length == 0 || board == null || board.length == 0) return ans;
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int[][] visited = new int[board.length][board[0].length];
                dfs(board, visited, i, j, root, ans);
            }
        }

        return ans;
    }

    int[][] walk = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void dfs(char[][] board, int[][] visited, int x, int y, TrieNode root, List<String> ans) {

        char c = board[x][y];
        if (visited[x][y] == 1 || root.next[c - 'a'] == null) return;
        root = root.next[c - 'a'];
        if (root.word != null) {
            ans.add(root.word);
            root.word = null;
        }
        visited[x][y] = 1;
        for (int i = 0; i < walk.length; i++) {
            int xx = x + walk[i][0];
            int yy = y + walk[i][1];
            if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length) {
                dfs(board, visited, xx, yy, root,ans);
            }
        }
        visited[x][y]=0;
    }

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};

//        char[][] board = {{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}};
//        String[] words = {"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"};

        List<String> list = new Word_Search_II_212().findWords(board, words);
        for (String s : list) {
            System.out.println(s);
        }
    }


}
