package enplee.algorithms_JAVA.newcoder.ZhaoshangYingHang2018;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/3c06901112f6465d859909f2601fccbd
 * 字符串是否由子串拼接
 */
public class CheckSubStringMakeUpString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            String res = solution(s);
            if(res.length()==0){
                System.out.println("false");
            }else {
                System.out.println(res);
            }
        }
    }
    public static String solution (String s){
        int len = s.length();

        for(int i=len/2+1;i>=1;i--){
            if(len%i==0){
                StringBuilder sb = new StringBuilder();
                String substring = s.substring(0, i);
                for(int j=0;j<(len/i);j++) sb.append(substring);
                if(sb.toString().equals(s)) return substring;
            }
        }
        return "";
    }
}
