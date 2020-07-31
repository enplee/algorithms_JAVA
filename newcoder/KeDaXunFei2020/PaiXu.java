package enplee.algorithms_JAVA.newcoder.KeDaXunFei2020;

import java.util.Arrays;
import java.util.Scanner;

public class PaiXu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int k = sc.nextInt();
            long[] num = new long[k];
            for(int i=0;i<k;i++){
                num[i] = sc.nextLong();
            }
            solution(num,0,k);
        }
    }
    public static void solution(long[] num,int start,int len){
        if(len==1){
            print(num);
        }else if(len==2){
            if(num[start]>num[start+1]) swap(num,start,start+1);
            print(num);
        }else {
            int l = start+1,r = start+len-1;
            while (l<r){
                while (l<r && num[r]>num[start]) r--;
                while (l<r && num[l]<=num[start]) l++;
                if(l<r) swap(num,l,r);
            }
            if(num[l]<=num[start]) {
                swap(num,start,l);
                print(num);
                solution(num,start,l-start);
                solution(num,l+1,len-(l-start)-1);
            }else {
                print(num);
                solution(num,start+1,len-1);
            }
        }
    }
    public static void swap(long[] num,int i,int j){
        num[i] = num[i]^num[j];
        num[j] = num[i]^num[j];
        num[i] = num[i]^num[j];
    }
    public static void print(long[] num){
        for(int i=0;i<num.length;i++){
            if(i!=num.length-1){
                System.out.print(num[i]+" ");
            }else {
                System.out.println(num[i]);
            }
        }
    }
}
