package leetcode;

/**
 * 功能描述:
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p/>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p/>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 *
 * @Author ewnit
 * @Date 16/11/20.
 */
public class Remove_Duplicates_from_Sorted_Array_II_80 {

    /**
     * add a new variable to count
     */
    public int removeDuplicates(int[] nums) {

        int p = 1, ans = 1, count = 0;
        for (; p < nums.length; p++) {
            if (nums[p] > nums[p - 1]) {
                if (count > 0) {
                    count = 0;
                    nums[ans++] = nums[p - 1];
                }
                nums[ans++] = nums[p];
            } else count++;
        }
        if (count > 0) {
            if (ans > nums.length) {
                nums[nums.length - 1] = nums[nums.length - 2];
            }else{
                nums[ans] = nums[ans - 1];
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1,1,1,3,3,3,3};
        System.out.println(new Remove_Duplicates_from_Sorted_Array_II_80().removeDuplicates(nums));
    }


}
