package leetcode;

/**
 * 功能描述:
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 *
 * @Author chen.yiran
 * @Date 16/12/16.
 */
public class Median_of_Two_Sorted_Arrays_4 {
    /**
     * 两个数列的共同中位数
     * 不用 Arrays.sort
     * <p>
     * 插入排序
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] total = new int[nums1.length + nums2.length];
        int tp = 0, p1 = 0, p2 = 0;
        while (p1 < nums1.length || p2 < nums2.length) {
            if (p1 >= nums1.length) total[tp++] = nums2[p2++];
            else if (p2 >= nums2.length) total[tp++] = nums1[p1++];
            else {
                total[tp++] = nums1[p1] < nums2[p2] ? nums1[p1] : nums2[p2];
                if (nums1[p1] < nums2[p2]) p1++;
                else p2++;
            }
        }
        if (total.length % 2 == 0) {
            p1 = total.length / 2 - 1;
            p2 = total.length / 2;
            double d1, d2;
            d1 = total[p1];
            d2 = total[p2];
            return (d1 + d2) / 2;
        }else{
            return total[total.length / 2];
        }
    }
}
