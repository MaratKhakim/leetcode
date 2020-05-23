package array;

import java.util.Arrays;

/**
 * Date 23.05.2020.
 *
 * 621. Task Scheduler
 *
 * Given a char array representing tasks CPU need to do.
 * It contains capital letters A to Z where different letters represent different tasks.
 * Tasks could be done without original order. Each task could be done in one interval.
 * For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks,
 * there must be at least n intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 * https://leetcode.com/problems/task-scheduler/
 */

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks)
            freq[task-'A']++;

        Arrays.sort(freq);
        int maxFreq = freq[25];
        int interval = (maxFreq-1) * (n+1);

        for (int i = 0; i < freq.length; i++) {
            interval -= Math.min(maxFreq-1, freq[i]);
        }

        return interval > 0 ? tasks.length + interval : tasks.length;
    }
}
