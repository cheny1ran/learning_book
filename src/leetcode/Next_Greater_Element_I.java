package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 *
 * @Author chen.yiran
 * @Date 17/4/10.
 */
public class Next_Greater_Element_I {

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            map.put(nums[i], -1);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    map.put(nums[i], nums[j]);
                    break;
                }
            }
        }
        for (int i = 0; i < findNums.length; i++) {
            if (map.get(findNums[i]) != null) {
                findNums[i] = map.get(findNums[i]);
            } else {
                findNums[i] = -1;
            }
        }
        return findNums;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] ans = new Next_Greater_Element_I().nextGreaterElement(nums, nums2);
        for (int num : ans)
            System.out.print(num + " ");
    }

}
