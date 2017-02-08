package leetcode;

/**
 * 功能描述:
 * A magical string S consists of only '1' and '2' and obeys the following rules:
 * <p>
 * The string S is magical because concatenating the number of contiguous occurrences of characters '1' and '2' generates the string S itself.
 * <p>
 * The first few elements of string S is the following: S = "1221121221221121122……"
 * <p>
 * If we group the consecutive '1's and '2's in S, it will be:
 * <p>
 * 1 22 11 2 1 22 1 22 11 2 11 22 ......
 * <p>
 * and the occurrences of '1's or '2's in each group are:
 * <p>
 * 1 2	2 1 1 2 1 2 2 1 2 2 ......
 * <p>
 * You can see that the occurrence sequence above is the S itself.
 * <p>
 * Given an integer N as input, return the number of '1's in the first N number in the magical string S.
 * <p>
 * Note: N will not exceed 100,000.
 * <p>
 * Example 1:
 * Input: 6
 * Output: 3
 * Explanation: The first 6 elements of magical string S is "12211" and it contains three 1's, so return 3.
 *
 * @Author chen.yiran
 * @Date 17/1/12.
 */
public class Magical_String_481 {

    // point is to generate the string
    // use two pointer to generate
    public int magicalString(int n) {
        if (n == 0) return 0;
        StringBuilder s = new StringBuilder("122");
        int p1 = 2;
        int ans = 1;
        if (n > s.length()) {
            int cur = 1;
            while (s.length() < n) {
                for (int i = 0; i < s.charAt(p1) - 48; i++) {
                    s.append(cur);
                    if (cur == 1) ans++;
                }
                p1++;
                if (cur == 1) cur = 2;
                else cur = 1;
            }
        }
        if (s.length() > n && s.charAt(s.length() - 1) == '1') ans--;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Magical_String_481().magicalString(4));
    }


}
