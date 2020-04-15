package array;

/**
 * Date 15.04.2020.
 *
 * 495. Teemo Attacking
 *
 * In LOL world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition.
 * Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking,
 * you need to output the total time that Ashe is in poisoned condition.
 *
 * You may assume that Teemo attacks at the very beginning of a specific time point,
 * and makes Ashe be in poisoned condition immediately.
 *
 * https://leetcode.com/problems/teemo-attacking/
 */

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0)
            return 0;

        int res = 0;
        int st = timeSeries[0];
        int end = st + duration;

        for (int i = 1; i < timeSeries.length; i++) {
            if (end >= timeSeries[i]) {
                end = timeSeries[i] + duration;
            } else {
                res += end - st;
                st = timeSeries[i];
                end = st + duration;
            }
        }

        res += end - st;

        return res;
    }
}
