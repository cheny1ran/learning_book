package leetcode;

/**
 * 功能描述:
 * Given an array of integers A and let n to be its length.
 * <p>
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
 * <p>
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * <p>
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * <p>
 * Note:
 * n is guaranteed to be less than 105.
 * <p>
 * Example:
 * <p>
 * A = [4, 3, 2, 6]
 * <p>
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * <p>
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 *
 * @Author chen.yiran
 * @Date 17/7/20.
 */
public class Rotate_Function_396 {
    public int maxRotateFunction(int[] A) {
        if (A.length <= 1) return 0;
        int sum = 0, cur = 0, mul = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            cur = i;
            for (int j = 0; j < A.length; j++) {
                sum += A[cur++] * (mul++);
                if (cur >= A.length) cur = 0;
            }
            max = Math.max(sum, max);
            sum = 0;
            mul = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {4, 3, 2, 6};
        System.out.println(new Rotate_Function_396().maxRotateFunction(A));
    }
}
