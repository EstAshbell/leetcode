package com.ashbell.leetcode.simple;

/**
 * @author: xyl
 * @time: 2022/2/8 20:23
 * @description:       LeetCode-1. 两数之和
 */
public class Demo001 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] ints = twoSum(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i++; j < length; j++) {
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }

        }
        return new int[]{};
    }
}
