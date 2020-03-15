package string;

/**
 *  12. Integer to Roman
 *
 *  Given an integer, convert it to a roman numeral.
 *  Input is guaranteed to be within the range from 1 to 3999.
 *
 *  https://leetcode.com/problems/integer-to-roman/
 */

public class IntToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        while(num >= 0) {
            while(num >= 1000) {
                sb.append("M");
                num -= 1000;
            }

            if (num >= 900) {
                sb.append("CM");
                num -= 900;
            } else if (num >= 500) {
                sb.append("D");
                num -= 500;

                while(num >= 100) {
                    sb.append("C");
                    num -= 100;
                }
            } else if (num >= 400) {
                sb.append("CD");
                num -= 400;
            } else if (num >= 100) {
                while(num >= 100) {
                    sb.append("C");
                    num -= 100;
                }
            } else if (num >= 90) {
                sb.append("XC");
                num -= 90;
            } else if (num >= 50) {
                sb.append("L");
                num -= 50;

                while(num >= 10) {
                    sb.append("X");
                    num -= 10;
                }
            } else if (num >= 40) {
                sb.append("XL");
                num -= 40;
            } else if (num >= 10) {
                while(num > 9) {
                    sb.append("X");
                    num -= 10;
                }
            } else if (num == 9) {
                sb.append("IX");
                num -= 9;
            } else if (num >= 5) {
                sb.append("V");
                num -= 5;

                while(num-- > 0) {
                    sb.append("I");
                }
            } else if (num == 4) {
                sb.append("IV");
                num -= 4;
            } else {
                while(num-- != 0) {
                    sb.append("I");
                }
            }
        }

        return sb.toString();
    }
}
