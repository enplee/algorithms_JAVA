package enplee.algorithms_JAVA.newcoder.Shopee2019;
/**
 *  理解错题目了 搞成难的动态规划了
 */

import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class ShiXianTongPeiFu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            StringBuilder sb = new StringBuilder(s2);
            boolean lab = false;
            for(int i=0;i<s2.length();i++){
                if(solution(s1,sb.substring(i,s2.length()),i)) lab=true;
            }
            if(!lab){
                System.out.println(-1+" "+0);
            }
        }
    }
    public static boolean solution(String s1,String s2,int s){
        int len1 = s1.length(),len2 = s2.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        boolean lab = false;
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0 && j==0) dp[i][j] = true;
                else if(i==0){
                    if(s2.charAt(j-1)=='*') dp[i][j] = dp[i][j-1];
                }else if(j==0){
                    if(s1.charAt(i-1)=='*') dp[i][j] = dp[i-1][j];
                }else {
                    if(s1.charAt(i-1)=='*' ){
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    }else {
                        dp[i][j] = dp[i-1][j-1] && s1.charAt(i-1)==s2.charAt(j-1);
                    }
                    if(dp[i][j] && i==len1){
                        System.out.println(s+" "+j);
                        lab = true;
                    }
                }
            }
        }
        return lab;
    }
}
