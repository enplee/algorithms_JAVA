package enplee.algorithms_JAVA.newcoder;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/d7b20eadc67f4036973f446520fb6e69
 * 丑数
 */
public class ChouShu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    }
    public static int GetUglyNumber_Solution(int index){
        int[] flag = new int[3];
        int[] uglyNum = new int[index];
        uglyNum[0] = 1;
        for(int i=1;i<index;i++){
            int minNum = Math.min(2*uglyNum[flag[0]],
                    Math.min(3*uglyNum[flag[1]],5*uglyNum[flag[2]]));
            uglyNum[i] = minNum;
            if(minNum==2*uglyNum[flag[0]]) flag[0]++;
            if(minNum==3*uglyNum[flag[1]]) flag[1]++;
            if(minNum==5*uglyNum[flag[2]]) flag[2]++;
        }
        return uglyNum[index-1];
    }
}
