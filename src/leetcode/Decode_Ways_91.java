package leetcode;

/**
 * 功能描述:
 * <p/>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p/>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p/>
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * <p/>
 * The number of ways decoding "12" is 2.
 *
 * @Author ewnit
 * @Date 16/11/20.
 */
public class Decode_Ways_91 {

    /**
     * 划分
     * <p/>
     * every time take 1/2 letters
     * build a BST
     * if reach leaf +1
     * <p/>
     * Node{
     * Node left;
     * Node right;
     * int val;
     * }
     * func(String str,Node root){
     * if(str.length==1) ans++,return;
     * if(str.length==2&&isValid(str)) ans++,return;
     * <p/>
     * String s1=substr(1);
     * String s2=substr(2);
     * root.left=substr(1);
     * func(substr(1),root.left);
     * if(isValid(s2))
     * root.right=substr(2);
     * func(str,root.right);
     * <p/>
     * }
     *
     * dp
     *
     *
     */

    // TLE for "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"
    int ans = 0;

    public int numDecodings1(String s) {
        func(s);
        return ans;
    }

    public void func(String s) {
        if (s == null || s.length() == 0) return;
        if (s.length() == 1) {
            if (isValid(s)) ans++;
            return;
        }
        if (s.length() == 2) {
            if (isValid(s)) ans++;
            if (isValid(s.substring(0, 1)) && isValid(s.substring(1))) ans++;
            return;
        }

        String s1 = s.substring(0, 1);
        String s2 = s.substring(0, 2);
        if (isValid(s1)) func(s.substring(1));
        if (isValid(s2)) func(s.substring(2));
    }

    public boolean isValid(String s) {
        if (s.charAt(0) == '0') return false;
        int i = Integer.parseInt(s);
        if (i > 0 && i <= 26) return true;
        return false;
    }

    // dp 后一状态依赖前一状态
    // dp[i]代表substring(i)的可能数
    // dp[i]=substring(i,i+2)<=26?dp[i+1]+dp[i+2]:dp[i+1]
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] dp = new int[n+1];
        dp[n]  = 1;
        dp[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else dp[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? dp[i+1]+dp[i+2] : dp[i+1];

        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new Decode_Ways_91().numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
    }


}
