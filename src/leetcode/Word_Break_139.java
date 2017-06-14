package leetcode;

import java.util.*;

/**
 * 功能描述:
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
 * <p>
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * <p>
 * Return true because "leetcode" can be segmented as "leet code".
 * <p>
 * UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 *
 * @Author chen.yiran
 * @Date 17/5/26.
 */
public class Word_Break_139 {

    // build trie and backtrack
    class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        String word;
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        TrieNode node = buildTrie(wordDict);

        return isWord(s, node);
    }

    // DFS TLE
    public boolean isWord(String s, TrieNode root) {
        if (s.length() == 0) return true;

        Stack<String> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            String curS = stack.pop();
            TrieNode cur = root;
            int i = 0;
            while (i < curS.length()) {
                if (cur.word != null) {
                    if (cur.word.equals(curS)) return true;
                    stack.push(curS.substring(i));
                }
                cur = cur.nodes[curS.charAt(i) - 'a'];
                if (cur == null) break;
                i++;
            }
            if (cur != null && cur.word != null && cur.word.equals(curS)) return true;
        }
        return false;
    }

    private TrieNode buildTrie(List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String str : wordDict) {
            TrieNode cur = root;
            for (char ch : str.toCharArray()) {
                if (cur.nodes[ch - 'a'] == null) {
                    cur.nodes[ch - 'a'] = new TrieNode();
                }
                cur = cur.nodes[ch - 'a'];
            }
            cur.word = str;
        }
        return root;
    }

    int[] used;

    public boolean wordBreak(String s, List<String> wordDict) {
        used = new int[wordDict.size()];
        return check(s, wordDict);
    }

    public boolean check(String s, List<String> wordDict) {
        if (s.length() == 0) return true;

        Collections.sort(wordDict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        for (int i = 0; i < wordDict.size(); i++) {
            if (used[i] == 1) continue;
            String word = wordDict.get(i);
            if (s.contains(word)) {
                used[i] = -1;
                String pre = s.substring(0, s.indexOf(word));
                String end = (s.indexOf(word) + word.length()) >= s.length() ? "" : s.substring(s.indexOf(word) + word.length());
                if (check(pre, wordDict) && check(end, wordDict)) {
                    return true;
                }
            }
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i] == -1) used[i] = 1;
        }
        return false;
    }





    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("cc");
//        dict.add("abc");
        dict.add("ac");
//        dict.add("cd");
//        dict.add("bbb");
//        dict.add("bbbb");
//        dict.add("code");
        System.out.println(new Word_Break_139().wordBreak("ccaccc", dict));
    }

}
