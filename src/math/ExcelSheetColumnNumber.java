package math;

/**
 * Date 03.05.2020.
 *
 * 171. Excel Sheet Column Number
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * https://leetcode.com/problems/excel-sheet-column-number/
 */

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i)-'A'+1;

            res = res*26 + c;
        }

        return res;
    }
}
