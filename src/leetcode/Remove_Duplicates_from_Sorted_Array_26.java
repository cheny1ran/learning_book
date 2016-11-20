package leetcode;

/**
 * 功能描述:
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p/>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p/>
 * For example,
 * Given input array nums = [1,1,2],
 * <p/>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 *
 * @Author ewnit
 * @Date 16/11/20.
 */
public class Remove_Duplicates_from_Sorted_Array_26 {

    /**
     * no new space;
     * int p=0,cur=0;
     * <p/>
     * for p->nums.length:
     * while nums[p]==nums[p-1]: p++;
     * if(p!=0) nums[cur]=nums[p-1]
     * cur++;
     * p++;
     * <p/>
     * <p/>
     * only numbers
     * so when != ++;
     * not only numbers
     */
    public int removeDuplicates(int[] nums) {
        int p = 1, ans = 1;
        for (; p < nums.length; p++) {
            if (nums[p] > nums[p - 1]){
                nums[ans++]=nums[p];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        System.out.println(new Remove_Duplicates_from_Sorted_Array_26().removeDuplicates(nums));
    }
}
