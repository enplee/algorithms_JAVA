package enplee.algorithms_JAVA.newcoder.WangYi2018;

import java.util.Scanner;

/**
 *  https://www.nowcoder.com/questionTerminal/e1630df2759d43258046ef67514e7b25
 *  字符串碎片
 */
public class ZiFuChuanSuiPian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            if(!s.isEmpty()){
                System.out.format("%.2f",solution(s));
            }
        }
    }
    public static double solution(String s){
        int cnt = 1;
        char flag = s.charAt(0);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=flag){
                cnt++;
                flag = s.charAt(i);
            }
        }
        return 1.0*s.length()/cnt;
    }
}
