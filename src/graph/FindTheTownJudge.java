package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Date 10.05.2020.
 *
 * 997. Find the Town Judge
 *
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *  -   The town judge trusts nobody.
 *  -   Everybody (except for the town judge) trusts the town judge.
 *  -   There is exactly one person that satisfies properties 1 and 2.
 *
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 *
 * https://leetcode.com/problems/find-the-town-judge/
 */

public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        int[] arr = new int[N];
        Set<Integer> set = new HashSet<>();

        for(int[] elem : trust) {
            arr[elem[1]-1]++;
            set.add(elem[0]-1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == N-1 && !set.contains(i))
                return i+1;
        }

        return -1;
    }
}
