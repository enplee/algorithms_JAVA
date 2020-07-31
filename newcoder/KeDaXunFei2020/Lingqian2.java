package enplee.algorithms_JAVA.newcoder.KeDaXunFei2020;

import java.util.Scanner;

public class Lingqian2 {
    public static int[] money ={1,5,10,50,100};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int[] num = new int[5];
            for(int i=0;i<5;i++){
                num[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            long res = solution(k,num);
            if(res==-1){
                System.out.println(-1);
            }else {
                System.out.println(res);
            }
        }
    }
    public static long solution(int k,int[] num){
        long res = 0;
        for(int i=4;i>=0;i--){
            if(k==0) break;
            while (k>=money[i] && num[i]>0){
                res++;
                num[i]--;
                k-=money[i];
            }
        }
        return k==0?res:-1;
    }
}
