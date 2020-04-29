package graph;

import java.util.*;

/**
 * Date 29.04.2020.
 *
 * 841. Keys and Rooms
 *
 * There are N rooms and you start in room 0.Each room has a distinct number in 0, 1, 2, ..., N-1,
 * and each room may have some keys to access the next room.
 *
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1]
 * where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 *
 * Initially, all the rooms start locked (except for room 0).
 * You can walk back and forth between rooms freely.
 * Return true if and only if you can enter every room.
 *
 * https://leetcode.com/problems/keys-and-rooms/
 */

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        Set<Integer> set = new HashSet<>();
        set.add(0);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()) {
            int idx = queue.poll();
            List<Integer> room = rooms.get(idx);

            for (int num : room) {
                if (set.add(num)) {
                    queue.add(num);
                }
            }
        }

        return set.size() == n;
    }
}
