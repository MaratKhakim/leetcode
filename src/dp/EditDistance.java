package dp;

/**
 * Date 31.05.2020.
 *
 * 72. Edit Distance
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *  - Insert a character
 *  - Delete a character
 *  - Replace a character
 *
 *  https://leetcode.com/problems/edit-distance/
 */

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if (m == 0 && n == 0)
            return 0;

        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0]+1;
        }

        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i-1]+1;
        }

        for (int i = 1; i <= m; i++) {
            char a = word1.charAt(i-1);

            for (int j = 1; j <= n; j++) {
                char b = word2.charAt(j-1);

                if (a == b) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int min = Math.min(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = Math.min(dp[i-1][j-1], min)+1;
                }
            }
        }

        return dp[m][n];
    }
}
