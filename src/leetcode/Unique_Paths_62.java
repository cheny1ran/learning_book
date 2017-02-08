package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述:
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <p>
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 *
 * @Author chen.yiran
 * @Date 17/2/6.
 */
public class Unique_Paths_62 {
    //bfs TLE
    public int uniquePaths1(int m, int n) {
        if (m == 1 && n == 1) return 1;
        int ans = 0;
        int[][] step = {{1, 0}, {0, 1}};
        LinkedList<List<Integer>> queue = new LinkedList<List<Integer>>();
        List<Integer> s = new ArrayList<>();
        s.add(0);
        s.add(0);
        queue.add(s);
        while (!queue.isEmpty()) {
            List<Integer> now = queue.poll();
            int x = now.get(0);
            int y = now.get(1);
            for (int i = 0; i < step.length; i++) {
                int xx = x + step[i][0];
                int yy = y + step[i][1];
                if (xx == m - 1 && yy == n - 1) {
                    ans++;
                    continue;
                }
                if (xx < m && yy < n) {
                    List<Integer> list = new ArrayList<>();
                    list.add(xx);
                    list.add(yy);
                    queue.add(list);
                }
            }
        }
        return ans;

    }

    /**
     * This is a combinatorial problem and can be solved without DP. For mxn grid, robot has to move exactly m-1 steps down and n-1 steps right and these can be done in any order.
     * <p>
     * For the eg., given in question, 3x7 matrix, robot needs to take 2+6 = 8 steps with 2 down and 6 right in any order. That is nothing but a permutation problem. Denote down as 'D' and right as 'R', following is one of the path :-
     * <p>
     * D R R R D R R R
     * <p>
     * We have to tell the total number of permutations of the above given word. So, decrease both m & n by 1 and apply following formula:-
     * <p>
     * Total permutations = (m+n)! / (m! * n!)
     */

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        m--;
        n--;
        if (m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for (int i = m + 1; i <= m + n; i++, j++) {       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }

        return (int) res;
    }


}
