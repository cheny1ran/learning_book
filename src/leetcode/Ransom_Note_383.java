package leetcode;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/1/25.
 */
public class Ransom_Note_383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            letters[ch - 97]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (letters[ch - 97] == 0) return false;
            letters[ch - 97]--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('a' - 97);
    }
}
