package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 23.03.2020.
 *
 *  797. All Paths From Source to Target
 *
 *  Given a directed, acyclic graph of N nodes.
 *  Find all possible paths from node 0 to node N-1, and return them in any order.
 *
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.
 * graph[i] is a list of all nodes j for which the edge (i, j) exists.
 *
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);

        paths(graph, 0, list, res);

        return res;
    }

    public void paths(int[][] graph, int idx, List<Integer> list, List<List<Integer>> res) {
        if (idx == graph.length-1) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < graph[idx].length; i++) {
            int curr = graph[idx][i];
            list.add(curr);
            paths(graph, curr, list, res);
            list.remove(list.size()-1);
        }
    }
}
