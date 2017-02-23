package leetcode;

/**
 * 功能描述:
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 *
 * @Author chen.yiran
 * @Date 17/2/13.
 */
public class Jump_Game_55 {

    public boolean canJump(int[] nums) {
        int pos = 0;
        int step = nums[pos];
        int far = pos + step;
        // greedy get the most far pos
        if (far>= nums.length - 1) return true;

        for (int i = pos; i <= far; i++) {
            int posnow = i + nums[i];
            far = posnow > far ? posnow : far;
            if(far>=nums.length-1) return true;

        }
        return pos >= nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,0,0};
        System.out.println(new Jump_Game_55().canJump(nums));
    }
}
