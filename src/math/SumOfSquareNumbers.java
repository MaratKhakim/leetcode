package math;

/**
 * Date 06.06.2020.
 *
 * 633. Sum of Square Numbers
 *
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a*a + b*b = c.
 *
 * https://leetcode.com/problems/sum-of-square-numbers/
 */

public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);

        while(i <= j) {
            int sum = i*i + j*j;

            if (sum == c)
                return true;

            if (sum < c)
                i++;
            else
                j--;
        }

        return false;
    }
}
