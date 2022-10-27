package com.ashbell.leetcode.medium.m02;

/**
 * @author: xyl
 * @time: 2022/2/8 20:23
 * @description:       LeetCode-2. 两数相加
 */
public class Demo02 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode finalList = null;
        ListNode first = null;
        //为0时，直接返回
        if(l1.next==null&&l1.val==0){
            return l2;
        }
        if(l2.next==null&&l2.val==0){
            return l1;
        }
        int roundVal = 0;
        while (l1!=null || l2!=null) {
            int l1Val = 0;
            int l2Val = 0;
            if(l1!=null){
                l1Val = l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                l2Val = l2.val;
                l2 = l2.next;
            }
            roundVal += (l1Val + l2Val);

            if (roundVal <= 9) {
                ListNode listNode = new ListNode(roundVal);
                if(finalList!=null && finalList.next==null) {
                    finalList.next = listNode;
                }else{
                    if(finalList!=null) {
                        finalList.next = listNode;
                    }
                }
                finalList = listNode;
                roundVal = 0;
            } else {
                int div = roundVal / 10;
                int mod = roundVal % 10;
                ListNode listNodeDiv = new ListNode(div);
                ListNode listNodeMod = new ListNode(mod,listNodeDiv);

                if(finalList!=null) {
                    finalList.next = listNodeMod;
                }
                finalList = listNodeMod;
                roundVal = listNodeDiv.val;
            }
            if(first==null){
                first = finalList;
            }
        }
        return first;
    }


    public static void main(String[] args) {
//        ListNode listNode13 = new ListNode(3, null);
//        ListNode listNode12 = new ListNode(4, listNode13);
//        ListNode listNode11 = new ListNode(5, listNode12);
//        ListNode listNode10 = new ListNode(2, listNode11);
//
//        System.out.println(listNode11);
//        ListNode listNode23 = new ListNode(4, null);
//        ListNode listNode22 = new ListNode(6, listNode23);
//        ListNode listNode21 = new ListNode(5, listNode22);
//        ListNode listNode20 = new ListNode(2, listNode21);
//
//        System.out.println(listNode11);
//
//        ListNode listNode = addTwoNumbers(listNode10, listNode20);
//        System.out.println(listNode);
        ListNode listNode32 = new ListNode(3);
        ListNode listNode31 = new ListNode(8,listNode32);
        ListNode listNode30 = new ListNode(1,listNode31);

        ListNode listNode41 = new ListNode(1);
        ListNode listNode40 = new ListNode(7,listNode41);
        ListNode listNode2 = addTwoNumbers(listNode30, listNode40);
        System.out.println(listNode2);


    }

}
