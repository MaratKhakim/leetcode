package string;

/**
 * Date 09.09.2020.
 *
 * 165. Compare Version Numbers
 *
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 *
 * The . character does not represent a decimal point and is used to separate number sequences.
 *
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 *
 * You may assume the default revision number for each level of a version number to be 0.
 * For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number.
 * Its third and fourth level revision number are both 0.
 *
 * https://leetcode.com/problems/compare-version-numbers/
 */

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int len1 = v1.length, len2 = v2.length;
        int i = 0, j = 0;

        while(i < len1 && j < len2) {
            int num1 = Integer.parseInt(v1[i++]);
            int num2 = Integer.parseInt(v2[j++]);

            if (num1 > num2)
                return 1;
            else if (num1 < num2)
                return -1;
        }

        while(i < len1) {
            if (Integer.parseInt(v1[i++]) > 0)
                return 1;
        }

        while(j < len2) {
            if (Integer.parseInt(v2[j++]) > 0)
                return -1;
        }

        return 0;
    }
}
