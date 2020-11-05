package array;

/**
 * Date 05.11.2020.
 *
 * 1217. Minimum Cost to Move Chips to The Same Position
 *
 * We have n chips, where the position of the ith chip is position[i].
 * We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:
 *
 *     - position[i] + 2 or position[i] - 2 with cost = 0.
 *     - position[i] + 1 or position[i] - 1 with cost = 1.
 *     - Return the minimum cost needed to move all the chips to the same position.
 *
 * https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
 */

public class MinimumCostToMoveChipsToTheSamePosition {
    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;

        for (int num : position) {
            if (num%2 == 1)
                odd++;
            else
                even++;
        }

        return Math.min(odd, even);
    }
}
