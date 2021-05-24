package com.wuhan.study.leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3525 👎 0

import sun.security.krb5.Asn1Exception;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// 2021-04-16 16:12:39
public class Lc_5_LongestPalindromicSubstring {
    public static void main(String[] args) {

//        System.out.println("test:"+new String("12345".toCharArray(),0,4-0+1));
        String s="azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc";
//        String s="babad";
//        String s="a";
        String result= new Lc_5_LongestPalindromicSubstring().new Solution().longestPalindrome(s);
        System.out.println("result:"+result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
//            return solve1(s);
//            return solve2(s);
            return solve3(s);
        }

        private String solve2(String s) {
            // f(i,j) = f(i+1,j-1) && p(i) == p(j)
            // base case : if (i<=j) p(i) == p(j)

            char[] chars=s.toCharArray();
//            int mid= chars.length/2;
//            String strMaxLen=subSolve2(chars,mid,mid);
//            for (int i = mid; i > 0; i--) {
//                String strMid=subSolve2(chars,i-1,i-1);
//                strMaxLen=getMaxLenStr(strMaxLen,strMid);
//                String strMidLeft=subSolve2(chars,i-1,i);
//                String strMidRight=subSolve2(chars,i,i+1);
//                strMaxLen=getMaxLenStr(strMaxLen,getMaxLenStr(strMidLeft,strMidRight));
//            }
//            for (int i = mid; i < s.length()-1; i++) {
//                String strMid=subSolve2(chars,i+1,i+1);
//                strMaxLen=getMaxLenStr(strMaxLen,strMid);
//                String strMidLeft=subSolve2(chars,i-1,i);
//                String strMidRight=subSolve2(chars,i,i+1);
//                strMaxLen=getMaxLenStr(strMaxLen,getMaxLenStr(strMidLeft,strMidRight));
//            }
            String strMaxLen=subSolve2(chars,0,0);
            for (int i = 1; i < s.length(); i++) {
                String strMid=subSolve2(chars,i,i);
                strMaxLen=getMaxLenStr(strMaxLen,strMid);
                String strMidLeft=subSolve2(chars,i-1,i);
                String strMidRight=subSolve2(chars,i,i+1);
                strMaxLen=getMaxLenStr(strMaxLen,getMaxLenStr(strMidLeft,strMidRight));
            }
            return strMaxLen;
        }

        private String getMaxLenStr(String strA,String strB){
            return strA.length()>strB.length()?strA:strB;
        }

        private String subSolve2(char[] chars,int left,int right) {
            if (left>=0 && right<chars.length && left <= right && chars[left] == chars[right]) {
                return subSolve2(chars,left-1,right+1);
            }
            return new String(chars,left+1,(right-1)-(left+1)+1);
        }

        private String solve1(String s) {
            if (s.length()==1) {
                return s;
            }
            int n=s.length();
            String ans=String.valueOf(s.charAt(0));
            Set<String> ansSet=new HashSet<>();
            ansSet.add(ans);
            for (int j=0;j<n;j++) {
                for (int i = j+1; i <= n; i++) {
                    String tempstr = s.substring(j, i);
                    if (ansSet.contains(tempstr)) {
                        ans = ans.length() > tempstr.length() ? ans : tempstr;
                    }else if (!ansSet.contains(tempstr) && isPalindrom(tempstr)) {
                        ansSet.add(tempstr);
                        ans = ans.length() > tempstr.length() ? ans : tempstr;
                    }
                }
            }
            return ans;
        }

        private boolean isPalindrom(String str){
            Stack<Character> stack=new Stack<>();
            int n=str.length();
            for (int i = 0; i < n; i++) {
                stack.push(str.charAt(i));
            }
            for (int i = 0; i < n; i++) {
                if (str.charAt(i)!=stack.pop()) {
                    return false;
                }
            }
            return true;
        }


        public String solve3(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        public int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
            }
            return right - left - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}