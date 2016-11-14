package leetcode;

import java.util.*;

/**
 * 功能描述:
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * <p/>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p/>
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * <p/>
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * <p/>
 * For example:
 * <p/>
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
 * <p/>
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * <p/>
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 *
 * @Author ewnit
 * @Date 16/11/14.
 */
public class Course_Schedule_II_210 {

    /**
     * 1:0
     * 2:0
     * 3:1,2
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> tem = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int key = prerequisites[i][0];
            int val = prerequisites[i][1];
            if (map.containsKey(key)) {
                map.get(key).add(val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(val);
                map.put(key, list);
            }
        }
        int key = 0;
        while (!map.isEmpty()) {
            if (key >= prerequisites.length) break;
            isValid(tem, map, prerequisites[key][0]);
            key++;
        }
        int[] ans = new int[numCourses];
        if (!tem.isEmpty()) {
            for (int i = 0; i < tem.size(); i++) {
                ans[i] = tem.get(i);
            }
        }
        int pos = tem.size();
        if (key >= prerequisites.length && prerequisites.length != 0) return null;
        if (tem.size() < numCourses) {
            for (int i = 0; i < numCourses; i++) {
                if (!tem.contains(i)) ans[pos++] = i;
            }
        }
        return ans;
    }

    public void isValid(List<Integer> ans, Map<Integer, List<Integer>> map, int key) {
        if (map.containsKey(key)) {
            for (int k : map.get(key)) {
                if (!map.containsKey(k) && !ans.contains(k)) {
                    ans.add(k);
                    map.remove(k);
                }
                if (!ans.contains(k)) return;
            }
            ans.add(key);
            map.remove(key);
        }
    }

    public static void main(String[] args) {
        int[][] course = {{0, 1}, {1, 0}};
        new Course_Schedule_II_210().findOrder(2, course);
    }
}
