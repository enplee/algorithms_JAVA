package enplee.algorithms_JAVA.newcoder.ZhaoshangYingHang2018;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/604237159872420892bc0fa3eed68d0c
 * 寻找合法的字符串
 */
public class HeFaKuoHao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            solution("",0,0,n,sb);
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }
    public static void solution(String path,int l,int r,int n,StringBuilder sb){
        if(l+r==n*2){
            sb.append(path+",");
        }else {
            if(l<n){
                solution(path+"(",l+1,r,n,sb);
            }
            if(r<l){
                solution(path+")",l,r+1,n,sb);
            }
        }
    }
}
