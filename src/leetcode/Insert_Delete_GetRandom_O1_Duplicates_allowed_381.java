package leetcode;

import java.util.LinkedList;
import java.util.Random;

/**
 * 功能描述:
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 * Example:
 * <p>
 * // Init an empty collection.
 * RandomizedCollection collection = new RandomizedCollection();
 * <p>
 * // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 * collection.insert(1);
 * <p>
 * // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 * collection.insert(1);
 * <p>
 * // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 * collection.insert(2);
 * <p>
 * // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 * collection.getRandom();
 * <p>
 * // Removes 1 from the collection, returns true. Collection now contains [1,2].
 * collection.remove(1);
 * <p>
 * // getRandom should return 1 and 2 both equally likely.
 * collection.getRandom();
 *
 * @Author chen.yiran
 * @Date 17/5/22.
 */
public class Insert_Delete_GetRandom_O1_Duplicates_allowed_381 {
    class RandomizedCollection {
        /**
         * Initialize your data structure here.
         */
        LinkedList<Integer> list;
        int size = 0;

        public RandomizedCollection() {
            list = new LinkedList<>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            size++;
            return list.add(val);
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            boolean ans = list.remove(new Integer(val));
            if (ans) size--;
            return ans;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            Random random = new Random();
            int pos = random.nextInt(size);
            return list.get(pos);
        }
    }

    public static void main(String[] args) {
        Insert_Delete_GetRandom_O1_Duplicates_allowed_381 obj = new Insert_Delete_GetRandom_O1_Duplicates_allowed_381();
        Insert_Delete_GetRandom_O1_Duplicates_allowed_381.RandomizedCollection obb = obj.new RandomizedCollection();
        obb.insert(1);
        obb.remove(1);
        obb.insert(1);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

