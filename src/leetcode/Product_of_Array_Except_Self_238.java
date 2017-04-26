package leetcode;

/**
 * 功能描述:
 * Given an array of n integers where n > 1, nums,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Solve it without division and in O(n).
 * <p>
 * For example, given [1,2,3,4], return [24,12,8,6].
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity?
 * (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 * @Author chen.yiran
 * @Date 17/4/10.
 */
public class Product_of_Array_Except_Self_238 {


    /**
     * Thank @lycjava3 for this smart solution. To understand it easily, let me explain it with an example.

     Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5. The product is left*right. We can get lefts and rights:

     Numbers:     2    3    4     5
     Lefts:            2  2*3 2*3*4
     Rights:  3*4*5  4*5    5
     Let’s fill the empty with 1:

     Numbers:     2    3    4     5
     Lefts:       1    2  2*3 2*3*4
     Rights:  3*4*5  4*5    5     1
     We can calculate lefts and rights in 2 loops. The time complexity is O(n).

     We store lefts in result array. If we allocate a new array for rights. The space complexity is O(n). To make it O(1), we just need to store it in a variable which is right in @lycjava3’s code.
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ans = new Product_of_Array_Except_Self_238().productExceptSelf(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

}
