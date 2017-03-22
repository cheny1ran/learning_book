package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @Author chen.yiran
 * @Date 17/3/22.
 */
public class Generate_Parentheses_22 {

    /**
     * when you put (
     * there is two ways to go
     * 1. ) -> generateParenthesis(n-1)
     * 2. ( ->
     */
    public List<String> generateParenthesis(int n) {
        return gp(n, n);
    }

    public List<String> gp(int ln, int rn) {
        // ln always < rn
        List<String> ans = new ArrayList<>();
        if (ln == 0) {
            String str = "";
            for (int i = 0; i < rn; i++) {
                str += ")";
            }
            ans.add(str);
        } else {
            List<String> llist = gp(ln - 1, rn);
            for (String s : llist) {
                ans.add("(" + s);
            }
            if (rn - 1 >= ln) {
                List<String> rlist = gp(ln, rn - 1);
                for (String s : rlist) {
                    ans.add(")" + s);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        for (String str : new Generate_Parentheses_22().generateParenthesis(0)) {
            System.out.println(str);
        }
    }
}
