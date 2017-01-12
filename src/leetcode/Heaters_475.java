package leetcode;

import java.util.Arrays;

/**
 * 功能描述:
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
 * <p>
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.
 * <p>
 * So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
 * <p>
 * Note:
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 * <p>
 * <p>
 * Example 1:
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 * Example 2:
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 *
 * @Author chen.yiran
 * @Date 17/1/11.
 */

public class Heaters_475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = 0;
        for (int house : houses) {
            int pos = Arrays.binarySearch(heaters, house);
            if (pos < 0) {
                pos = -pos - 1;
            }
            int dist1 = pos - 1 >= 0 ? house - heaters[pos - 1] : Integer.MAX_VALUE;
            int dist2 = pos < heaters.length ? heaters[pos] - house : Integer.MAX_VALUE;

            ans = Math.max(ans, Math.min(dist1, dist2));

        }
        return ans;
    }


    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 5, 15};
        int[] heaters = {2, 30};
        System.out.println(new Heaters_475().findRadius(houses, heaters));

    }


}
