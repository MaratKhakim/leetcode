package bitmanipulation;

/**
 * Date 27.03.2020.
 *
 *  461. Hamming Distance
 *
 *  The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * https://leetcode.com/problems/hamming-distance/
 */

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int distance = 0;

        int diff = x ^ y;

        while(diff != 0) {
            distance += diff & 1;
            diff = diff >> 1;
        }

        return distance;
    }
}
