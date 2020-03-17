package twopointers;

/**
 *  11. Container With Most Water
 *
 *  Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 *  n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 *  Find two lines, which together with x-axis forms a container,
 *  such that the container contains the most water.
 *
 *  https://leetcode.com/problems/container-with-most-water/
 */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int i = 0, j = height.length-1;
        int max = 0;
        int minHeight = 0, width = 0;

        while(i < j) {
            width = j - i;

            if (height[i] > height[j]) {
                minHeight = height[j--];
            } else {
                minHeight = height[i++];
            }

            max = Math.max(max, width*minHeight);
        }

        return max;
    }
}
