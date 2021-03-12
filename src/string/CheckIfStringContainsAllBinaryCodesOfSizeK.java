package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Date 12.03.2021.
 *
 * 1461. Check If a String Contains All Binary Codes of Size K
 *
 * Given a binary string s and an integer k.
 * Return True if every binary code of length k is a substring of s. Otherwise, return False.
 *
 *
 */

public class CheckIfStringContainsAllBinaryCodesOfSizeK {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = getSet(s, k);
        return set.size() == (1 << k);
    }

    private Set<String> getSet(String s, int k) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i <= s.length()-k; i++) {
            String sub = s.substring(i, i+k);
            set.add(sub);
        }

        return set;
    }
}
