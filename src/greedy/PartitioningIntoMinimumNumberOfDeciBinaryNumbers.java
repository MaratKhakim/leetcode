package greedy;

/**
 * Date 26.05.2021.
 *
 * 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
 *
 * A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros.
 * For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
 *
 * Given a string n that represents a positive decimal integer,
 * return the minimum number of positive deci-binary numbers needed so that they sum up to n.
 *
 * https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 */

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public int minPartitions(String n) {
        int res = 0;

        for (char c : n.toCharArray()) {
            res = Math.max(res, c - '0');
        }

        return res;
    }
}
