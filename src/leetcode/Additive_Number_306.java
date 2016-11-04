package leetcode;

import java.math.BigInteger;

/**
 * 功能描述:
 * Additive number is a string whose digits can form additive sequence.
 * <p/>
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * <p/>
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * <p/>
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * <p/>
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * <p/>
 * Follow up:
 * How would you handle overflow for very large input integers?
 *
 * @Author ewnit
 * @Date 16/11/1.
 */
public class Additive_Number_306 {


    // Generate the first and second of the sequence, check if the rest of the string match the sum recursively.
    // i and j are length of the first and second number. i should in the range of [0, n/2].
    // The length of their sum should >= max(i,j)

    public boolean isAdditiveNumber(String num) {

        int len = num.length();

        for (int i = 1; i <= len / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) return false;
            BigInteger x = new BigInteger(num.substring(0, i));
            for (int j = 1; Math.max(i, j) <= len - i - j; j++) {
                if (num.charAt(i) == '0' && j > 1) break;
                BigInteger y = new BigInteger(num.substring(i, j + i));
                if (isValid(x, y, i + j, num)) return true;
            }
        }
        return false;
    }

    public boolean isValid(BigInteger x, BigInteger y, int begin, String num) {
        if (begin == num.length()) {
            return true;
        }
        x = x.add(y);
        String sum = x.toString();
        return num.startsWith(sum, begin) && isValid(y, x, begin + sum.length(), num);
    }

    public static void main(String[] args) {
        new Additive_Number_306().isAdditiveNumber("123");
    }

}
