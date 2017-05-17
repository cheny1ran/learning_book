package leetcode;

import java.util.*;

/**
 * 功能描述:
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 * @Author chen.yiran
 * @Date 17/5/5.
 */
public class Merge_Intervals_56 {

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    /**
     * it needs to be sorted?
     * <p>
     */
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return (o1.start == o2.start) ? (o2.end - o1.end):(o1.start - o2.start);
            }
        });
        List<Interval> ans = new ArrayList<>();
        if(intervals.isEmpty()) return ans;
        ans.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            boolean flag = true;
            // 1,4;2,5
            for (Interval model : ans) {
                if (model.end >= cur.start) {
                    flag = false;
                    if (model.end <= cur.end) model.end = cur.end;
                }
            }
            if (flag) ans.add(cur);
        }
        return ans;
    }


    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(2, 3));
        list.add(new Interval(4, 5));
        list.add(new Interval(6, 7));
        list.add(new Interval(8, 9));
        list.add(new Interval(1, 10));
        list.add(new Interval(2, 3));
        list.add(new Interval(4, 6));
        list.add(new Interval(5, 7));
        list.add(new Interval(3, 4));


        List<Interval> ans = new Merge_Intervals_56().merge(list);
        for (Interval interval : ans) {
            System.out.println(interval.start + "," + interval.end);
        }
    }

}
