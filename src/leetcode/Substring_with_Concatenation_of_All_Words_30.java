package leetcode;

import java.util.*;

/**
 * 功能描述:
 * <p/>
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * <p/>
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * <p/>
 * You should return the indices: [0,9].
 * (order does not matter).
 *
 * @Author ewnit
 * @Date 16/11/13.
 */
public class Substring_with_Concatenation_of_All_Words_30 {

    //TLE
    public List<Integer> findSubstringx1(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words == null || words.length == 0 || s == null || s.length() == 0) return ans;
        int len = words[0].length();
        int num = words.length;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            if (s.contains(words[i])) {
                List<Integer> list = new ArrayList<>();
                int begin = 0;
                int pos = s.indexOf(words[i]);
                while (begin < s.length() && pos != -1) {
                    list.add(pos);
                    pos = s.indexOf(words[i], begin + len + 1);
                    begin += pos + 1;
                }
                lists.add(list);
            }
        }
        List<Integer> tem = new ArrayList<>();
        for (int i = 0; i < lists.get(0).size(); i++) {
            boolean flag = false;
            tem.clear();
            for (List<Integer> list : lists) {
                if (list.size() - 1 < i) {
                    break;
                }
                tem.add(list.get(i));
            }
            if (tem.size() < num) continue;
            Collections.sort(tem);
            int a = tem.get(0);
            for (int k = 1; k < tem.size(); k++) {
                flag = true;
                if (tem.get(k) != a + len) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(tem.get(0));
            }
        }
        return ans;
    }

    /**
     * 无法通过
     * Input:
     * "barfoofoobarthefoobarman"
     * ["bar","foo","the"]
     * Output:
     * [0,10]
     * Expected:
     * [6,9,12]
     */
    public List<Integer> findSubstringx2(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words == null || words.length == 0 || s == null || s.length() == 0) return ans;
        int len = words[0].length();
        String tems = "";
        for (int i = 0; i < len; i++) {
            tems += "@";
        }
        for (String str : words) {
            s = s.replaceAll(str, tems);
        }
        String rp = "";
        for (int i = 0; i < words.length; i++) {
            rp += tems;
        }

        if (s.contains(rp)) {
            int begin = 0;
            int pos = s.indexOf(rp);
            while (begin < s.length() && pos != -1) {
                ans.add(pos);
                pos = s.indexOf(rp, begin + rp.length() + 1);
                begin += pos + 1;
            }
        }

        return ans;

    }

    //滑动窗口
    //https://discuss.leetcode.com/topic/6617/an-o-n-solution-with-detailed-explanation/10
    //Just build a map for the words and their relative count in L. Then we traverse through S to check whether there is a match.
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words == null || words.length == 0 || s == null || s.length() == 0) return ans;
        Map<String, Integer> map = new HashMap<>();
        int window = words.length * words[0].length();
        int len = words[0].length();
        for (String str : words) {
            map.put(str, map.containsKey(str) ? map.get(str) + 1 : 1);
        }
        for (int i = 0; i <= s.length() - window; i++) {
            Map<String, Integer> m=new HashMap<>(map);
            for(int j=0;j<words.length;j++) {
                String tem = s.substring(i + j * len, i + j * len + len);
                if (m.containsKey(tem)) {
                    if(m.get(tem)==1) m.remove(tem);
                    else m.put(tem, m.get(tem) - 1);
                }else break;
            }
            if(m.isEmpty()) ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        new Substring_with_Concatenation_of_All_Words_30().findSubstring(s, words);
    }

}
