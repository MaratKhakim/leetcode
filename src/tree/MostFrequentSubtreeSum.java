package tree;

import java.util.*;

/**
 * Date 13.04.2020.
 *
 * 508. Most Frequent Subtree Sum
 *
 * Given the root of a tree, you are asked to find the most frequent subtree generateSums.
 * The subtree generateSums of a node is defined as the generateSums of all the node values formed by the subtree rooted at that node (including the node itself).
 * So what is the most frequent subtree generateSums value? If there is a tie, return all the values with the highest frequency in any order.
 *
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 */

public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[0];

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        generateSums(root, list);

        for (int num : list)
            map.put(num, map.getOrDefault(num, 0)+1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        pq.addAll(map.keySet());

        list = new ArrayList<>();

        int curr = pq.poll();
        int val = map.get(curr);
        list.add(curr);

        while(!pq.isEmpty()) {
            curr = pq.poll();

            if (map.get(curr) != val)
                break;

            list.add(curr);
        }

        int[] res = new int[list.size()];
        int idx = 0;

        for (int num : list)
            res[idx++] = num;

        return res;
    }

    private int generateSums(TreeNode node, List<Integer> list) {
        if (node == null)
            return 0;

        int sum = node.val;
        sum += generateSums(node.left, list);
        sum += generateSums(node.right, list);
        list.add(sum);

        return sum;
    }
}
