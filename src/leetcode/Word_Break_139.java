package leetcode;

import java.util.List;

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

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode node = buildTrie(wordDict);


    }

    private TrieNode buildTrie(List<String> wordDict) {
        TrieNode root = new TrieNode();
        TrieNode cur = root;
        for (String str : wordDict) {
            for (char ch : str.toCharArray()) {
                TrieNode node = cur.nodes[ch - 'a'];
                if (node == null) {
                    node = new TrieNode();
                    cur = node;
                }
            }
            cur.word = str;
        }
        return root;
    }

}
