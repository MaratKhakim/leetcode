package design;

import java.util.*;

/**
 * Date 22.05.2020.
 *
 * 380. Insert Delete GetRandom O(1)
 *
 * Design a data structure that supports all following operations in average O(1) time.
 *
 *  -   insert(val): Inserts an item val to the set if not already present.
 *  -   remove(val): Removes an item val from the set if present.
 *  -   getRandom: Returns a random element from current set of elements.
 *  Each element must have the same probability of being returned.
 *
 *  https://leetcode.com/problems/insert-delete-getrandom-o1/
 */

public class InsertDeleteGetRandom {
    List<Integer> list;
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;

        map.put(val, list.size());
        list.add(val);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        int index = map.get(val);

        if (index != list.size()-1) {
            list.set(index, list.get(list.size()-1));
        }

        map.put(list.get(list.size()-1), index);
        list.remove(list.size()-1);
        map.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());

        return list.get(index);
    }
}

/**
 * Your InsertDeleteGetRandom object will be instantiated and called as such:
 * InsertDeleteGetRandom obj = new InsertDeleteGetRandom();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
