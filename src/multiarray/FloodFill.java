package multiarray;

/**
 * Date 11.05.2020.
 *
 * 733. Flood Fill
 *
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 *
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 *
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of
 * the same color as the starting pixel,plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel),
 * and so on. Replace the color of all of the aforementioned pixels with the newColor.
 *
 * At the end, return the modified image.
 *
 * https://leetcode.com/problems/flood-fill/
 */

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public void fill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || oldColor == newColor || image[sr][sc] != oldColor)
            return;

        image[sr][sc] = newColor;

        fill(image, sr+1, sc, oldColor, newColor);
        fill(image, sr-1, sc, oldColor, newColor);
        fill(image, sr, sc+1, oldColor, newColor);
        fill(image, sr, sc-1, oldColor, newColor);
    }
}
