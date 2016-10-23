package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * Write a program that outputs the string representation of numbers from 1 to n.
 * <p/>
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * <p/>
 * Example:
 * <p/>
 * n = 15,
 * <p/>
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 *
 * @Author cyan
 * @Date 16/10/22.
 */
public class Fizz_Buzz_412 {

    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String str = "";
            if (i % 15 == 0) {
                str = "FizzBuzz";
            } else if (i % 5 == 0) {
                str = "Buzz";
            } else if (i % 3 == 0) {
                str = "Fizz";
            } else {
                str = Integer.toString(i);
            }
            ans.add(str);
        }
        return ans;
    }

}
