package hashtable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date 22.04.2021.
 *
 * 554. Brick Wall
 *
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks.
 * The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
 *
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.
 *
 * If your line go through the edge of a brick, then the brick is not considered as crossed.
 * You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 *
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
 *
 * https://leetcode.com/problems/brick-wall/
 */

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = getMap(wall);
        int res = 0;

        for (int key : map.keySet()) {
            res = Math.max(res, map.get(key));
        }

        return wall.size() - res;
    }

    private Map<Integer, Integer> getMap(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();

        for (List<Integer> list : wall) {
            int prev = 0;

            for (int i = 0; i < list.size()-1; i++) {
                int sum = prev + list.get(i);
                map.put(sum, map.getOrDefault(sum, 0)+1);
                prev = sum;
            }
        }

        return map;
    }
}
