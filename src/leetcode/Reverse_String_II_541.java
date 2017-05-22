package leetcode;

/**
 * 功能描述:
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string.
 * If there are less than k characters left, reverse all of them.
 * If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 *
 * @Author chen.yiran
 * @Date 17/5/18.
 */
public class Reverse_String_II_541 {

    public String reverseStr(String s, int k) {
        String ans = "";
        for (int i = 0; i < s.length(); i += 2 * k) {
            int p = i + k - 1;
            String newStr = "";
            for (p = p >= s.length() ? s.length() - 1 : p; p >= i; p--) {
                newStr += s.charAt(p);
            }
            ans += newStr;
            if (i + k < s.length()) {
                ans += s.substring(i + k, (i + k + k) >= s.length() ? s.length() : (i + k + k));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Reverse_String_II_541().reverseStr("a", 2));
    }
}
