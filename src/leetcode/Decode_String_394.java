package leetcode;


import java.util.LinkedList;

/**
 * 功能描述:
 * Given an encoded string, return it's decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * <p>
 * Examples:
 * <p>
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 * @Author chen.yiran
 * @Date 17/5/26.
 */
public class Decode_String_394 {
    // stack
    public String decodeString(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ']') {
                stack.push(ch);
            } else {
                StringBuilder tem = new StringBuilder();
                char poped = stack.pop();
                while (poped != '[') {
                    tem.insert(0, poped);
                    poped = stack.pop();
                }
                StringBuilder tt = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    tt.insert(0, stack.pop());
                }
                int times = Integer.parseInt(tt.toString());
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    sb.append(tem.toString());
                }
                for (int k = 0; k < sb.length(); k++) {
                    char ccc = sb.charAt(k);
                    stack.push(ccc);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Decode_String_394().decodeString("100[leetcode]"));

    }

}
