package enplee.algorithms_JAVA.newcoder.BaiDu2018;

import java.util.Scanner;

/**
 *  https://www.nowcoder.com/questionTerminal/17ba5b5df1fc49ca8d6cf8ea407b1972
 *  最大子序列
 */
public class MaxSubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(solution(s,0));
        }
    }

    public static String solution(String s,int start){
        StringBuilder sb = new StringBuilder();
        if(start>=s.length()) return "";
        if(start==s.length()-1) return sb.append(s.charAt(start)).toString();
        int maxIdx = start;
        for(int i=start;i<s.length();i++){
            if(s.charAt(i)>s.charAt(maxIdx)) maxIdx = i;
        }
        return sb.append(s.charAt(maxIdx)).append(solution(s,maxIdx+1)).toString();
    }
}
