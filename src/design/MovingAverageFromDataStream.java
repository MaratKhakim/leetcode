package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date 17.12.2020.
 *
 * 346. Moving Average from Data Stream
 *
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * https://leetcode.com/problems/moving-average-from-data-stream/
 */

public class MovingAverageFromDataStream {
    private Queue<Integer> queue;
    private int size;
    private double sum;

    public MovingAverageFromDataStream(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        queue.add(val);

        if (queue.size() > size) {
            sum -= queue.poll();
        }

        sum += val;

        return sum/queue.size();
    }
}
