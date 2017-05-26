package leetcode;

/**
 * 功能描述:
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x.
 *
 * @Author chen.yiran
 * @Date 17/5/26.
 */
public class Sqrt_x__69 {

    public int mySqrt(int x) {
        if (x == 0) return 0;
        int i = 1;
        for (; i < 46340; i++) {
            if (i * i <= x && (i + 1) * (i + 1) > x) return i;
        }
        if (i == 46340) return i;
        return x;
    }

    public static void main(String[] args) {
        new Sqrt_x__69().mySqrt(2147395600);
        System.out.println(46340 * 46340);
        System.out.println(289398 * 289398);
    }
}
