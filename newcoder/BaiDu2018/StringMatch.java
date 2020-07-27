package enplee.algorithms_JAVA.newcoder.BaiDu2018;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *  https://www.nowcoder.com/questionTerminal/6e6ad6338289498da79b7afb60e823b3
 *  字符串匹配
 *  难度简单：切割子串，逐个比较
 */

public class StringMatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            StringBuilder a = new StringBuilder(sc.nextLine());
            StringBuilder b = new StringBuilder(sc.nextLine());
            System.out.println(solution(a,b));
        }
    }
    public static int solution(StringBuilder a,StringBuilder b){
        int lenA = a.length(),lenB = b.length();
        int res = 0;
        Set<String> set = new HashSet<>();
        for(int i=0;i+lenB<=lenA;i++){
            if(b.charAt(0)!='?' && a.charAt(i)!=b.charAt(0)){
                continue;
            }else {
                String sub = a.substring(i,i+lenB);
                if(!set.contains(sub) && check(sub,b.toString())){
                    res++;
                    set.add(sub);
                }
            }
        }
        return res;
    }
    public static boolean check(String a,String b){
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)==b.charAt(i) || b.charAt(i)=='?'){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}
