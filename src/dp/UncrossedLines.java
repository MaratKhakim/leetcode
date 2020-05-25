package dp;

/**
 * Date 25.05.2020.
 *
 * 1035. Uncrossed Lines
 *
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.
 *
 * Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
 *  -  A[i] == B[j];
 *  -  The line we draw does not intersect any other connecting (non-horizontal) line.
 *
 * Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
 * Return the maximum number of connecting lines we can draw in this way.
 *
 *https://leetcode.com/problems/uncrossed-lines/
 */

public class UncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;

        int[][] dp = new int[lenA+1][lenB+1];

        for (int i = 1; i <= lenA; i++) {
            int a = A[i-1];

            for (int j = 1; j <= lenB; j++) {
                int b = B[j-1];

                if (a == b)
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[lenA][lenB];
    }
}
