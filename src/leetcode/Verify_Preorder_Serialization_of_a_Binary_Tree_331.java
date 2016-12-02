package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述:
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
 * <p/>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * <p/>
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * <p/>
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * <p/>
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 *
 * @Author ewnit
 * @Date 16/11/30.
 */
public class Verify_Preorder_Serialization_of_a_Binary_Tree_331 {

    /**
     * doing from back
     * <p/>
     * make number,#,#->#
     * recursively
     * <p/>
     * #,#,6,#,2,#,#,1,#,#,4,3,9
     * #,#,2,#,#,1,#,#,4,3,9
     * #,#,#,1,#,#,4,3,9 (doing ##4&##1)
     * #,#,#,3,9
     * #,#,9
     * #
     * <p/>
     * if finally -># then return true
     */
    public boolean isValidSerialization(String preorder) {
        String[] chs = preorder.split(",");
        List<String> list = Arrays.asList(chs);
        return recursive(list);
    }

    public boolean recursive(List<String> str) {
        if (str.size() == 1 && str.get(0).equals("#")) return true;
        if (str.size() <= 2) return false;

        List<String> s = new ArrayList<>();
        for (int i = str.size() - 1; i >= 2; i--) {
            if(isNum(str.get(i))||isNum(str.get(i-1))) return false;
            if (str.get(i).equals("#") && str.get(i - 1).equals("#") && isNum(str.get(i-2))) {
                List<String> rec = new ArrayList<>();
                rec.addAll(str.subList(0, i - 2));
                rec.add("#");
                rec.addAll(s);
                return recursive(rec);
            } else s.add(str.get(i));
        }
        return false;
    }

    public boolean isNum(String s) {
        if(s.length()==1&&s.equals("0")) return true;
        boolean begin=true;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(begin&&ch=='0') return false;
            if(begin&&ch>'0'&&ch<='9'){
                begin=false;
                continue;
            }
            if (ch < '0' && ch > 9) return false;

        }
        return true;
    }
    
    /**
     * @Description 
     * 
     * @author  dietpepsi
     * @param
     * @return  https://discuss.leetcode.com/topic/35976/7-lines-easy-java-solution
     * @date    
     */

    public boolean isValidSerializationEasyOne(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node: nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Verify_Preorder_Serialization_of_a_Binary_Tree_331().isValidSerialization("0,0,7,3,#,2,5,#,#,#,7,9,#,#,#,#,#,7,7,#,4,#,4,2,#,#,8,#,#"));
    }

}
