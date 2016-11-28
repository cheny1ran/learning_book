package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 功能描述:
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p/>
 * Find all the elements that appear twice in this array.
 * <p/>
 * Could you do it without extra space and in O(n) runtime?
 * <p/>
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p/>
 * Output:
 * [2,3]
 *
 * @Author ewnit
 * @Date 16/11/26.
 */
public class Find_All_Duplicates_in_an_Array_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length>=2) {
            for (int i = 0, j = 1; j < nums.length; i++, j++) {
                if (nums[j] == nums[i]) list.add(nums[j]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int len=100;
        int[] nums = new int[len];
        Random random = new Random();
        for(int i=0;i<len;i++) {
            nums[i] = Math.abs(random.nextInt() % 100);
        }
        Arrays.sort(nums);
    }
}
