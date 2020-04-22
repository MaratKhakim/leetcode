package multiarray;

import java.util.List;

/**
 * Date 22.04.2020.
 *
 * Day 14. 30-day-leetcoding-challenge.
 * Leftmost Column with at Least a One
 *
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
 *
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
 *
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 *
 * BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [m, n], which means the matrix is m * n.
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
 */

public class LeftmostColumnWithAtLeastAOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        if (binaryMatrix == null)
            return -1;

        List<Integer> dim = binaryMatrix.dimensions();
        int m = dim.get(0), n = dim.get(1);

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            res = Math.min(res, binarySearch(binaryMatrix, i, n));
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int binarySearch(BinaryMatrix binaryMatrix, int m, int n) {
        int lo = 0, hi = n-1;

        while(lo < hi) {
            int mid = lo + (hi-lo)/2;

            if (binaryMatrix.get(m, mid) == 0) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }

        return binaryMatrix.get(m, lo) == 1 ? lo : Integer.MAX_VALUE;
    }

    // This is the BinaryMatrix's API interface.
    // You should not implement it, or speculate about its implementation

    interface BinaryMatrix {
        public int get(int x, int y);
        public List<Integer> dimensions();
    };
}
