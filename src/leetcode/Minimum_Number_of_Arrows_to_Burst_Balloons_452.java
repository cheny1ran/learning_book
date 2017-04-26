package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 功能描述:
 * <p>
 * There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.
 * <p>
 * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.
 * <p>
 * Example:
 * <p>
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
 *
 * @Author chen.yiran
 * @Date 17/4/26.
 */
public class Minimum_Number_of_Arrows_to_Burst_Balloons_452 {


    /**
     * mark all the scope on the x-axis
     * find the common part
     * save the min part of each scope
     *
     * use list<list> lists to store
     * for data in input:
     *      for list in lists:
     *          min=list[0],max=list[1]
     *          if min<data[0]<max:
     *              min=data[0]
     *          if min<data[1]<max:
     *              max=data[1]
     *          if data[1]<min || data[0]>max:
     *              continue;
     *          flag=true;
     *      if flag:
     *          add scope to lists
     */

    public int findMinArrowShots(int[][] points) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            boolean flag = false;
            int[] data = points[i];
            for (List<Integer> list : lists) {
                int min = list.get(0);
                int max = list.get(1);
                if (data[0] >= min && data[0] <= max && data[1] >= min && data[1] <= max) {
                    flag = true;
                    break;
                } else if (data[0] >= min && data[0] <= max) {
                    flag = true;
                    list.set(1, data[1]);
                    break;
                } else if (data[1] >= min && data[1] <= max) {
                    flag = true;
                    list.set(0, data[0]);
                    break;
                } else if (data[1] > max && data[0] < min) {
                    list.set(0, data[0]);
                    list.set(1, data[1]);
                    flag = true;
                    break;
                } else continue;
            }
            if (!flag) {
                List<Integer> li = new ArrayList<>();
                li.add(points[i][0]);
                li.add(points[i][1]);
                lists.add(li);
            }
        }
        return lists.size();
    }

    public int findMinArrowShots1(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                else return a[0] - b[0];
            }
        });

        int minArrows = 1;
        int arrowLimit = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] baloon = points[i];
            if (baloon[0] <= arrowLimit) {
                arrowLimit = Math.min(arrowLimit, baloon[1]);
            } else {
                minArrows++;
                arrowLimit = baloon[1];
            }
        }
        return minArrows;
    }

    public static void main(String[] args) {
//        int[][] points={{10,16},{2,8},{1,6},{7,12}};
//        int[][] points = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] points = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        // 3,9  {3,9}
        // 7,9  {7,12}
        // 7,8  {3,8}
        // 7,8  {6,8}
        // 7,8/9,10  {9,10}
        // 7,8/9,10  {2,9}
        // 7,8/9,10  {0,9}
        // 7,8/9,10  {3,9}
        // 7,8/9,10/0,6 {0,6}
        // 7,8/9,10/0,6 {2,8}
        System.out.println(new Minimum_Number_of_Arrows_to_Burst_Balloons_452().findMinArrowShots(points));
    }



}
