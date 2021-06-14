package greedy;

import java.util.Arrays;

/**
 * Date 14.06.2021.
 *
 * 1710. Maximum Units on a Truck
 *
 * You are assigned to put some amount of boxes onto one truck.
 * You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
 *      - numberOfBoxesi is the number of boxes of type i.
 *      - numberOfUnitsPerBoxi is the number of units in each box of the type i.
 *
 * You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck.
 * You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
 *
 * Return the maximum total number of units that can be put on the truck.
 *
 * https://leetcode.com/problems/maximum-units-on-a-truck
 */

public class MaximumUnitsonTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        int idx = 0;

        while (idx < boxTypes.length && truckSize > 0) {
            int numberOfUnitsPerBox = truckSize >= boxTypes[idx][0] ? boxTypes[idx][0] : truckSize;
            res += numberOfUnitsPerBox * boxTypes[idx][1];
            truckSize -= boxTypes[idx++][0];
        }

        return res;
    }
}
