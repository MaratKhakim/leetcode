package graph;

import java.util.*;

/**
 * Date 13.05.2020.
 *
 * 133. Clone Graph
 *
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 * https://leetcode.com/problems/clone-graph/
 */

public class CloneGraph {
    public Node cloneGraph(Node node) {

        if (node == null)
            return node;

        Map<Node, Node> map = new HashMap<>();
        map.put(node,  new Node(node.val));

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    queue.add(neighbor);
                    map.put(neighbor, new Node(neighbor.val));
                }

                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
