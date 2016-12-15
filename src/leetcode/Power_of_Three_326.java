package leetcode;

/**
 * 功能描述:
 * Given an integer, write a function to determine if it is a power of three.
 * <p>
 * Follow up:
 * Could you do it without using any loop / recursion?
 *
 * @Author chen.yiran
 * @Date 16/12/15.
 */
public class Power_of_Three_326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 3 || n == 1) return true;
        if (n % 3 != 0) return false;
        else return isPowerOfThree(n / 3);
    }

    public boolean isPowerOfThreeWithoutLoop(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return (n > 0 && 1162261467 % n == 0);
    }

}
