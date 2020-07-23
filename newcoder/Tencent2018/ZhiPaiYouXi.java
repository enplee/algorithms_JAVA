package enplee.algorithms_JAVA.newcoder.Tencent2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  https://www.nowcoder.com/questionTerminal/ebec6fac8a834bf7aed2d5da7c8aa432
 *  纸牌游戏 简单排序
 */
public class ZhiPaiYouXi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr;
            if(n%2==1) {
                arr = new int[n+1];
            }else {
                arr = new int[n];
            }
            for(int i=0;i<n;i++) arr[i] = sc.nextInt();
            System.out.println(solution(arr));
        }
    }
    public static long solution(int[] arr){
        Arrays.sort(arr);
        long res = 0;
        for(int i=0;i<arr.length;i+=2){
            res += arr[i+1]-arr[i];
        }
        return res;
    }
}
