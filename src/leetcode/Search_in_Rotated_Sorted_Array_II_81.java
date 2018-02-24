package leetcode;

/**
 * 功能描述:
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * <p>
 * Would this affect the run-time complexity? How and why?
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 2 4 5 6 7 0 1 2 2
 * <p>
 * Write a function to determine if a given target is in the array.
 * <p>
 * The array may contain duplicates.
 *
 * @Author chen.yiran
 * @Date 17/6/26.
 */
public class Search_in_Rotated_Sorted_Array_II_81 {

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        if (nums.length == 1 && nums[0] != target) return false;
        int pivot = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                pivot = i;
                break;
            }
        }

        int l = 0, r = pivot;
        while (target >= nums[l] && target <= nums[r] && l <= r) {
            if (nums[l] == target || nums[r] == target) return true;
            l++;
            r--;
        }
        if (l > r) return false;
        l = pivot + 1;
        r = nums.length - 1;
        while (target >= nums[l] && target <= nums[r] && l <= r) {
            if (nums[l] == target || nums[r] == target) return true;
            l++;
            r--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(new Search_in_Rotated_Sorted_Array_II_81().search(nums, 1));
    }

}
