package enplee.algorithms_JAVA.newcoder.BaiDu2018;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *  https://www.nowcoder.com/questionTerminal/fe8d6a1b88af4ba6b4dbb10972059040
 *  完成括号匹配
 */
public class FinishMatchKouhao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(solution(s));
        }
    }
    public static String solution(String s){
        Deque<Character> stack = new LinkedList<>();
        int left = 0,rignt = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==']'){
                if(stack.isEmpty()) left++;
                else stack.pollLast();
            }else {
                stack.offerLast('[');
            }
        }
        rignt = stack.size();
        String l = "[".repeat(left);
        String r = "]".repeat(rignt);
        return l.toString()+s+r.toString();
    }
}
