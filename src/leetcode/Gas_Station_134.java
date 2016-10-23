package leetcode;

/**
 * 功能描述:
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p/>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p/>
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * <p/>
 * Note:
 * The solution is guaranteed to be unique.
 *
 * @Author cyan
 * @Date 16/10/22.
 */
public class Gas_Station_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int crtgas = 0;
        int total = gas.length;
        for (int i = 0; i < gas.length; i++) {
            int pos = i;
            int j = 0;
            crtgas = gas[i];
            while (j < total && cost[pos] <= crtgas) {
                j++;
                crtgas -= cost[pos];
                pos++;
                if (pos == gas.length) pos = 0;
                crtgas += gas[pos];
            }
            if(j==total) return pos;
        }
        return -1;
    }



}
