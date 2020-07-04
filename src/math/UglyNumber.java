package math;

/**
 * Date 04.07.2020.
 *
 * 263. Ugly Number
 *
 * Write a program to check whether a given number is an ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * https://leetcode.com/problems/ugly-number/
 */

public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0)
            return false;

        num = divide(num, 2);
        num = divide(num, 3);
        num = divide(num, 5);

        return num == 1;
    }

    public int divide(int num, int divider) {
        while(num%divider == 0)
            num /= divider;

        return num;
    }
}
