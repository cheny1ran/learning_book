package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * Given an integer n, return 1 - n in lexicographical order.
 * <p>
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * <p>
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 *
 * @Author chen.yiran
 * @Date 17/5/22.
 */
public class Lexicographical_Numbers_386 {

    // very much like tree node DFS
    public List<Integer> lexicalOrder(int n) {
        return DFS(1, n);
    }

    public List<Integer> DFS(int num, int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = num; i < num + 10 - (num == 1 ? 1 : 0); i++) {
            if (i > n) break;

            ans.add(i);
            if (num * 10 <= n) {
                ans.addAll(DFS(i * 10, n));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = new Lexicographical_Numbers_386().lexicalOrder(103);
        for (int i : list) {
            System.out.print(i + ",");
        }
        System.out.println();

    }

}
