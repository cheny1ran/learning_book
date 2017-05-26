package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 功能描述:
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: k = 3, n = 7
 * <p>
 * Output:
 * <p>
 * [[1,2,4]]
 * <p>
 * Example 2:
 * <p>
 * Input: k = 3, n = 9
 * <p>
 * Output:
 * <p>
 * [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @Author chen.yiran
 * @Date 17/5/25.
 */
public class Combination_Sum_III_216 {

    public List<List<Integer>> combinationSum3TLE(int k, int n) {
        int[] skip = new int[9];
        return func(k, n, skip);
    }

    Integer[] constant = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public List<List<Integer>> func(int k, int n, int[] skip) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k == 1) {
            if (n <= 9 && skip[n - 1] != 1) {
                List<Integer> aa = new ArrayList<>();
                aa.add(n);
                ans.add(aa);
            }
            return ans;
        }
        for (int i = 1; i < n && i <= 9; i++) {
            if (skip[i - 1] == 1) continue;
            skip[i - 1] = 1;
            List<List<Integer>> list = func(k - 1, n - i, skip);
            for (List<Integer> ll : list) {
                if (ll.size() != k - 1) continue;
                List<Integer> tem = new ArrayList<>();
                tem.add(i);
                tem.addAll(ll);
                ans.add(tem);
            }
            skip = new int[9];
        }

        Set<Set<Integer>> ss = new HashSet<>();
        List<List<Integer>> real = new ArrayList<>();
        for (List<Integer> ll : ans) {
            Set<Integer> set = new HashSet<>();
            for (Integer ii : ll) {
                set.add(constant[ii - 1]);
            }
            int size = ss.size();
            ss.add(set);
            if (set.size() == k && ss.size() > size) {
                real.add(ll);
            }
        }

        return real;
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        return backtrackint(k, n, 1);
    }

    public List<List<Integer>> backtrackint(int k, int n, int start) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k == 1) {
            if (n >= start && n <= 9) {
                List<Integer> aa = new ArrayList<>();
                aa.add(n);
                ans.add(aa);
            }
            return ans;
        }

        for (int i = start; i <= 9; i++) {
            List<List<Integer>> lists = backtrackint(k - 1, n - i, i + 1);
            for (List<Integer> list : lists) {
                if (list.size() == k - 1) {
                    list.add(i);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Combination_Sum_III_216().combinationSum3(3, 7);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
