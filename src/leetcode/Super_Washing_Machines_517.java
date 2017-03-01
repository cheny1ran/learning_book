package leetcode;

/**
 * 功能描述:
 * You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.
 * <p>
 * For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass one dress of each washing machine to one of its adjacent washing machines at the same time .
 * <p>
 * Given an integer array representing the number of dresses in each washing machine from left to right on the line, you should find the minimum number of moves to make all the washing machines have the same number of dresses. If it is not possible to do it, return -1.
 * <p>
 * Example1
 * <p>
 * Input: [1,0,5]
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * 1st move:    1     0 <-- 5    =>    1     1     4
 * 2nd move:    1 <-- 1 <-- 4    =>    2     1     3
 * 3rd move:    2     1 <-- 3    =>    2     2     2
 * Example2
 * <p>
 * Input: [0,3,0]
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * 1st move:    0 <-- 3     0    =>    1     2     0
 * 2nd move:    1     2 --> 0    =>    1     1     1
 * Example3
 * <p>
 * Input: [0,2,0]
 * <p>
 * Output: -1
 * <p>
 * Explanation:
 * It's impossible to make all the three washing machines have the same number of dresses.
 * Note:
 * The range of n is [1, 10000].
 * The range of dresses number in a super washing machine is [0, 1e5].
 *
 * @Author chen.yiran
 * @Date 17/2/23.
 */
public class Super_Washing_Machines_517 {

    /**
     * 0,0,0,8
     * 0,0,1,7
     * 0,1,1,6
     * 1,1,1,5
     * 2,1,1,4
     * 2,2,1,3
     * 2,2,2,2
     * <p>
     * 0,0,0,12
     * 0,0,1,11
     * 0,1,1,10
     * 1,1,1,9
     * 2,1,1,8
     * 3,1,1,7
     * 3,2,1,6
     * 3,3,1,5
     * 3,3,2,4
     * 3,3,3,3
     * <p>
     * pos[i]= step(to pos!=0)+basic-1
     * <p>
     * 0,0,6 is same as 0,6,0
     * but 4,0,0,4 is not same as 0,0,4,4
     * <p>
     * https://discuss.leetcode.com/topic/79938/super-short-easy-java-o-n-solution
     */
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int i = 0; i < machines.length; i++) {
            sum += machines[i];
        }
        if (sum % machines.length != 0) return -1;
        int even = sum / machines.length;

        int cnt = 0, max = 0;
        for (int load : machines) {
            cnt += load - even; //load-avg is "gain/lose"
            max = Math.max(Math.max(max, Math.abs(cnt)), load - even);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ma = {0, 0, 0, 12};
        System.out.println(new Super_Washing_Machines_517().findMinMoves(ma));
    }

}
