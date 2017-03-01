package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/3/1.
 */
public class Keyboard_Row_500 {

    public String[] findWords(String[] words) {
        Character[] c1 = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        Character[] c2 = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        Character[] c3 = {'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        List<Character> lc1 = Arrays.asList(c1);
        List<Character> lc2 = Arrays.asList(c2);
        List<Character> lc3 = Arrays.asList(c3);

        List<String> ans = new ArrayList<>();

        int flag = 0;
        boolean falgg = false;
        for (String word : words) {
            flag = 0;
            falgg = false;
            outer:
            for (int i = 0; i < word.length(); i++) {
                char tem = word.charAt(i);
                if (tem >= 'A' && tem <= 'Z') tem += 32;
                switch (flag) {
                    case 0:
                        if (lc1.contains(tem)) flag = 1;
                        else if (lc2.contains(tem)) flag = 2;
                        else flag = 3;
                        break;
                    case 1:
                        if (lc1.contains(tem)) break;
                        else {
                            falgg = true;
                            break outer;
                        }
                    case 2:
                        if (lc2.contains(tem)) break;
                        else {
                            falgg = true;
                            break outer;
                        }
                    case 3:
                        if (lc3.contains(tem)) break;
                        else {
                            falgg = true;
                            break outer;
                        }
                }
            }
            if (!falgg) ans.add(word);
        }
        String[] aans = new String[ans.size()];
        return ans.toArray(aans);
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] ans = new Keyboard_Row_500().findWords(words);
        for (String str : ans) {
            System.out.println(str);

        }
    }

}
