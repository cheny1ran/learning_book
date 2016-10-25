package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cyan <chenyr626@gmail.com> on 2016/10/24.
 * function:
 */
public class Evaluate_Division_399 {

    Set set = new HashSet();

    public double dfs(String[][] equations, double[] values, String[] query, int[] visited) {
        boolean flag=false;
        double v = 1;
        if(!set.contains(query[0])||!set.contains(query[1])){
            return -1;
        }
        if (query[0].equals(query[1])) {
            return 1;
        }
        for (int i = 0; i < equations.length; i++) {
            if (visited[i] == 1) continue;
            String a[] = equations[i];
            if (a[0].equals(query[0]) && a[1].equals(query[1])) {
                v *= values[i];
                return v;
            } else if (a[0].equals(query[1]) && a[1].equals(query[0])) {
                v /= values[i];
                return v;
            } else if (a[0].equals(query[0])) {
                flag=true;
                visited[i] = 1;
                String[] newQuery = {a[1], query[1]};
                v *= values[i];
                v = v * dfs(equations, values, newQuery, visited);
            } else if (a[1].equals(query[0])) {
                flag=true;
                visited[i] = 1;
                String[] newQuery = {a[0], query[1]};
                v /= values[i];
                v = v * dfs(equations, values, newQuery, visited);
            }
        }
        if(!flag)
            return -1;
        else return v;
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        for (int i = 0; i < equations.length; i++) {
            String[] a = equations[i];
            set.add(a[0]);
            set.add(a[1]);
        }

        int[] visited = new int[values.length];
        double[] ans = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = dfs(equations, values, queries[i], visited);
            System.out.println(ans[i]);
        }
        return ans;
    }

    public static void main(String[] args) {

        String[][] eq={{"a","b"},{"b","c"}};
        double[] vs={2.0,3.0};
        String[][] qs = {{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
//        String[][] eq={{"a","e"},{"b","e"}};
//        double[] vs={4.0,3.0};
//        String[][] qs = {{"a", "b"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        new Evaluate_Division_399().calcEquation(eq, vs, qs);
    }


}
