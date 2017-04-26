package leetcode;

/**
 * 功能描述:
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 *
 * @Author chen.yiran
 * @Date 17/4/10.
 */
public class Search_in_Rotated_Sorted_Array_33 {

    /**
     * find the pivot O(n)
     * depart in two array
     * use binary search in each array
     */
    public int search(int[] nums, int target) {

        if (nums.length <= 1) {
            if (nums.length == 0 || nums[0] != target) return -1;
            return 0;
        }

        int pivot = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                pivot = i;
                break;
            }
        }

        int l, r;
        if (target >= nums[0] && target <= nums[pivot]) {
            l = 0;
            r = pivot;
        } else if (target >= nums[pivot + 1] && target <= nums[nums.length - 1]) {
            l = pivot + 1;
            r = nums.length - 1;
        } else return -1;

        if (target == nums[l]) return l;
        if (target == nums[r]) return r;

        while (l < r) {
            int mid = (l + r) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] < target) l = mid + 1;
        }
        if (l == r && nums[l] == target) return l;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {7, 8, 1, 2, 3, 4, 5, 6};
        System.out.println(new Search_in_Rotated_Sorted_Array_33().search(nums, 2));
    }
}
