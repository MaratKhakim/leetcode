package design;

import java.util.Stack;

/**
 * Date 19.05.2020.
 *
 * 901. Online Stock Span
 *
 * Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.
 *
 * The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards)
 * for which the price of the stock was less than or equal to today's price.
 *
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85],
 * then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 *
 * https://leetcode.com/problems/online-stock-span/
 */

public class OnlineStockSpan {
    Stack<Pair> st;

    public OnlineStockSpan() {
        st = new Stack<>();
    }

    public int next(int price) {
        int val = 1;

        while(!st.isEmpty() && st.peek().key <= price) {
            val += st.pop().val;
        }

        st.push(new Pair(price, val));

        return val;
    }

    class Pair {
        int key;
        int val;

        public Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your OnlineStockSpan object will be instantiated and called as such:
 * OnlineStockSpan obj = new OnlineStockSpan();
 * int param_1 = obj.next(price);
 */
