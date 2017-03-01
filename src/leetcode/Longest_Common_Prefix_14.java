package leetcode;

/**
 * 功能描述:
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * @Author chen.yiran
 * @Date 17/2/23.
 */
public class Longest_Common_Prefix_14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String common = strs[0];
        for (String b : strs) {
            for (int j = 0; j < common.length() && j < b.length(); j++) {
                if (b.charAt(j) != common.charAt(j)) {
                    common = common.substring(0, j);
                    if (j == 0) return "";
                    break;
                }
            }
            if(b.length()<common.length()) common = b;
        }
        return common;
    }

    public static void main(String[] args) {
        String[] strs = {"aa", "a"};
        new Longest_Common_Prefix_14().longestCommonPrefix(strs);
    }
}
