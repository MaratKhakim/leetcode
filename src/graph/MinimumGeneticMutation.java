package graph;

import java.util.*;

/**
 * Date 17.02.2022.
 *
 * 433. Minimum Genetic Mutation
 *
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
 *
 * Suppose we need to investigate a mutation from a gene string start to a gene string end where one mutation is defined as one single character changed in the gene string.
 *
 * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
 * There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.
 *
 * Given the two gene strings start and end and the gene bank bank, return the minimum number of mutations needed to mutate from start to end. If there is no such a mutation, return -1.
 *
 * Note that the starting point is assumed to be valid, so it might not be included in the bank.
 *
 * https://leetcode.com/problems/minimum-genetic-mutation/
 */

public class MinimumGeneticMutation {
    public static int minMutation(String start, String end, String[] bank) {
        Set<String> set = getSet(bank);

        if (!set.contains(end))
            return -1;

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int step = 0;

        Set<String> seen = new HashSet<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String curr = queue.poll();

                if (curr.equals(end))
                    return step;

                List<String> mutations = getMutations(curr, set);

                for (String mutation : mutations) {
                    if (!seen.contains(mutation)) {
                        seen.add(mutation);
                        queue.add(mutation);
                    }
                }
            }

            step++;
        }

        return -1;
    }

    private static List<String> getMutations(String curr, Set<String> set) {
        List<String> res = new ArrayList<>();
        char[] arr = curr.toCharArray();

        char[] letters = {'A', 'C', 'G', 'T'};

        for (int i = 0; i < arr.length; i++) {
            char temp = arr[i];

            for (char letter : letters) {
                arr[i] = letter;
                String next = new String(arr);
                if (set.contains(next)) {
                    res.add(next);
                }
            }

            arr[i] = temp;
        }

        return res;
    }

    private static Set<String> getSet(String[] arr) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, arr);
        return set;
    }

    public static void main(String[] args) {
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = {"AAAACCCC","AAACCCCC","AACCCCCC"};

        int minMutation = minMutation(start, end, bank);
        System.out.println(minMutation);
    }
}
