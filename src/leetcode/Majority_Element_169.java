package leetcode;

import java.util.Arrays;

/**
 * 功能描述:
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p/>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * @Author ewnit
 * @Date 16/12/2.
 */
public class Majority_Element_169 {
    public int majorityElement(int[] nums) {
        int count=1;
        Arrays.sort(nums);
        int ans = nums[0];
        if(nums.length>1) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i]!=nums[i-1]){
                    count=1;
                    continue;
                }else count++;
                if (count > nums.length / 2) {
                    ans=nums[i];
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,3};
        System.out.println(new Majority_Element_169().majorityElement(nums));
    }
}
