package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/1/25.
 */
public class Permutations_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            list.add(nums[i]);
        }
        return func(list);
    }

    public List<List<Integer>> func(List<Integer> nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.size() == 1) {
            lists.add(nums);
        }
        for(int i=0;i<nums.size();i++) {

            List<Integer> tem = new ArrayList<>(nums);
            tem.remove(i);

            List<List<Integer>> ll = func(tem);
            for (List<Integer> t : ll) {
                List<Integer> list = new ArrayList<>();
                list.add(nums.get(i));
                list.addAll(t);
                lists.add(list);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists =new Permutations_46().permute(nums);
        for(int i=0;i<lists.size();i++) {
            List<Integer> l = lists.get(i);
            for(int j=0;j<l.size();j++) {
                System.out.print(l.get(j)+" ");
            }
            System.out.println();
        }
    }

}
