package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p>
 * <p>
 * <p>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * @Author chen.yiran
 * @Date 17/5/24.
 */
public class Letter_Combinations_of_a_Phone_Number_17 {

    final String[] letterDic = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;

        List<String> subList = digits.length() > 1 ? letterCombinations(digits.substring(1)) : new ArrayList<>();
        String lee = letterDic[digits.charAt(0) - 48];
        for (int i = 0; i < lee.length(); i++) {
            String tem = Character.toString(lee.charAt(i));
            if (!subList.isEmpty()) {
                for (String str : subList) {
                    ans.add(tem + str);
                }
            } else {
                ans.add(tem);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        for (String str : new Letter_Combinations_of_a_Phone_Number_17().letterCombinations("23")) {
            System.out.println(str);
        }
    }

}
