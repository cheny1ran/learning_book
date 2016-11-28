package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * <p/>
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p/>
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 *
 * @Author ewnit
 * @Date 16/11/21.
 */
public class Remove_Invalid_Parentheses_301 {

    /**
     *
     * 1. minimum number is not a certain number
     * using stack?
     * (push )poll
     * if stack for ( is not empty:
     *
     * directly using string
     * if '(' str+=
     * else
     *
     */
    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();
        if (s != null || s.length() > 0) {

        }

        return ans;
    }

    public void dfs(String s, int pos,List<String> ans) {
        if(s.length()==0) return;
        if(pos>=s.length()) ans.add(s);


    }

/**
*    public List<String> removeInvalidParentheses1(String s) {
*        List<String> ans = new ArrayList<>();
*        remove(s, ans, 0, 0, new char[]{'(', ')'});
*        return ans;
*    }
*
*    public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
*        for (int stack = 0, i = last_i; i < s.length(); ++i) {
*            if (s.charAt(i) == par[0]) stack++;
*            if (s.charAt(i) == par[1]) stack--;
*            if (stack >= 0) continue;
*            for (int j = last_j; j <= i; ++j)
*                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
*                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
*            return;
*        }
*        String reversed = new StringBuilder(s).reverse().toString();
*        if (par[0] == '(') // finished left to right
*            remove(reversed, ans, 0, 0, new char[]{')', '('});
*        else // finished right to left
*            ans.add(reversed);
*    }
**/
    public static void main(String[] args) {
        List<String> ans= new Remove_Invalid_Parentheses_301().removeInvalidParentheses("(((((((((((((()");
        for (String s : ans) {
            System.out.println(s);
        }
    }
}
