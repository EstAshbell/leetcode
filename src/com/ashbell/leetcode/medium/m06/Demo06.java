package com.ashbell.leetcode.medium.m06;
/**
 * @author: xyl
 * @time: 2022/11/7 20:23
 * @description:       LeetCode-5.Z 字形变换
 */
public class Demo06 {

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length(), incr = 1;
        StringBuilder finalStr = new StringBuilder();
        for(int k = 0; k < numRows; k++) {
            for(int i = 0, j = 0; j < len; i+=incr, j++) {
                if(i == k) finalStr.append(s.charAt(j));
                if((i % numRows == numRows - 1 && incr > 0) || ((i % (numRows - 1) == 0) && incr < 0)) {
                    incr = -1 * incr;
                }
            }
        }
        return finalStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }


}
