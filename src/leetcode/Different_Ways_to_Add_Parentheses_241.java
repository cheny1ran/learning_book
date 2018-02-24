package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 * <p>
 * <p>
 * Example 1
 * Input: "2-1-1".
 * <p>
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * <p>
 * <p>
 * Example 2
 * Input: "2*3-4*5"
 * <p>
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 *
 * @Author chen.yiran
 * @Date 17/6/26.
 */
public class Different_Ways_to_Add_Parentheses_241 {

    /**
     * 不同的出栈顺序
     * (2*(3-(4*5))) = -34  (3,2,1)
     * ((2*3)-(4*5)) = -14  (1,3,2)/(2,3,1)/(1,2,1)
     * ((2*(3-4))*5) = -10  (2,1,3)
     * (2*((3-4)*5)) = -10  (3,1,2)
     * (((2*3)-4)*5) = 10   (1,2,3)
     * <p>
     * 分治
     * if(encounter('*'||'+'||'-')){
     * recursive(left) && recursive(right)
     * }
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '*' || ch == '+' || ch == '-') {
                flag = true;
                String left = input.substring(0, i);
                String right = input.substring(i + 1);
                List<Integer> ll = diffWaysToCompute(left);
                List<Integer> rl = diffWaysToCompute(right);
                for (Integer lv : ll) {
                    for (Integer rv : rl) {
                        if (ch == '*') {
                            ans.add(lv * rv);
                        } else if (ch == '+') {
                            ans.add(lv + rv);
                        } else {
                            ans.add(lv - rv);
                        }
                    }
                }
            }
        }
        if (!flag) {
            Integer ii = Integer.parseInt(input);
            ans.add(ii);
            return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> ans = new Different_Ways_to_Add_Parentheses_241().diffWaysToCompute("21");
        for (Integer ii : ans) {
            System.out.print(ii + " ");
        }
    }

}
