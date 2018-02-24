package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 *
 * @Author chen.yiran
 * @Date 17/6/26.
 */
public class Word_Pattern_290 {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length) return false;
        Map<String, Integer> map = new HashMap<>();
        int k = 0;
        String tem = "";
        String pp = "";
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], k);
                tem += Integer.toString(k);
                k++;
            } else {
                tem += Integer.toString(map.get(arr[i]));
            }

        }
        map.clear();
        k=0;
        for(int i=0;i<pattern.length();i++) {
            String stt = Character.toString(pattern.charAt(i));
            if (map.get(stt) == null) {
                map.put(stt, k);
                pp += Integer.toString(k);
                k++;
            } else {
                pp += Integer.toString(map.get(stt));
            }
        }
        return pp.equals(tem);
    }

    public static void main(String[] args) {
        System.out.println(new Word_Pattern_290().wordPattern("deadbeef", "d e a d b e e f"));
    }

}
