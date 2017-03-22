package leetcode;

import java.util.ArrayList;

/**
 * 功能描述:
 * Define S = [s,n] as the string S which consists of n connected strings s. For example, ["abc", 3] ="abcabcabc".
 * <p>
 * On the other hand, we define that string s1 can be obtained from string s2 if we can remove some characters from s2 such that it becomes s1. For example, “abc” can be obtained from “abdbec” based on our definition, but it can not be obtained from “acbbe”.
 * <p>
 * You are given two non-empty strings s1 and s2 (each at most 100 characters long) and two integers 0 ≤ n1 ≤ 10^6 and 1 ≤ n2 ≤ 10^6. Now consider the strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer M such that [S2,M] can be obtained from S1.
 * <p>
 * Example:
 * <p>
 * Input:
 * s1="acb", n1=4   acbacbacbacb
 * s2="ab", n2=2    abab
 * <p>
 * Return:
 * 2
 *
 * @Author chen.yiran
 * @Date 17/3/22.
 */
public class Count_The_Repetitions_466 {

    /**
     * s1="ab" s2="aba"
     * abababababab
     * <p>
     * consider n1&n2 can be very big. it is not wise to concat the string completely.
     * <p>
     * ch[26]
     * find in a recursive way. and when find to end. come to head again.
     *
     * int time=0;
     * while(s2.length>s1.length){
     *     time++
     *     s1+=s1
     * }
     * if time>n1: return 0
     * for i=1->s2.length:
     *      flag=false
     *      for j=1->s1.length:
     *            if i==j:
     *                  flag=true
     *                  s1=substring(j)
     *                  break
     *      if !flag: return 0
     *
     * //1:time  n1/time/n2
     * return (n1/time)/n2;
     *
     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 * n1 < len2 * n2) return 0;

        int time = 1;
        while (s2.length() > s1.length()) {
            time++;
            s1 += s1;
        }

        //niconiconi & nico
        int multi = 1;
        String ss1 = s1;
        outer:
        while (time == 1 && ss1.length() > s2.length()) {
            for (int i = 0; i < s2.length(); i++) {
                boolean flag = false;
                for (int j = 0; j < ss1.length(); j++) {
                    if (s2.charAt(i) == ss1.charAt(j)) {
                        flag = true;
                        ss1 = ss1.substring(j + 1);
                        break;
                    }
                }
                if (!flag) break outer;
            }
            multi++;
        }
        if (multi > 1) multi--;

        if (time > n1) return 0;
        for (int i = 0; i < s2.length(); i++) {
            boolean flag = false;
            for (int j = 0; j < s1.length(); j++) {
                if (s2.charAt(i) == s1.charAt(j)) {
                    flag = true;
                    s1 = s1.substring(j + 1);
                    break;
                }
            }
            if (!flag) return 0;
        }

        return (n1 / time) / n2 * multi;
    }

    public int getMaxRepetitionsAccept(String s1, int n1, String s2, int n2) {
        if (!ableToObtain(s1, s2)) return 0; // check if [s1. ∞] obtains s2
        int cnt = 0, k = -1;
        String s = s1;
        StringBuilder remainBuilder; // record `remain string`
        ArrayList<String> stringList = new ArrayList<>(); // record all the `remain string`
        ArrayList<Integer> countList = new ArrayList<>(); // record matching count from start to the current remain string
        stringList.add(""); // record empty string
        countList.add(0);
        for (int i = 0; i <= n1; i++) {
            remainBuilder = new StringBuilder();
            cnt += getRemain(s, s2, remainBuilder); // get the next remain string, returns the count of matching
            String remain = remainBuilder.toString();
            if ((k = stringList.indexOf(remain)) != -1) break; // if there is a loop, break
            stringList.add(remain); // record the remain string into arraylist
            countList.add(cnt);
            s = remain + s1; // append s1 to make a new string
        }
        // here, k is the beginning of the loop
        if (k == -1) return cnt / n2; // if there is no loop
        int countOfLoop = cnt - countList.get(k), loopLength = stringList.size() - k; // get matching count in the loop, and loop length
        cnt = countList.get(k);
        n1 -= k;
        cnt += countOfLoop * (n1 / loopLength);
        n1 %= loopLength;
        cnt += countList.get(k + n1) - countList.get(k);
        return cnt / n2;
    }

    // check if [s1. ∞] obtains s2
    private boolean ableToObtain(String s1, String s2) {
        boolean[] cnt = new boolean[26];
        for (char c : s1.toCharArray()) cnt[c - 'a'] = true;
        for (char c : s2.toCharArray()) {
            if (!cnt[c - 'a']) return false;
        }
        return true;
    }

    // get remain string after s1 obtains s2, return the matching count
    private int getRemain(String s1, String s2, StringBuilder remain) {
        int cnt = 0, lastMatch = -1, p2 = 0;
        for (int p1 = 0; p1 < s1.length(); p1++) {
            if (s1.charAt(p1) == s2.charAt(p2)) {
                if (++p2 == s2.length()) {
                    p2 = 0;
                    cnt++;
                    lastMatch = p1;
                }
            }
        }
        remain.append(s1.substring(lastMatch + 1));
        return cnt;
    }

    public static void main(String[] args) {
//        System.out.println(new Count_The_Repetitions_466().getMaxRepetitions("lovelivenanjomusicforever", 100000, "nanjo", 10));
//        System.out.println(new Count_The_Repetitions_466().getMaxRepetitions("niconiconi", 99981, "nico", 81));
        // failed in this case
        System.out.println(new Count_The_Repetitions_466().getMaxRepetitions("lovenicoloveliveniconiconiconiniconjcoaaajo", 201641, "lovenanjo", 401));
    }

}
