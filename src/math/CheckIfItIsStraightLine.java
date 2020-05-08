package math;

/**
 * Date 08.05.2020.
 *
 * 1232. Check If It Is a Straight Line
 *
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 *
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 */

public class CheckIfItIsStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) {
            return true;
        }

        int x1 = coordinates[1][0] - coordinates[0][0];
        int y1 = coordinates[1][1] - coordinates[0][1];

        for (int i = 2; i < coordinates.length; i++) {
            int x2 = coordinates[i][0] - coordinates[0][0];
            int y2 = coordinates[i][1] - coordinates[0][1];

            if (x1*y2 != x2*y1)
                return false;

            x1 = x2;
            y1 = y2;
        }

        return true;
    }
}
