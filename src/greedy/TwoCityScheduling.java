package greedy;

import java.util.Arrays;

/**
 * Date 03.06.2020.
 *
 * 1029. Two City Scheduling
 *
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0],
 * and the cost of flying the i-th person to city B is costs[i][1].
 *
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 *
 * https://leetcode.com/problems/two-city-scheduling/
 */

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[1]-a[0]-b[1]+b[0]);

        int i = 0, j = costs.length-1;
        int sum = 0;

        while(i < j) {
            sum += costs[i++][1]+costs[j--][0];
        }

        return sum;
    }
}
