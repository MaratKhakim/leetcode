package dp;

/**
 * Date 23.04.2020.
 *
 * 96. Unique Binary Search Trees
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * https://leetcode.com/problems/unique-binary-search-trees/
 */

public class UniqueBST {
    // F(i, n) = G(i-1) * G(n-i)

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }

        return dp[n];
    }
}
