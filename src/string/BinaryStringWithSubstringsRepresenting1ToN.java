package string;

/**
 * Date 25.03.2020.
 *
 *  1016. Binary String With Substrings Representing 1 To N
 *
 *  Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N,
 *  return true if and only if for every integer X from 1 to N, the binary representation of X is a substring of S.
 *
 *  https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/
 */

public class BinaryStringWithSubstringsRepresenting1ToN {
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            String binary = Integer.toBinaryString(i);

            if (binary.length() > s.length() || !s.contains(binary))
                return false;
        }

        return true;
    }
}
