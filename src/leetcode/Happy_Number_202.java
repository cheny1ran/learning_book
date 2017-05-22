package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 功能描述:
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example: 19 is a happy number
 * <p>
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * @Author chen.yiran
 * @Date 17/5/19.
 */
public class Happy_Number_202 {

    Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        set.add(n);
        String str = Integer.toString(n);
        int sum = 0;
        while (true) {
            for (int i = 0; i < str.length(); i++) {
                int num = str.charAt(i) - 48;
                sum += num * num;
            }
            if (sum == 1) return true;
            if (set.contains(sum)) return false;
            set.add(sum);
            str = Integer.toString(sum);
            sum = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Happy_Number_202().isHappy(19));
    }

}
