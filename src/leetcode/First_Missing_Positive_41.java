package leetcode;

/**
 * 功能描述:
 * Given an unsorted integer array, find the first missing positive integer.
 * <p/>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p/>
 * Your algorithm should run in O(n) time and uses constant space.
 *
 * @Author cyan
 * @Date 16/10/22.
 */
public class First_Missing_Positive_41 {

    public int[] quickSort(int[] nums, int h, int p) {
        if (p - h == 0) return nums;
        if (p - h == 1) {
            if (nums[p] < nums[h]) {
                int tem = nums[h];
                nums[h] = nums[p];
                nums[p] = tem;
            }
            return nums;
        }
        int m = (p - h + 1) / 2;
        int hh = h, pp = p;
        while (hh < pp) {
            while (hh < pp && nums[hh] < nums[m]) {
                hh++;
            }
            while (hh < pp && nums[pp] > nums[m]) {
                pp--;
            }
            int tem = nums[hh];
            nums[hh] = nums[pp];
            nums[pp] = tem;
        }
        int tem = nums[m];
        nums[m] = nums[pp];
        nums[pp] = tem;
        quickSort(nums, h, pp - 1);
        quickSort(nums, pp + 1, p);
        return nums;
    }


    public int firstMissingPositive(int[] nums) {
        //快排
        int[] ans = quickSort(nums, 0, nums.length - 1);
        int prev = nums[0];
        int aa = prev + 1;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] - prev > 1) {
                aa = prev + 1;
                break;
            }
            prev = ans[i];
        }

        return aa;
    }

    public static void main(String[] args) {
        int[] nums = {9, 4, 2, 6, 5, 7, 1, 3};
        new First_Missing_Positive_41().quickSort(nums, 0, nums.length - 1);
        System.out.println(nums);
    }

}
