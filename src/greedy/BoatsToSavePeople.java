package greedy;

import java.util.Arrays;

/**
 * Date 13.01.2021.
 *
 * 881. Boats to Save People
 *
 * The i-th person has weight people[i], and each boat can carry a maximum weight of limit.
 * Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.
 * Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.)
 *
 * https://leetcode.com/problems/boats-to-save-people/
 */

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        int res = people.length;
        Arrays.sort(people);

        int i = 0, j = people.length-1;

        while(i < j) {
            if (people[i]+people[j] <= limit) {
                i++;
                res--;
            }

            j--;
        }

        return res;
    }
}
