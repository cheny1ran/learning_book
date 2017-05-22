package basic;

import leetcode.Reconstruct_Itinerary_332;

/**
 * 功能描述:
 *
 * @Author ewnit
 * @Date 16/12/4.
 */
public class Backtrack {

    // 回溯法 经典问题:八皇后
    int[] gEightQueen = new int[8];

    void eightQueen(int index) {
        int loop;

        for (loop = 0; loop < 8; loop++) {
            if (isValid(index, loop)) {
                gEightQueen[index] = loop;

                if (7 == index) {
                    gEightQueen[index] = 0;
                    return;
                }

                eightQueen(index + 1);
                gEightQueen[index] = 0;
            }
        }
    }

    boolean isValid(int loop, int value) {
        int index;
        int data;

        for (index = 0; index < loop; index++) {
            data = gEightQueen[index];

            if (value == data)
                return false;

            if ((index + data) == (loop + value))
                return false;

            if ((index - data) == (loop - value))
                return false;
        }

        return true;
    }


    public static void main(String[] args) {

        new Backtrack().eightQueen(0);

        // reference
        new Reconstruct_Itinerary_332();
    }
}
