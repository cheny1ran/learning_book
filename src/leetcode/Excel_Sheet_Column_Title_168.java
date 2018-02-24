package leetcode;

/**
 * 功能描述:
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * Credits:
 * Special thanks to @ifanchu for adding this problem and creating all test cases.
 *
 * @Author chen.yiran
 * @Date 17/9/21.
 */
public class Excel_Sheet_Column_Title_168 {
    /**
     * n1*26^x+...+n2*26^2+n3*26
     */
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char) ('A' + (n % 26));
    }

    public static void main(String[] args) {
        System.out.println(new Excel_Sheet_Column_Title_168().convertToTitle(29));

    }
}
