package com.lorenzhoerb.leetcode.arrstr;

/**
 * 6. Zigzag Conversion
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 */
public class ZigZagConversion {
    public static void main(String[] args) {

        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        int strLength = s.length();
        int gap = strLength - 2;

        int zigCount = strLength / (numRows + gap);
        int part = strLength % (numRows + gap);

        String out = "";
        for (int i = 0; i < numRows; i++) {



            if(i != numRows - 1) out += "\n"; // new line
        }

        return out;
    }
}
