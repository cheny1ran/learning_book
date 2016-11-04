package leetcode;

/**
 * 功能描述:
 *
 * @Author ewnit
 * @Date 16/11/4.
 */
public class Length_of_Last_Word_58 {

    public int lengthOfLastWord(String s) {
        if (s == null) return 0;
        String[] str = s.split(" ");
        return str.length == 0 ? 0 : str[str.length - 1].length();
    }
}
