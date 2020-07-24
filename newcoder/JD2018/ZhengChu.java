package enplee.algorithms_JAVA.newcoder.JD2018;
/**
 *  题目描述：被1-n整除的最小数（求1-n的最小公倍数）
 *  输入描述：n
 *  输出描述：最小公倍数k
 *
 *  思路：两种方法
 *          1.对所有数去最小公倍数
 *          2.质因分解法，求出所有数字的最大质因子个数，乘积就是最小公倍数
 *  发散：不仅局限于1-n的最小公倍数 任意数列的最小公倍数也可用此法求解
 *          例：给定任意数组，求解这些数字的最小公倍数
 */

import java.util.Scanner;

public class ZhengChu {

    public static final int MOD = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    public static long solution(int n){
        int[] cnt  = new int[n+5];
        for(int i=1;i<=n;i++){
            int k = i;
            for(int j=2;j*j<=n;j++){
                int s = 0;
                while (k%j==0){
                    s++;
                    k/=j;
                }
                cnt[j] = Math.max(cnt[j],s);
            }
            if(k>1) cnt[k] = Math.max(cnt[k],1);
        }
        long res = 1;
        for(int i=1;i<=n;i++){
            for(int k=0;k<cnt[i];k++){
                res = res*i%MOD;
            }
        }
        return res;
    }
}
