package enplee.algorithms_JAVA.newcoder.Shopee2019;

import java.util.Scanner;

/**
 *  https://www.nowcoder.com/test/question/a71f3bd890734201986cd1e171807d30?pid=17091533&tid=35039902
 *  Shopee的办公室
 */
public class ShopeeDeBanGongShi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int n = sc.nextInt();
            int[][] pos = new int[x+1][y+1];
            for(int i=0;i<n;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                pos[a][b] = 1;
            }
            System.out.println(solution(x+1,y+1,pos));
        }
    }
    public static long solution(int n,int m,int[][] pos){
        long[][] dp = new long[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) dp[i][j] = 1;
                else if(i==0){
                    if(pos[i][j]!=1) dp[i][j] = dp[i][j-1];
                }else if(j==0){
                    if(pos[i][j]!=1) dp[i][j]= dp[i-1][j];
                }else {
                    if(pos[i][j]!=1) dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}
