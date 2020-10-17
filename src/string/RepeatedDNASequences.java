package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Date 17.10.2020.
 *
 * 187. Repeated DNA Sequences
 *
 * All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * https://leetcode.com/problems/repeated-dna-sequences/
 */

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();

        if (len < 10)
            return new ArrayList<>();

        Set<String> seen = new HashSet<>();
        Set<String> set = new HashSet<>();
        char[] arr = s.toCharArray();

        for (int i = 9; i < len; i++) {
            String curr = new String(arr, i-9, 10);

            if (!seen.add(curr)) {
                set.add(curr);
            }
        }

        return new ArrayList<>(set);
    }
}
