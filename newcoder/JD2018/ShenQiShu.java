package enplee.algorithms_JAVA.newcoder.JD2018;

import java.util.Scanner;

/**
 *  神奇数
 *  https://www.nowcoder.com/questionTerminal/d7b20eadc67f4036973f446520fb6e69
 */
public class ShenQiShu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(solution(l,r));
    }
    public static int solution(int l,int r){
        int res = 0;
        for(int i=l;i<=r;i++){
            if(check(i)) res++;
        }
        return res;
    }
    public static boolean check(int n){
        int[] arr = new int[10];
        int cnt = 0,sum = 0;
        while (n!=0){
            arr[cnt++] = n%10;
            sum += n%10;
            n /= 10;
        }
        if((sum&1)==1) return false;
        else {
            sum = (sum>>1);
            boolean[][] dp = new boolean[cnt][sum+1];
            for(int i=0;i<cnt;i++){
                for(int j=0;j<=sum;j++){
                    if(j==0) dp[i][j] = true;
                    else if(i==0){
                        dp[i][j] = j==arr[i];
                    }else {
                        if(j-arr[i]>=0){
                            dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]];
                        }else dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[cnt-1][sum];
        }
    }
}
