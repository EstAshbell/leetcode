package com.ashbell.leetcode.medium.m03;

import java.util.ArrayList;

/**
 * @author: xyl
 * @time: 2022/2/8 20:23
 * @description:       LeetCode-3.无重复字符的最长子串
 */
public class Demo03 {

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        if(s.equals("")){
            return 0;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            ArrayList<Character> tmp = new ArrayList<>();
            for (int j = i; j < chars.length; j++) {
                if(!tmp.contains(chars[j])){
                    tmp.add(chars[j]);
                }else {
                    break;
                }
                if(tmp.size()>max){
                    max = tmp.size();
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }

}
