package leetcode;

/**
 * 功能描述:
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 *
 * @Author chen.yiran
 * @Date 17/3/22.
 */
public class Sort_Colors_75 {

    public void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        int pos = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                nums[pos] = i;
                pos++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        new Sort_Colors_75().sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
