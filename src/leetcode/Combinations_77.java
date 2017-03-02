package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述:
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @Author chen.yiran
 * @Date 17/3/2.
 */
public class Combinations_77 {

    public List<List<Integer>> combine(int n, int k) {
        int[] visited = new int[n];
        return ffuc(n, visited, k);
    }

    public List<List<Integer>> ffuc(int n, int[] visited, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                if (visited[i - 1] == 1) continue;
                List<Integer> ll = new ArrayList<>();
                ll.add(i);
                lists.add(ll);
            }
            return lists;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i - 1] == 1) continue;
            visited[i - 1] = 1;
            List<List<Integer>> lll = ffuc(n, Arrays.copyOfRange(visited, 0, n), k - 1);
            for (List<Integer> tt : lll) {
                tt.add(i);
                lists.add(tt);
            }
        }
        return lists;
    }

    //tle
    public List<List<Integer>> func(List<Integer> arr, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        if (k == 1) {
            for (Integer i : arr) {
                List<Integer> ll = new ArrayList<>();
                ll.add(i);
                lists.add(ll);
            }
            return lists;
        }
        Integer[] ll = new Integer[arr.size()];
        arr.toArray(ll);
        for (int i = 0; i < ll.length; i++) {
            // deep copy
            List<Integer> using = new ArrayList<>();
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(j).equals(ll[i])) continue;
                using.add(arr.get(j));
            }
            // recursive
            List<List<Integer>> tem = func(using, k - 1);
            for (List<Integer> tt : tem) {
                tt.add(ll[i]);
                lists.add(tt);
            }
        }
        return lists;
    }



    public static void main(String[] args) {
        for (List<Integer> list : new Combinations_77().combine(4, 3)) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

}
