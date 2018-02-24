package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 功能描述:
 * <p>
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * @Author chen.yiran
 * @Date 17/6/16.
 */
public class Minimum_Window_Substring_76 {

    /**
     * the begin and end of the window must be words in t
     * point1->0,point2->3,point3->5  minStr="ADOBEC" point1 poped,match[A]=0,match[B]=1,match[C]=1
     * point2->3,point3->5, match[B]=1 && point4=B ->point2 poped
     * point3->5,point4->9,point5->10, len>=minStr.length, point3 poped,match[C]=0,match[B]=1,match[A]=1
     * point4->9,point5->10,point6->12, len<minStr.length, minStr="BANC", point4 poped,match[B]=0
     * at the end of string , matched == t.length, return minStr;
     * <p>
     * <p>
     * you can always replace the matched character?
     */

    // TLE
    public String minWindow(String s, String t) {
        int matched = 0;
        String ans = "";
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            map.put(ch, map.get(ch) == null ? 1 : map.get(ch) + 1);
        }

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.get(ch) != null) {
                if (map.get(ch) == 0) {
                    for (Integer pos : stack) {
                        if (s.charAt(pos) == ch) {
                            stack.remove(pos);
                            break;
                        }
                    }

                } else if (map.get(ch) > 0) {
                    map.put(ch, map.get(ch) - 1);
                    matched++;
                }
                stack.addLast(i);
                if (matched == t.length()) {
                    String tem = s.substring(stack.peek(), i + 1);
                    ans = (tem.length() < ans.length()) || ans.length() == 0 ? tem : ans;
                }
            }
        }

        return matched == t.length() ? ans : "";

    }

    public String minWindow1(String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0) {
                    count++;
                }
                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if (minLen > s.length()) {
            return "";
        }

        return s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        System.out.println(new Minimum_Window_Substring_76().minWindow1("ADOBECODEBANC", "ABC"));


    }
}
