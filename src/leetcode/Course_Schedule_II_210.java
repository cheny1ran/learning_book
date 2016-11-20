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
     * <p/>
     * 考虑情况:
     * 无前置课程->prerequisites为空
     * 循环依赖 {1,0},{0,1}
     * 依赖多节课
     * bfs
     * <p/>
     * list ans
     * Queue clzs
     * for num in numCourses{
     * clzs.push(num)
     * while(!clzs.isEmpty()){
     * int n=clzs.peek();//no delete
     * for pair in prerequisties{
     * if pair[0]==n:
     * if(clzs.contains(pair[1]) return false;//is a loop
     * clzs.push(pair[1])
     * }
     * if clzs.peek()==n:
     * ans.add(n)
     * <p/>
     * }
     * }
     */

    //TLE
    public int[] findOrder1(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        if (prerequisites != null || prerequisites.length != 0) {
            for (int i = 0; i < prerequisites.length; i++) {
                if (!map.containsKey(prerequisites[i][0])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(prerequisites[i][1]);
                    map.put(prerequisites[i][0], list);
                } else {
                    List<Integer> list = map.get(prerequisites[i][0]);
                    if (!list.contains(prerequisites[i][1]))
                        list.add(prerequisites[i][1]);
                }
            }
        }
        List<Integer> tem = new ArrayList<>();
        int[] ans = new int[numCourses];
        Stack<Integer> clzs = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (tem.contains(i)) continue;
            clzs.push(i);
            while (!clzs.isEmpty()) {
                int n = clzs.peek();
                if (map.containsKey(n)) {
                    for (int m : map.get(n)) {
                        if (clzs.contains(m)) return new int[0];
                        if (!tem.contains(m)) clzs.push(m);
                    }
                    map.remove(n);
                }
                if (clzs.peek() == n) {
                    tem.add(n);
                    clzs.pop();
                }
            }
        }
        int pos = 0;
        for (int i : tem) {
            ans[pos++] = i;
        }
        return ans;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incLinkCounts = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        initialiseGraph(incLinkCounts, adjs, prerequisites);
        return solveByBFS(incLinkCounts, adjs);
    }

    private void initialiseGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites) {
        int n = incLinkCounts.length;
        while (n-- > 0) adjs.add(new ArrayList<Integer>());
        for (int[] edge : prerequisites) {
            incLinkCounts[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }
    }

    private int[] solveByBFS(int[] incLinkCounts, List<List<Integer>> adjs) {
        int[] order = new int[incLinkCounts.length];
        Queue<Integer> toVisit = new ArrayDeque<>();
        for (int i = 0; i < incLinkCounts.length; i++) {
            if (incLinkCounts[i] == 0) toVisit.offer(i);
        }
        int visited = 0;
        while (!toVisit.isEmpty()) {
            int from = toVisit.poll();
            order[visited++] = from;
            for (int to : adjs.get(from)) {
                incLinkCounts[to]--;
                if (incLinkCounts[to] == 0) toVisit.offer(to);
            }
        }
        return visited == incLinkCounts.length ? order : new int[0];
    }


    public static void main(String[] args) {
        int[][] course = {{5, 8}, {3, 5}, {1, 9}, {4, 5}, {0, 2}, {1, 9}, {7, 8}, {4, 9}};
        new Course_Schedule_II_210().findOrder(10, course);
    }
}
