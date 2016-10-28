package leetcode;

/**
 * 功能描述:
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 * <p/>
 * Example:
 * <p/>
 * nums = [1, 2, 3]
 * target = 4
 * <p/>
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * <p/>
 * Note that different sequences are counted as different combinations.
 * <p/>
 * Therefore the output is 7.
 * <p/>
 * <p/>
 * 错误思路: 构建树
 * 4
 * 1         3
 * 1     2
 * 1   1
 * 2*2*1+2*1+1
 * <p/>
 * but:
 * 10              10              10
 * 3       7       5       5       4       6
 * 3     4
 * <p/>
 *
 * from FreeTymeKiyan https://discuss.leetcode.com/topic/52302/1ms-java-dp-solution-with-detailed-explanation
 * So we know that target is the sum of numbers in the array.
 * Imagine we only need one more number to reach target, this number can be any one in the array, right?
 * So the # of combinations of target,
 * comb[target] = sum(comb[target - nums[i]]), where 0 <= i < nums.length, and target >= nums[i].
 *
 * @Author ewnit
 * @Date 16/10/27.
 */
public class Combination_Sum_IV_377 {


//    >>>>>>>>>>>> wrong!
//    Set set = new HashSet();
//
//    public int combinationSum4(int[] nums, int target) {
//        if (nums.length == 0) return 0;
//        for (int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//        }
//        int ans = 0;
//        List<Integer> list = buildTree(nums, target);
//        for (int i=0;i<list.size();i++) {
//            int mul=1;
//            for(int j=i;j<list.size();j++){
//                mul *= list.get(j);
//            }
//            ans+=mul;
//        }
//        return ans;
//
//    }
//
//    public List<Integer> buildTree(int nums[], int target) {
//        //存储layer->此layer可能的组合数
//        Arrays.sort(nums);
//        List<Integer> list= new ArrayList<>();
//        int big = target;
//        boolean flag = false;
//        int j = nums.length - 1;
//        while (big > nums[0] && !flag) {
//            flag=true;
//            for (int i = j; i >= 0; i--) {
//                int tem = big - nums[i];
//                if (set.contains(tem)) {
//                    int posibility = 2;
//                    if (tem == nums[i]) {
//                        posibility = 1;
//                    }
//                    list.add(posibility);
//                    big = nums[i];
//                    j = i;
//                    flag=false;
//                    break;
//                }
//            }
//        }
//
//        return list;
//    }

// 递归 超时
//    public int combinationSum4(int[] nums, int target) {
//        if(target==0){
//            return 1;
//        }
//        int rst=0;
//        for(int i=0;i<nums.length;i++){
//            if(target>=nums[i]){
//                rst += combinationSum4(nums, target - nums[i]);
//            }
//        }
//        return rst;
//    }

    //   存每个数可分解的方案 like 斐波那契优化
    public int combinationSum4(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        int target = 10;
        System.out.println(new Combination_Sum_IV_377().combinationSum4(nums, target));
    }

}
