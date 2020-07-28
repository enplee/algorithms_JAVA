package enplee.algorithms_JAVA.newcoder.WangYi2018;

import edu.princeton.cs.algs4.In;

import javax.xml.parsers.SAXParser;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *  https://www.nowcoder.com/questionTerminal/51e1f9398b724618b567bde3eb5c27cf
 *  重排数列
 */
public class ChongPaiShuLie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t>0){
            t--;
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++) arr[i] = sc.nextInt();
            if(check(n,arr)) System.out.println("Yes");
            else System.out.println("No");
        }
    }
    public static boolean check(int n,int[] arr){
        int cntFour = 0,cntTwo = 0;
        for(int i=0;i<n;i++){
            if(arr[i]%4==0){
                cntFour++;
            }else if (arr[i]%2==0){
                cntTwo++;
            }
        }
        if(cntFour>=(n/2) || cntFour*2+cntTwo>=n) return true;
        return false;
    }
}
