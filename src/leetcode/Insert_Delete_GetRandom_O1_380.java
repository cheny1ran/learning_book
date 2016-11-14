package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * 功能描述:
 * Design a data structure that supports all following operations in average O(1) time.
 * <p/>
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 * <p/>
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * <p/>
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * <p/>
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * <p/>
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * <p/>
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * <p/>
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * <p/>
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * <p/>
 * // Since 1 is the only number in the set, getRandom always return 1.
 * randomSet.getRandom();
 *
 * @Author ewnit
 * @Date 16/11/14.
 */
public class Insert_Delete_GetRandom_O1_380 {
    /**
     * hashset 310ms
     *
     * hashtable+arraylist quickly
     */
    public class RandomizedSet {
        HashSet<Integer> set;
        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            set = new HashSet<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if(set.contains(val)) return false;
            set.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if(!set.contains(val)) return false;
            set.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            List<Integer> list = new ArrayList<>(set);
            Random random = new Random();
            int n = random.nextInt(list.size());
            return list.get(n);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
