package com.ashbell.leetcode.medium.m05;
/**
 * @author: xyl
 * @time: 2022/11/7 20:23
 * @description:       LeetCode-5.最长回文子串
 */
public class Demo05 {

    public static String longestPalindrome0(String s) {
        //暴力求解，时间复杂度太高
        char[] chars = s.toCharArray();
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if(chars.length-i<result.length()-1){
                    break;
                }
                String tmp = s.substring(i, j+1);
                StringBuilder reverse = new StringBuilder(tmp).reverse();
                boolean equals = tmp.equals(reverse.toString());
                boolean b = tmp.length() > result.length();
                if(equals && b) {
                    result = tmp;
                }
            }
        }
        return result;
    }


    public static String longestPalindrome(String s) {
        //动态规划
        int length = s.length();
        char[] chars = s.toCharArray();
        if(length <= 1){
            return s;
        }
        String result = String.valueOf(chars[0]);
        int maxLen = 1;

        boolean[][] array = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            array[i][i] = true;
        }
        //长度从2开始
        for (int i = 2; i <= length; i++) {
            //因为是数组，x从0开始
            for (int x = 0; x < length; x++) {
                //y要大于等于x，否则无法substring(x,y);
                int y = i+x-1;
                if(y>=length){
                    break;
                }
                if(chars[x]!=chars[y]){
                    array[x][y] = false;
                }else{
                    if(y-x <= 2){
                        array[x][y] = true;
                    }else{
                        array[x][y] = array[x+1][y-1];
                    }
                }

                if(array[x][y] && y-x+1>maxLen){
                    maxLen = y-x+1;
                    result = s.substring(x,y+1);
                }

            }
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("aaaa"));
        System.out.println(longestPalindrome("mqizdjrfqtmcsruvvlhdgzfrmxgmmbguroxcbhalzggxhzwfznfkrdwsvzhieqvsrbyedqxwmnvovvnesphgddoikfwuujrhxwcrbttfbmlayrlmpromlzwzrkjkzdvdkpqtbzszrngczvgspzpfnvwuifzjdrmwfadophxscxtbavrhfkadhxrmvlmofbzqshqxazzwjextdpuszwgrxirmmlqitjjpijptmqfbggkwaolpbdglmsvlwdummsrdyjhmgrasrblpjsrpkkgknsucsshjuxunqiouzrdwwooxclutkrujpfebjpoodvhknayilcxjrvnykfjhvsikjabsdnvgguoiyldshbsmsrrlwmkfmyjbbsylhrusubcglaemnurpuvlyyknbqelmkkyamrcmjbncpafchacckhymtasylyfjuribqxsekbjkgzrvzjmjkquxfwopsbjudggnfbuyyfizefgxamocxjgkwxidkgursrcsjwwyeiymoafgyjlhtcdkgrikzzlenqgtdukivvdsalepyvehaklejxxmmoycrtsvzugudwirgywvsxqapxyjedbdhvkkvrxxsgifcldkspgdnjnnzfalaslwqfylmzvbxuscatomnmgarkvuccblpoktlpnazyeazhfucmfpalbujhzbykdgcirnqivdwxnnuznrwdjslwdwgpvjehqcbtjljnxsebtqujhmteknbinrloregnphwhnfidfsqdtaexencwzszlpmxjicoduejjomqzsmrgdgvlrfcrbyfutidkryspmoyzlgfltclmhaeebfbunrwqytzhuxghxkfwtjrfyxavcjwnvbaydjnarrhiyjavlmfsstewtxrcifcllnugldnfyswnsewqwnvbgtatccfeqyjgqbnufwttaokibyrldhoniwqsflvlwnjmffoirzmoxqxunkuepj"));
        System.out.println(longestPalindrome("ac"));

    }


}
