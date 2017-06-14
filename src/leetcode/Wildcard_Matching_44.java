package leetcode;

/**
 * 功能描述:
 * Implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 *
 * @Author chen.yiran
 * @Date 17/5/19.
 */
public class Wildcard_Matching_44 {
    // fullfill the pattern
    // how to ?
    //
    // isMatch("aab", "***b") → true
    // aabaab -> *b


    /**
     * (* ->?)
     * backtrack
     * int pointS,int pointP
     * when encounter a '?':
     * pointS++;p
     * when encounter a '*':
     * while(s.charAt(pointS)!= p.charAt(pointP):
     * pointS++;
     * <p>
     * int prePos=pointS;
     * pointS++;pointP++;
     * if(pointS>=s.length()) return true;
     * if(pointP>=s.length()) return false;
     */


    /**
     * pattern to match or match to pattern?
     * <p>
     * pattern to string.
     * pointP
     * when encounter a '?' -> pointP++
     * <p>
     * boolean dp[i][j]= s(0~i) match p(0~p)
     * <p>
     * dp[0][0]=1
     * dp[i][j]=(dp[i-1][j] && (p[j] == *)) ||
     * (dp[i-1][j-1] && (s[i] == p[j] || p[j] == * || p[j] == ?) ||
     */

    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true;
        if (s.length() == 0) {
            String tem = p.replaceAll("\\*", "");
            if (tem.length() == 0) return true;
            return false;
        }
        if (p.length() == 0) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] && (p.charAt(j) == '*');
                dp[i + 1][j + 1] = dp[i + 1][j + 1] || (dp[i][j] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '*' || p.charAt(j) == '?'));
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Wildcard_Matching_44 obj = new Wildcard_Matching_44();
//        System.out.println(obj.isMatch("aa", "a"));
//        System.out.println(obj.isMatch("aa", "aa"));
//        System.out.println(obj.isMatch("aaa", "aa"));
//        System.out.println(obj.isMatch("aa", "*"));
//        System.out.println(obj.isMatch("aa", "a*"));
//        System.out.println(obj.isMatch("ab", "*?*"));
//        System.out.println(obj.isMatch("ab", "?*"));
//        System.out.println(obj.isMatch("aab", "c*a*b"));
        System.out.println(obj.isMatch("a", "a*"));
        System.out.println(obj.isMatch("zacabz", "*a?b*"));
    }
}
