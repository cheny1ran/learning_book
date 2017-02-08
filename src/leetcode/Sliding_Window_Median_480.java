package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 功能描述:
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * <p>
 * Examples:
 * [2,3,4] , the median is 3
 * <p>
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.
 * <p>
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * <p>
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7       -1
 * 1  3 [-1  -3  5] 3  6  7       -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 * <p>
 * Note:
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 *
 * @Author chen.yiran
 * @Date 17/1/13.
 */
public class Sliding_Window_Median_480 {

    // will pass but very slow
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] list = new double[nums.length - k + 1];
        List<Integer> list1 = new ArrayList<>();

        for (int i = 0; i < nums.length - k + 1; i++) {
            if (i == 0) {
                int[] tem = Arrays.copyOfRange(nums, i, i + k);
                for(int j=0;j<tem.length;j++) {
                    list1.add(tem[j]);
                }
                Collections.sort(list1);
            }else{
                list1.remove(new Integer(nums[i - 1]));
                list1.add(nums[i + k - 1]);
                Collections.sort(list1);
            }
            if (k % 2 == 0) {
                list[i] = ((double) list1.get(k / 2) + (double) list1.get(k / 2 - 1)) / 2;
            } else {
                list[i] = (double) list1.get(k / 2);
            }
        }
        return list;
    }



    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        new Sliding_Window_Median_480().medianSlidingWindow(nums, 3);
    }

}
