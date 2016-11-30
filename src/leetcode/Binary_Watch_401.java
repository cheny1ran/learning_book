package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 * <p/>
 * Each LED represents a zero or one, with the least significant bit on the right.
 * <p/>
 * <p/>
 * For example, the above binary watch reads "3:25".
 * <p/>
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
 * <p/>
 * Example:
 * <p/>
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *
 * @Author ewnit
 * @Date 16/11/29.
 */
public class Binary_Watch_401 {

    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        List<String> bi = func(10, num);
        for (String s : bi) {
            String str = generateTime(s);
            if (str != null)
                ans.add(str);
        }
        return ans;
    }

    public String generateTime(String binary) {
        String high = Integer.valueOf(binary.substring(0, 4), 2).toString();
        String low = Integer.valueOf(binary.substring(4), 2).toString();
        if (Integer.parseInt(high) > 11 || Integer.parseInt(low) > 59) return null;
        if (low.length() == 1) {
            low = "0" + low;
        }
        return high + ":" + low;
    }

    public List<String> func(int k, int num) {
        List<String> list = new ArrayList<>();
        if (num == 0) {
            String s = "";
            for (int i = 0; i < k; i++) {
                s += "0";
            }
            list.add(s);
            return list;
        }
        if (k == num) {
            String s = "";
            for (int i = 0; i < k; i++) {
                s += "1";
            }
            list.add(s);
            return list;
        }
        List<String> f0 = func(k - 1, num);
        List<String> f1 = func(k - 1, num - 1);
        for (String s : f0)
            list.add("0" + s);
        for (String s : f1)
            list.add("1" + s);
        return list;
    }


    public List<String> readBinaryWatch1(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++)
            for (int m = 0; m < 60; m++)
                if (Integer.bitCount(h * 64 + m) == num)
                    times.add(String.format("%d:%02d", h, m));
        return times;
    }

    public static void main(String[] args) {
        List<String> list = new Binary_Watch_401().readBinaryWatch(2);
        for (String s : list) {
            System.out.println(s);
        }
    }

}
