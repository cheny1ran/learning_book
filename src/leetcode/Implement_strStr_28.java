package leetcode;

/**
 * 功能描述:
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * @Author ewnit
 * @Date 16/12/2.
 */
public class Implement_strStr_28 {

    public int strStr(String haystack, String needle) {
        int hlen=haystack.length();
        int nlen=needle.length();
        if (hlen >= nlen) {
            for(int i=0;i<=hlen-nlen;i++) {
                if (haystack.substring(i, i + nlen).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Implement_strStr_28().strStr("fenwifneownw", "fenwifneownw"));
    }

}
