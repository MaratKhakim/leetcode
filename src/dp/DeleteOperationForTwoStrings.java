package dp;

/**
 * Date 20.04.2020.
 *
 * 583. Delete Operation for Two Strings
 *
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same,
 * where in each step you can delete one character in either string.
 *
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 */

public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null)
            return 0;

        int len1 = word1.length(), len2 = word2.length();

        int[][] dp = new int[len1+1][len2+1];

        for (int i = 1; i <= len1; i++) {
            char c1 = word1.charAt(i-1);

            for (int j = 1; j <= len2; j++) {
                char c2 = word2.charAt(j-1);

                if (i == 1 || j == 1) {
                    dp[i][j] = c1 == c2 ? Math.max(dp[i-1][j-1], j) : dp[i][j-1]+1;
                } else {
                    dp[i][j] = c1 == c2 ? dp[i-1][j-1] : Math.min(dp[i-1][j], dp[i][j-1])+1;
                }
            }
        }

        return dp[len1-1][len2-1];
    }
}
