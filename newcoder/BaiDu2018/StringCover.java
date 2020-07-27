package enplee.algorithms_JAVA.newcoder.BaiDu2018;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 *  https://www.nowcoder.com/questionTerminal/d7ae059c1cee491989412c4fa39d4384
 *  字符覆盖 排序
 */
public class StringCover {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            char[] s = sc.nextLine().toCharArray();
            char[] t = sc.nextLine().toCharArray();
            System.out.println(solution(s,t));
        }
    }
    public static String solution(char[] s,char[] t){
        Arrays.sort(t);
        int i = t.length-1;
        int j = 0;
        while (i>=0 && j<s.length){
            if(s[j]>=t[i]){
                j++;
            }
            else {
                s[j] = t[i];
                j++;
                i--;
            }
        }
        return new String(s);
    }
}
