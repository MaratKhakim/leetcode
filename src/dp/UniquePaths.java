package dp;

/**
 * Date 18.04.2020.
 *
 * 62. Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * https://leetcode.com/problems/unique-paths/
 */

public class UniquePaths {
    public int uniquePaths(int n, int m) {
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (i == 0 && j== 0)
                    dp[i][j] = 1;
                else if (i == 0 || j==0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i][j-1]+dp[i-1][j];
                }
            }

        return dp[n-1][m-1];
    }
}
