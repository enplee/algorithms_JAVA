package enplee.algorithms_JAVA.newcoder;

import java.util.Scanner;

public class ErLuoSiFangKuai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] num = new int[n];
            for(int i=0;i<m;i++){
                num[sc.nextInt()-1]++;
            }
            System.out.println(solution(n,m,num));
        }
    }
    public static int solution(int n,int m,int[] num){
        int minH = m;
        for(int i=0;i<n;i++){
            minH = Math.min(num[i],minH);
        }
        return minH*n;
    }

}
