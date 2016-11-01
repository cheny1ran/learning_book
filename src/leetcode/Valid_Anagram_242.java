package leetcode;

/**
 * 功能描述:
 * <p/>
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p/>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * <p/>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p/>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * 1.必须全部包涵
 * 2.顺序无关
 *
 *
 * @Author ewnit
 * @Date 16/11/1.
 */
public class Valid_Anagram_242 {

    public boolean isAnagram(String s, String t) {
        //和顺序无关,只和个数有关
        int[] a = new int[26];
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for (int i = 0; i < s.length(); i++) a[chars[i] - 'a']++;
        for (int i = 0; i < t.length(); i++) a[chart[i] - 'a']--;
        for (int i : a) if (i != 0) return false;
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Valid_Anagram_242().isAnagram("anagram", "agra"));
    }


}
