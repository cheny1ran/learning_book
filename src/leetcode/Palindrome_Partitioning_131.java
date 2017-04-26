package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * For example, given s = "aab",
 * Return
 * <p>
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 *
 * @Author ewnit
 * @Date 16/11/13.
 */
public class Palindrome_Partitioning_131 {

    /**
     * do it recursively
     */
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();

        if (s.length() == 1) {
            List<String> sub = new ArrayList<>();
            sub.add(s);
            lists.add(sub);
        } else {

            if (isPalindrome(s)) {
                List<String> sub = new ArrayList<>();
                sub.add(s);
                lists.add(sub);
            }

            int len = s.length();
            int mid = 1;
            while (mid < len) {
                String s1 = s.substring(0, mid);
                if (isPalindrome(s1)) {
                    String s2 = s.substring(mid);
                    List<List<String>> ll = partition(s2);
                    if (ll.isEmpty()) continue;
                    for (List<String> list : ll) {
                        List<String> sub = new ArrayList<>();
                        sub.add(s1);
                        sub.addAll(list);
                        lists.add(sub);
                    }
                }
                mid++;

            }
        }
        return lists;
    }


    public boolean isPalindrome(String s) {
        char[] chs = s.toCharArray();
        int i = 0, j = chs.length - 1;
        while (i < j) {
            if (chs[i] != chs[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Palindrome_Partitioning_131().partition("bba");
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
