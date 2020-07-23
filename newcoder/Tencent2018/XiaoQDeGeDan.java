package enplee.algorithms_JAVA.newcoder.Tencent2018;

import java.util.Scanner;

/**
 *  https://www.nowcoder.com/questionTerminal/f3ab6fe72af34b71a2fd1d83304cbbb3
 *  小Q的歌单
 */
public class XiaoQDeGeDan {

    static int MOD = 1000000007;
    static long[][] dp = new long[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initDP();
        while (sc.hasNext()){
            int k = sc.nextInt();
            int a = sc.nextInt();
            int x = sc.nextInt();
            int b = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(solution(k,a,x,b,y));
        }
    }

    public static void initDP(){
        for(int i=0;i<=100;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || i==j) dp[i][j] = 1;
                else dp[i][j] = (dp[i-1][j]+dp[i-1][j-1])%MOD;
            }
//            System.out.println(Arrays.toString(dp[i]));
        }
    }

    public static long solution(int k,int a,int x,int b,int y){
        long res = 0;
        for(int i=0;i<=x;i++){
            for(int j=0;j<=y;j++){
                if(i*a+j*b>k) break;
                else if(i*a+j*b==k){
                    res = (res + dp[x][i]*dp[y][j])%MOD;
                }
            }
        }
        return res;
    }

}
