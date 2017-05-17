package leetcode;

import java.util.*;

/**
 * 功能描述:
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * @Author chen.yiran
 * @Date 17/2/16.
 */
public class Max_Points_on_a_Line_149 {

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    // y=ax+b
    // count every two points
    // store (a,b)->count

    /**
     * First, DO NOT use double in such kind of problem, you don't need them and they will make you suffer, DO use integers
     * <p>
     * Second, <k, b> is not a good idea simply because you cannot represent all the possible line using it.
     * <p>
     * You can use <a, b, c> to represent all the possible line, i.e., ax + by + c = 0 where a, b, c are all integers.
     */
    public int maxPointsWithDouble(Point[] points) {

        if (points.length <= 2) return points.length;
        Map<String, List<Point>> times = new HashMap<>();
        Map<String, List<Point>> xy = new HashMap<>();
        int max = 2;

        for (int i = 0; i < points.length - 1; i++) {
            Point x = points[i];

            String stry = Double.toString(0) + "," + Double.toString(x.y);
            String strx = Double.toString(x.x) + "," + Double.toString(0);
            max = Math.max(addOne(xy, strx, x), max);
            max = Math.max(addOne(xy, stry, x), max);

            for (int j = i + 1; j < points.length; j++) {
                Point y = points[j];

                double a = 0;
                double b = 0;
                if (x.x - y.x != 0) {
                    a = (double) (x.y - y.y) / (x.x - y.x);
                    b = (double) x.y - a * x.x;
                }
                a = a == -0.0 ? 0 : a;
                b = b == -0.0 ? 0 : b;
                String s = Double.toString(a) + "," + Double.toString(b);
                if (!s.equals("0.0,0.0")) {
                    max = Math.max(addOne(times, s, x), max);
                    max = Math.max(addOne(times, s, y), max);
                }
            }
        }
        Point x = points[points.length - 1];
        String stry = Double.toString(0) + "," + Double.toString(x.y);
        String strx = Double.toString(x.x) + "," + Double.toString(0);
        max = Math.max(addOne(xy, strx, x), max);
        max = Math.max(addOne(xy, stry, x), max);
        return max;
    }

    public int addOne(Map<String, List<Point>> times, String s, Point x) {
        int max = 0;
        if (times.get(s) == null) {
            List<Point> list = new ArrayList<>();
            list.add(x);
            times.put(s, list);
        } else {
            List<Point> list = times.get(s);
            if (!list.contains(x)) {
                list.add(x);
            }
            max = list.size();
        }
        return max;
    }

    // x/y = a but a could be a double so store x and y instead of a
    // 在计算机里使用double表示斜率，是不严谨的也是不正确的，double有精度误差，double是有限的，斜率是无限的，无法使用有限的double表示无限的斜率
    // 表示斜率最靠谱的方式是用最简分数，即分子分母都无法再约分了。分子分母同时除以他们的最大公约数gcd即可得到最简分数
    public int maxPoints(Point[] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int overlap = 0, max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = generateGCD(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }

                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    } else {
                        map.get(x).put(y, 1);
                    }
                } else {
                    Map<Integer, Integer> m = new HashMap<>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;


    }

    private int generateGCD(int a, int b) {

        if (b == 0) return a;
        else return generateGCD(b, a % b);

    }

    public static void main(String[] args) {
        //[[0,-12],[5,2],[2,5],[0,-5],[1,5],[2,-2],[5,-4],[3,4],[-2,4],[-1,4],[0,-5],[0,-8],[-2,-1],[0,-11],[0,-9]]
//        Point p1 = new Point(0, -12);
//        Point p2 = new Point(5, 2);
//        Point p3 = new Point(2, 5);
//        Point p4 = new Point(0, -5);
//        Point p5 = new Point(1, 5);
//        Point p6 = new Point(2, -2);
//        Point p7 = new Point(5, 4);
//        Point p8 = new Point(3, 4);
//        Point p9 = new Point(-2, 4);
//        Point p10 = new Point(-1, 4);
//        Point p11 = new Point(0, -5);
//        Point p12 = new Point(0, -8);
//        Point p13 = new Point(-2, -1);
//        Point p14 = new Point(0, -11);
//        Point p15 = new Point(0, -9);
//        Point[] points = new Point[15];
//        points[0] = p1;
//        points[1] = p2;
//        points[2] = p3;
//        points[3] = p4;
//        points[4] = p5;
//        points[5] = p6;
//        points[6] = p7;
//        points[7] = p8;
//        points[8] = p9;
//        points[9] = p10;
//        points[10] = p11;
//        points[11] = p12;
//        points[12] = p13;
//        points[13] = p14;
//        points[14] = p15;

//        String testCase = "[-240,-657],[-27,-188],[-616,-247],[-264,-311],[-352,-393],[-270,-748],[3,4],[-308,-87],[150,526],[0,-13],[-7,-40],[-3,-10],[-531,-892],[-88,-147],[4,-3],[-873,-555],[-582,-360],[-539,-207],[-118,-206],[970,680],[-231,-47],[352,263],[510,143],[295,480],[-590,-990],[-236,-402],[308,233],[-60,-111],[462,313],[-270,-748],[-352,-393],[-35,-148],[-7,-40],[440,345],[388,290],[270,890],[10,-7],[60,253],[-531,-892],[388,290],[-388,-230],[340,85],[0,-13],[770,473],[0,73],[873,615],[-42,-175],[-6,-8],[49,176],[308,222],[170,27],[-485,-295],[170,27],[510,143],[-18,-156],[-63,-316],[-28,-121],[396,304],[472,774],[-14,-67],[-5,7],[-485,-295],[118,186],[-154,-7],[-7,-40],[-97,-35],[4,-9],[-18,-156],[0,-31],[-9,-124],[-300,-839],[-308,-352],[-425,-176],[-194,-100],[873,615],[413,676],[-90,-202],[220,140],[77,113],[-236,-402],[-9,-124],[63,230],[-255,-118],[472,774],[-56,-229],[90,228],[3,-8],[81,196],[970,680],[485,355],[-354,-598],[-385,-127],[-2,7],[531,872],[-680,-263],[-21,-94],[-118,-206],[616,393],[291,225],[-240,-657],[-5,-4],[1,-2],[485,355],[231,193],[-88,-147],[-291,-165],[-176,-229],[154,153],[-970,-620],[-77,33],[-60,-111],[30,162],[-18,-156],[425,114],[-177,-304],[-21,-94],[-10,9],[-352,-393],[154,153],[-220,-270],[44,-24],[-291,-165],[0,-31],[240,799],[-5,-9],[-70,-283],[-176,-229],[3,8],[-679,-425],[-385,-127],[396,304],[-308,-352],[-595,-234],[42,149],[-220,-270],[385,273],[-308,-87],[-54,-284],[680,201],[-154,-7],[-440,-475],[-531,-892],[-42,-175],[770,473],[118,186],[-385,-127],[154,153],[56,203],[-616,-247],";
        String testCase="[1,1],[1,1],[0,0],";

        String[] cases = testCase.split("],");
        Point[] points = new Point[cases.length];
        int i = 0;
        for (String cs : cases) {
            cs = cs.substring(1);
            String[] xy = cs.split(",");
            points[i++] = new Point(new Integer(xy[0]), new Integer(xy[1]));
        }

        System.out.println(new Max_Points_on_a_Line_149().maxPoints(points));

    }
}
