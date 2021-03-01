package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Date 01.03.2021.
 *
 * 575. Distribute Candies
 *
 * Alice has n candies, where the ith candy is of type candyType[i].
 * Alice noticed that she started to gain weight, so she visited a doctor.
 *
 * The doctor advised Alice to only eat n / 2 of the candies she has (n is always even).
 * Alice likes her candies very much, and she wants to eat the maximum number of different
 * types of candies while still following the doctor's advice.
 *
 * Given the integer array candyType of length n, return the maximum number of different
 * types of candies she can eat if she only eats n / 2 of them.
 *
 * https://leetcode.com/problems/distribute-candies/
 */

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();

        for (int type : candyType)
            set.add(type);

        return Math.min(candyType.length/2, set.size());
    }
}
