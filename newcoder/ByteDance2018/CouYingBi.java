package enplee.algorithms_JAVA.newcoder.ByteDance2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/93bcd2190da34099b98dfc9a9fb77984
 * 凑硬币
 * 题目描述：
 * n1,n2两种硬币，n1硬币不限量，n2硬币只有一枚。问有多少拼出m的方法。
 * 输入输出：
 * n1,n2,m 硬币种类数和凑的金额  长度n1,n2两个序列
 * 输出方法数，MOD=1e9+7
 * 题目分析：
 * 对完全背包和01背包进行综合。 对n1做完全背包处理，对n2做01背包处理。
 * 完全背包和0-1背包公用一个dp数组。
 * 先枚举硬币，再遍历背包数量。注意：完全背包是容量正向遍历，0-1背包是容量逆序遍历。
 */
public class CouYingBi {
    public static final int MOD = 1000000000 + 7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int m = sc.nextInt();
            int[] arr1 = new int[n1];
            for(int i=0;i<n1;i++) arr1[i] = sc.nextInt();
            int[] arr2 = new int[n2];
            for(int i=0;i<n2;i++) arr2[i] = sc.nextInt();
            System.out.println(solution(n1,n2,m,arr1,arr2));
        }
    }
    public static int solution(int n1,int n2,int m,int[] arr1,int[] arr2){
        int[] dp = new int[m+1];
        dp[0] = 1;
        for(int i=0;i<n1;i++){
            for(int j=arr1[i];j<=m;j++){
                dp[j] = (dp[j]+dp[j-arr1[i]])%MOD;
            }
        }
        for(int i=0;i<n2;i++){
            for(int j=m;j>=arr2[i];j--){
                dp[j] = (dp[j]+dp[j-arr2[i]])%MOD;
            }
        }
        return dp[m];
    }
}
