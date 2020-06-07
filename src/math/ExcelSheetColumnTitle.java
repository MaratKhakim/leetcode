package math;

/**
 * Date 07.06.2020.
 *
 * 168. Excel Sheet Column Title
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * https://leetcode.com/problems/excel-sheet-column-title/
 */

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            n--;
            char curr = (char) (n%26 + 'A');
            sb.append(curr);
            n /= 26;
        }

        return sb.reverse().toString();
    }
}
