package leetcode;

/**
 * 功能描述:
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * @Author ewnit
 * @Date 16/10/22.
 */
public class Factorial_Trailing_Zeroes_172 {

    public int trailingZeroes(int n) {
        //100中能分解出的5 :1*5,2*5,3*5...20*5 去掉5 就是20! 同理
        return n >= 5 ? trailingZeroes(n / 5) + n / 5 : 0;

    }

    public static void main(String[] args) {
        Factorial_Trailing_Zeroes_172 i = new Factorial_Trailing_Zeroes_172();
        System.out.println(i.trailingZeroes(30));
        System.out.println(i.trailingZeroes(50));
    }

}
