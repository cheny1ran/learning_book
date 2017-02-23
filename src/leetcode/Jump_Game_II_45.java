package leetcode;

/**
 * 功能描述:
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * For example:
 * Given array A = [2,3,1,1,4]
 * <p>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * <p>
 * Note:
 * You can assume that you can always reach the last index.
 *
 * @Author chen.yiran
 * @Date 17/2/14.
 */
public class Jump_Game_II_45 {
    // dp from the end
    // scan from the end(end=nums.length-1)
    // if reach end step+1
    // 2,3,1,1,4
    // dp[4]=1,dp[3]=1,dp[2] = dp[2+1(nums[2])]+1

    //TLE in last case
    public int jumpDP(int[] nums) {
        if (nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= nums.length - 1) dp[i] = 1;
            else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = i + 1; j <= i + nums[i]; j++)
                    dp[i] = Math.min(dp[i], dp[j] == 0 ? Integer.MAX_VALUE : dp[j] + 1);
                if (dp[i] == Integer.MAX_VALUE) dp[i] = 0;
            }
        }
        return dp[0];
    }

    /**
     * I try to change this problem to a BFS problem, where nodes in level i are all the nodes that can be reached in i-1th jump.
     * for example. 2 3 1 1 4 , is
     * 2||
     * 3 1||
     * 1 4 ||
     * <p>
     * clearly, the minimum jump of 4 is 2 since 4 is in level 3.
     */
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int level = 0, currentMax = 0, i = 0, nextMax = 0;
        while (currentMax - i + 1 > 0) {        //nodes count of current level>0
            level++;
            for (; i <= currentMax; i++) {    //traverse current level , and update the max reach of next level
                nextMax = Math.max(nextMax, nums[i] + i);
                if (nextMax >= nums.length - 1)
                    return level;   // if last element is in level+1,  then the min jump=level
            }
            currentMax = nextMax;
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
//        int[] nums = {2,1};
        System.out.println(new Jump_Game_II_45().jump(nums));
    }

}
