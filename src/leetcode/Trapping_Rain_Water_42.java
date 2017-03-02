package leetcode;


import java.util.Stack;

/**
 * 功能描述:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 * @Author chen.yiran
 * @Date 17/3/2.
 */
public class Trapping_Rain_Water_42 {

    /**
     * stack
     * 1 in (1)
     * 0 in (1,0)
     * 2 in 0,1 less than 2 sum+=max(0,1)=1
     * 1 in (2,1)
     * 0 in (2,1,0)
     * 1 in 0,1 less than 1 sum+=max(0,1)=2->(2,1)
     * 3 in 1,2 less than 3 sum+=max(1,2)=4->(3)
     * 2 in (3,2)
     * 1 in (3,2,1)
     * 2 in 1,2 less than 2 sum+=max(1,2)=6->(3,2)
     * 1 in
     */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() && height[i] == 0) continue;
            if (stack.isEmpty() || stack.peek() >= height[i]) {
                stack.push(height[i]);
                continue;
            }
            int pre = height[i];
            int k = 0;
            while (!stack.isEmpty() && stack.peek() <= height[i]) {
                if (pre < stack.peek()) sum += (stack.peek() - pre) * k;
                pre = stack.pop();
                k++;
            }
            stack.push(height[i]);
        }
        return sum;
    }

    public int trap1(int[] A) {
        if (A == null) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxWater = 0, maxBotWater = 0;
        while (i < A.length) {
            if (s.isEmpty() || A[i] <= A[s.peek()]) {
                s.push(i++);
            } else {
                int bot = s.pop();
                maxBotWater = s.isEmpty() ?
                        0 : (Math.min(A[s.peek()], A[i]) - A[bot]) * (i - s.peek() - 1);
                maxWater += maxBotWater;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
//        int[] he = {4,2,3};
//        int[] he = {2, 1, 0, 2};
        int[] he = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Trapping_Rain_Water_42().trap(he));
    }
}
