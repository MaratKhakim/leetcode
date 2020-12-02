package binarysearch;

/**
 * Date 02.12.2020.
 *
 * 240. Search a 2D Matrix II
 *
 * Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
 *  - Integers in each row are sorted in ascending from left to right.
 *  - Integers in each column are sorted in ascending from top to bottom.
 *
 *  https://leetcode.com/problems/search-a-2d-matrix-ii/
 */

public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;

        while(row < matrix.length && col >= 0) {
            int curr = matrix[row][col];

            if (curr == target)
                return true;

            if (curr > target)
                col--;
            else
                row++;

        }

        return false;
    }
}
