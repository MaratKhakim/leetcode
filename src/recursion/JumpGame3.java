package recursion;

/**
 * Date 30.03.2020.
 *
 *  1306. Jump Game III
 *
 *  Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i,
 *  you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 * https://leetcode.com/problems/jump-game-iii/
 */

public class JumpGame3 {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];

        return canReach(arr, start, visited);
    }

    private boolean canReach(int[] arr, int idx, boolean[] visited) {
        if (idx < 0 || idx >= arr.length || visited[idx])
            return false;

        int curr = arr[idx];

        if (curr == 0)
            return true;

        visited[idx] = true;
        boolean canRightReach = canReach(arr, idx+curr, visited);
        boolean canLeftReach = canReach(arr, idx-curr, visited);
        visited[idx] = false;

        return canRightReach || canLeftReach;
    }
}
