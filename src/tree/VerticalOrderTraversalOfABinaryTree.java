package tree;

import java.util.*;

/**
 * Date 04.05.2020.
 *
 * 987. Vertical Order Traversal of a Binary Tree
 *
 * Given a binary tree, return the vertical order traversal of its nodes values.
 *
 * For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
 *
 * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes,
 * we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
 *
 * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 *
 * Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
 *
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */

public class VerticalOrderTraversalOfABinaryTree {
    int minInd = Integer.MAX_VALUE;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<TreeNode, Element> nodeMap = new HashMap<>();
        traverse(root, 0, 0, nodeMap);

        Map<Integer, List<Element>> elemsMap = new HashMap<>();
        buildElemsMap(root, nodeMap, elemsMap);

        List<List<Integer>> res = new ArrayList<>();

        while (elemsMap.containsKey(minInd)) {
            List<Element> elems = elemsMap.get(minInd++);

            Collections.sort(elems);

            List<Integer> list = new ArrayList<>();

            for (Element elem : elems)
                list.add(elem.node.val);

            res.add(list);
        }

        return res;
    }

    private void buildElemsMap(TreeNode node, Map<TreeNode, Element> nodeMap, Map<Integer, List<Element>> elemsMap) {
        if (node == null)
            return;

        Element elem = nodeMap.get(node);
        List<Element> elems = elemsMap.getOrDefault(elem.x, new ArrayList<>());

        elems.add(elem);

        elemsMap.put(elem.x, elems);

        buildElemsMap(node.left, nodeMap, elemsMap);
        buildElemsMap(node.right, nodeMap, elemsMap);
    }

    private void traverse(TreeNode node, int x, int y, Map<TreeNode, Element> map) {
        if (node == null)
            return;

        minInd = Math.min(minInd, x);
        map.put(node, new Element(node, x, y));
        traverse(node.left, x-1, y+1, map);
        traverse(node.right, x+1, y+1, map);
    }

    class Element implements Comparable<Element> {
        TreeNode node;
        int x;
        int y;

        public Element(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }

        public int compareTo(Element that) {
            if (this.y != that.y)
                return Integer.compare(this.y, that.y);

            if (this.node.val != that.node.val)
                return Integer.compare(this.node.val, that.node.val);

            return 1;
        }
    }
}
