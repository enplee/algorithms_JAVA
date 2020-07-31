package enplee.algorithms_JAVA.newcoder.KeDaXunFei2020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lingqian {
    public static int[] money ={1,5,10,50,100};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int[] num = new int[5];
            for(int i=0;i<5;i++){
                num[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            System.out.println(solution(k,num));
        }
    }
    public static long solution(int k,int[] arr){
        if(k==0) return 0;
        long res = Long.MAX_VALUE;
        for(int i=4;i>=0;i--){
            if(arr[i]>0 && money[i]<=k){
                int[] copyarr = Arrays.copyOf(arr,5);
                copyarr[i]--;
                res = Math.min(solution(k-money[i],copyarr),res);
            }
        }
        return res==Long.MAX_VALUE ? Long.MAX_VALUE:res+1;
    }
}
