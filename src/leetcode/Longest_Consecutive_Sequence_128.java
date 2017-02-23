package leetcode;

import java.util.Arrays;

/**
 * 功能描述:
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * <p>
 * Your algorithm should run in O(n) complexity.
 *
 * @Author chen.yiran
 * @Date 17/2/17.
 */
public class Longest_Consecutive_Sequence_128 {

    //use linkedlist to sort
    //create a struct, the number have a attr of the length of the longest consecutive elements sequence.
    //but it need to update all the values after the insert node and not in O(n)


    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int curMax = 1;
        if (nums.length == 1) return 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == 1) curMax++;
            else if (nums[i + 1] != nums[i]) curMax = 1;
            max = Math.max(curMax, max);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] nums = {100, 4, 200, 1, 3, 2};
//        int[] nums = {};
        int[] nums = {1, 2, 0, 1};
        System.out.println(new Longest_Consecutive_Sequence_128().longestConsecutive(nums));
    }

}
