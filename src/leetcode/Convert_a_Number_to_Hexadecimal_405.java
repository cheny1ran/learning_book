package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * <p>
 * Note:
 * <p>
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * Example 1:
 * <p>
 * Input:
 * 26
 * <p>
 * Output:
 * "1a"
 * Example 2:
 * <p>
 * Input:
 * -1
 * <p>
 * Output:
 * "ffffffff"
 *
 * @Author chen.yiran
 * @Date 17/5/18.
 */
public class Convert_a_Number_to_Hexadecimal_405 {

    char[] hexStr = "0123456789abcdef".toCharArray();
    Map<Character, Integer> map = new HashMap<>();

    public String toHex(int num) {

        for (int i = 0; i < hexStr.length; i++) {
            if (i > 9) {
                map.put(hexStr[i], hexStr[i] - 97 + 10);
            } else map.put(hexStr[i], hexStr[i] - 48);
        }

        String ans = "";
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = 0 - num;
        }
        // -2147483648
        if (num < 0) {
            return "80000000";
        }

        while (num / 16 != 0) {
            ans = hexStr[num % 16] + ans;
            num /= 16;
        }
        ans = hexStr[num % 16] + ans;
        if (flag) {
            while (ans.length() < 8) {
                ans = "0" + ans;
            }
            String tem = "";
            for (int i = 0; i < ans.length(); i++) {
                int ii = map.get(ans.charAt(i));
                tem += hexStr[15 - ii];
            }
            ans = tem;
            int len = ans.length();
            int index = len - 1;
            if (ans.charAt(len - 1) == 'f') {
                while (ans.charAt(index) == 'f') {
                    ans = ans.substring(0, index) + '0' + (index < len ? ans.substring(index + 1) : "");
                    index--;
                }
                ans = ans.substring(0, index) + hexStr[map.get(ans.charAt(index)) + 1] + (index < len ? ans.substring(index + 1) : "");
            } else {
                index = map.get(ans.charAt(len - 1));
                ans = ans.substring(0, len - 1) + hexStr[index + 1];
            }
        }

        return ans;
    }

    public String toHex1(int num) {
        if (num == 0) return "0";
        String result = "";
        while (num != 0) {
            result = hexStr[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Convert_a_Number_to_Hexadecimal_405().toHex1(-3));
//        System.out.println(new Convert_a_Number_to_Hexadecimal_405().toHex(-2147483648));
    }

}
