package leetcode;

/**
 * 功能描述:
 * Related to question Excel Sheet Column Title
 * <p>
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 *
 * @Author chen.yiran
 * @Date 17/9/21.
 */
public class Excel_Sheet_Column_Number_171 {

    public int titleToNumber(String s) {
        if (s.length() == 0) return 0;
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int bei = 1;
            for (int j = 0; j < s.length() - i - 1; j++) {
                bei *= 26;
            }
            ans += (ch - 'A' + 1) * bei;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Excel_Sheet_Column_Number_171().titleToNumber("AA"));
    }

}
