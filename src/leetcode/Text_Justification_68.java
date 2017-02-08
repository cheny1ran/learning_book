package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p>
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 *
 * @Author chen.yiran
 * @Date 17/2/7.
 */
public class Text_Justification_68 {

    // logically similar to "63 unique path" dp solution
    // put word this line or next line, and next step will base on this operation
    // but next and next and next word will change this time decision
    // it may be a chain reaction

    class JustArr {
        List<Integer> nums;
        int total;//real total = nums.size()-1+total
        int real;

        JustArr() {
            nums = new ArrayList<>();
            total = 0;
            real = 0;
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();

        if (words.length == 0 || maxWidth == 0) {
            ans.add("");
            return ans;
        }
        List<JustArr> list = new ArrayList<>();
        int cur = 0;
        list.add(new JustArr());

        for (int i = 0; i < words.length; i++) {
            JustArr curJA = list.get(cur);
            if ((maxWidth - curJA.real - 1 > 0 && words[i].length() <= maxWidth - curJA.real - 1) ||
                    (curJA.nums.size() == 0 && words[i].length() <= maxWidth)) {
                curJA.nums.add(i);
                curJA.total += words[i].length();
                curJA.real = curJA.total + curJA.nums.size() - 1;
            } else {
                list.add(new JustArr());
                cur++;
                curJA = list.get(cur);
                curJA.nums.add(i);
                curJA.total += words[i].length();
                curJA.real = curJA.total + curJA.nums.size() - 1;
            }
        }
        /**
         * this block is to even every line words, to make a min difference of sum of line words total length
         */
//        if (list.size() > 1) {
//            for (int i = 1; i < list.size(); i++) {
//                JustArr prev = list.get(i - 1);
//                JustArr curr = list.get(i);
//                int curSub = curr.total > prev.total ? curr.total - prev.total : prev.total - curr.total;
//
//                int plst = prev.nums.get(prev.nums.size() - 1);
//                int lstlen = words[plst].length();
//                int ptotal = prev.total - lstlen;
//                int preal = prev.real - 1 - lstlen;
//                int ctotal = curr.total + lstlen;
//                int creal = curr.real + 1 + lstlen;
//                if (creal > maxWidth) continue;
//
//                int aftSub = creal > preal ? creal - preal : preal - creal;
//                while (aftSub <= curSub && creal <= maxWidth) {
//                    prev.nums.remove(prev.nums.size() - 1);
//                    prev.total = ptotal;
//                    prev.real = preal;
//
//                    curr.nums.add(0, plst);
//                    curr.total = ctotal;
//                    curr.real = creal;
//
//                    curSub = aftSub;
//
//                    plst = prev.nums.get(prev.nums.size() - 1);
//                    lstlen = words[plst].length();
//                    ptotal = prev.total - lstlen;
//                    preal = prev.real - 1 - lstlen;
//                    ctotal = curr.total + lstlen;
//                    creal = curr.real + 1 + lstlen;
//
//                    aftSub = creal > preal ? creal - preal : preal - creal;
//                }
//            }
//        }

        for (int i = 0; i < list.size()-1; i++) {
            JustArr now = list.get(i);
            String str = words[now.nums.get(0)];
            if (now.nums.size() > 1) {
                int cc = 0;
                int leftSpace = maxWidth - now.real;
                int leftPlace = now.nums.size() - 1;
                while (cc < now.nums.size() - 1) {
                    str += " ";
                    int curSpace = leftSpace % leftPlace != 0 ? (leftSpace / leftPlace + 1) : leftSpace / leftPlace;
                    for (int k = 0; k < curSpace; k++) {
                        str += " ";
                    }
                    cc++;
                    leftPlace--;
                    leftSpace -= curSpace;
                    str += words[now.nums.get(cc)];
                }

            } else {
                for (int j = 0; j < maxWidth - now.real; j++) {
                    str += " ";
                }
            }
            ans.add(str);

        }

        JustArr now = list.get(list.size() - 1);
        int cc=0;
        String str= "";
        while (cc < now.nums.size()-1) {
            str+=words[now.nums.get(cc)];
            str+=" ";
            cc++;
        }
        str+=words[now.nums.get(cc)];
        for(int i=0;i<maxWidth - now.real;i++) str+=" ";
        ans.add(str);
        return ans;
    }

    public static void main(String[] args) {
//        String[] words = {"What", "must", "be", "shall", "be."};
//        String[] words = {"a"};
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};

        new Text_Justification_68().fullJustify(words, 14);
    }

}
