package greedy;

/**
 * Date 23.02.2021.
 *
 * 991. Broken Calculator
 *
 * On a broken calculator that has a number showing on its display, we can perform two operations:
 *
 * Double: Multiply the number on the display by 2, or;
 * Decrement: Subtract 1 from the number on the display.
 * Initially, the calculator is displaying the number X.
 *
 * Return the minimum number of operations needed to display the number Y.
 *
 * https://leetcode.com/problems/broken-calculator/
 */

public class BrokenCalculator {
    public int brokenCalc(int x, int y) {
        int res = 0;

        while(x != y) {
            if (x < y) {
                if (y%2 == 0)
                    y /= 2;
                else
                    y += 1;
            } else {
                y++;
            }

            res++;
        }

        return res;
    }
}
