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
 * @Author ewnit
 * @Date 16/10/22.
 */
public class First_Missing_Positive_41 {

    /**
     * siyang3 's good work
     * The key here is to use swapping to keep constant space and also make use of the length of the array,
     * which means there can be at most n positive integers. So each time we encounter an valid integer,
     * find its correct position and swap. Otherwise we continue.
     */
    public int firstMissingPositive1(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    /**
     * my quick_sort solution
     */
    void quick_sort(int s[], int l, int r) {
        if (l < r) {
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x)
                    j--;
                if (i < j)
                    s[i++] = s[j];

                while (i < j && s[i] < x)
                    i++;
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1);
            quick_sort(s, i + 1, r);
        }
    }


    public int firstMissingPositive(int[] nums) {
        //快排
        if(nums.length==0) return 1;
        quick_sort(nums, 0, nums.length - 1);
        int prev = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==prev) {
                prev++;
            }else if(nums[i]<prev){
                continue;
            }else if(nums[i]>prev){
                break;
            }
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,4};
        System.out.println(new First_Missing_Positive_41().firstMissingPositive1(nums));

    }

}
