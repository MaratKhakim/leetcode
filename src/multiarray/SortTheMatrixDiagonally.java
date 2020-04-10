package multiarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Date 10.04.2020.
 *
 * 1329. Sort the Matrix Diagonally
 *
 * Given a m * n matrix mat of integers, sort it diagonally in ascending order from the top-left to the bottom-right then return the sorted array.
 *
 * https://leetcode.com/problems/sort-the-matrix-diagonally/
 */

public class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for (int j = n-1; j >= 0; j--) {
            sort(mat, 0, j);
        }

        for (int i = 1; i < m; i++) {
            sort(mat, i, 0);
        }

        return mat;
    }

    private void sort(int[][] mat, int i, int j) {
        int row = i;
        int col = j;
        List<Integer> list = new ArrayList<>();

        while(row < mat.length && col < mat[0].length){
            list.add(mat[row++][col++]);
        }

        Collections.sort(list);
        row = i;
        col = j;

        for (int k = 0; k < list.size(); k++)
            mat[row++][col++] = list.get(k);
    }
}
