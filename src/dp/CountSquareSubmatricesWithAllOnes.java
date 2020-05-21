package dp;

/**
 * Date 21.05.2020.
 *
 * 1277. Count Square Submatrices with All Ones
 *
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 *
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 */

public class CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    count++;

                    if (i > 0 && j > 0) {
                        int min = Math.min(matrix[i-1][j], matrix[i][j-1]);
                        matrix[i][j] = Math.min(matrix[i-1][j-1], min)+1;
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] > 1)
                    count += matrix[i][j]-1;
            }
        }

        return count;
    }
}
