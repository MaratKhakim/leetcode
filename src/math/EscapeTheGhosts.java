package math;

/**
 * Date 15.04.2020.
 *
 * 789. Escape The Ghosts
 *
 * You are playing a simplified Pacman game. You start at the point (0, 0), and your destination is (target[0], target[1]).
 * There are several ghosts on the map, the i-th ghost starts at (ghosts[i][0], ghosts[i][1]).
 *
 * Each turn, you and all ghosts simultaneously *may* move in one of 4 cardinal directions: north, east, west, or south,
 * going from the previous point to a new point 1 unit of distance away.
 *
 * You escape if and only if you can reach the target before any ghost reaches you (for any given moves the ghosts may take.)
 * If you reach any square (including the target) at the same time as a ghost, it doesn't count as an escape.
 *
 * Return True if and only if it is possible to escape.
 *
 * https://leetcode.com/problems/escape-the-ghosts/
 */

public class EscapeTheGhosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        if (ghosts.length == 0)
            return true;

        int way = Math.abs(target[0]) + Math.abs(target[1]);
        int fastest = Integer.MAX_VALUE;

        for (int[] ghost : ghosts) {
            int x = Math.abs(ghost[0] - target[0]);
            int y = Math.abs(ghost[1] - target[1]);
            fastest = Math.min(x+y, fastest);
        }

        return way < fastest;
    }
}
