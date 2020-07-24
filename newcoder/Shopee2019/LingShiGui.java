package enplee.algorithms_JAVA.newcoder.Shopee2019;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Scanner;

public class LingShiGui {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] music = new int[n];
            for(int i=0;i<n;i++) music[i] = sc.nextInt();
            System.out.println(solution(n,m, music));
        }
    }
    public static long solution(int n,int m,int[] num){
        int[] Tong = new int[m];
        Arrays.sort(num);
        int i=0;
        for(int k=0;k<(n/m);k++){
            for(int c=m-1;c>=0 && i<n;c--){
                Tong[c]+= num[i++];
                Arrays.sort(Tong);
            }

        }
        int j=n-1;
        for(int k=0;k<(n%m);k++){
            Tong[k] += num[j--];
        }
        Arrays.sort(Tong);
        return Tong[m-1];
    }
}
