package leetcode;

/**
 * 功能描述:
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p/>
 * Note:
 * <p/>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * @Author ewnit
 * @Date 16/12/2.
 */
public class Add_Strings_415 {
    public String addStrings(String num1, String num2) {
        String maxstr = num1.length() >= num2.length() ? num1 : num2;
        String minstr = num1.length() >= num2.length() ? num2 : num1;

        int up = 0;
        String ans = "";
        for (int i = minstr.length() - 1, j = maxstr.length() - 1; i >= 0; i--, j--) {
            int x = minstr.charAt(i) - '0';
            int y = maxstr.charAt(j) - '0';
            int tem = up + x + y;
            up = tem / 10;
            ans += Integer.toString(tem % 10);
        }
        if (maxstr.length() > minstr.length()) {
            for (int i = maxstr.length() - minstr.length()-1; i >= 0; i--) {
                int x = maxstr.charAt(i) - '0';
                int tem = x + up;
                up = tem / 10;
                ans += Integer.toString(tem % 10);
            }
        }
        if(up!=0) ans += Integer.toString(up);
        return new StringBuilder(ans).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Add_Strings_415().addStrings("99", "9"));
    }

}
