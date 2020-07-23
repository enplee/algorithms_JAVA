package enplee.algorithms_JAVA.newcoder.Guanglianda;

import enplee.algorithms_JAVA.leetcode.Solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 *   题目描述：定义一种排序算法，一次只能把一个元素提到序列的开头
 *   给定一个1-n的序列，计算最少操作次数使之有序
 *   输入描述：第一行n,表示序列的长度。接下来一行n个正整数，n个元素。
 *   输出描述：一个整数k，表示需要的次数。
 *
 *   思想：显然任意序列最多需要n次操作就可以有序，那么k<=n
 *        而想让操作次数最少，就是让更少的数字向前提。
 *        我们可以从最大数开始向前去检查相对序列。例如：3,6,5,4,7,8,9;
 *        6,7,8,9是最长的相对序列，那么只需将3,4移动到前边有序即可
 *        假设 相对序列的长度是m  移动次数就是m-n;
 */
public class PaiXu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] num = new int[n];
            for(int i=0;i<n;i++) num[i] = sc.nextInt();
            System.out.println(solution(n,num));
        }
    }
    public static int solution(int n,int[] arr){
        int[] copy_arr = Arrays.copyOf(arr,n);
        Arrays.sort(copy_arr);
        int i = n-1,j = n-1;
        int cnt = 0;
        while (j>=0){
            if(copy_arr[i]==arr[j]){
                i--;
                j--;
                cnt++;
            }
            else j--;
        }
        return n-cnt;
    }
}
