package array;

/**
 * Date 18.06.2020.
 *
 * 275. H-Index II
 *
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer)
 * of a researcher, write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia:
 * "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 *
 * https://leetcode.com/problems/h-index-ii/
 */

public class HIndex2 {
    public int hIndex(int[] citations) {
        int N = citations.length;
        int left = 0, right = citations.length-1;

        while(left <= right) {
            int mid = left + (right-left)/2;

            if (citations[mid] == N-mid)
                return citations[mid];

            if (citations[mid] > N-mid)
                right = mid-1;
            else
                left = mid+1;
        }

        return N-left;
    }
}
