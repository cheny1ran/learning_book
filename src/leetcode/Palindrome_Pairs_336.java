package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述:
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * <p>
 * Example 1:
 * Given words = ["bat", "tab", "cat"]
 * Return [[0, 1], [1, 0]]
 * The palindromes are ["battab", "tabbat"]
 * Example 2:
 * Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 * Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 *
 * @Author chen.yiran
 * @Date 16/12/15.
 */
public class Palindrome_Pairs_336 {

    /**
     * if contains different characters certainly not palindrome.
     */

    public List<List<Integer>> palindromePairsTLS(String[] words) {
        List<List<Integer>> lists = new ArrayList<>();

        if(words.length>1) {
            for (int i = 0; i < words.length - 1; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (isPalindrome(words[i] + words[j])) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        lists.add(list);
                    }
                    if (isPalindrome(words[j] + words[i])) {
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        list.add(i);
                        lists.add(list);
                    }
                }
            }
        }
        return lists;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        if (words == null || words.length < 2) return ret;
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<words.length; i++) map.put(words[i], i);
        for (int i=0; i<words.length; i++) {
            for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()"
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(str2rvs));
                        list.add(i);
                        ret.add(list);
                    }
                }
                if (isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    // check "str.length() != 0" to avoid duplicates
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(str1rvs));
                        ret.add(list);
                    }
                }
            }
        }
        return ret;
    }

    public boolean isPalindrome(String str) {
        int x = 0, y = str.length() - 1;
        while (x < y) {
            if (str.charAt(x) != str.charAt(y)) {
                return false;
            }
            x++;
            y--;
        }
        return true;
    }

    /**
     *
     */
    public static void main(String[] args) {
        String[] words = {"bat", "tab", "cat"};
        new Palindrome_Pairs_336().palindromePairs(words);
    }


}
