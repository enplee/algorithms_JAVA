package enplee.algorithms_JAVA.newcoder.KeDaXunFei2020;

import java.util.Scanner;

public class XianjiaoJuxing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int x1 = sc.nextInt(),y1 = sc.nextInt();
            int x2 = sc.nextInt(),y2 = sc.nextInt();
            int x3 = sc.nextInt(),y3 = sc.nextInt();
            int x4 = sc.nextInt(),y4 = sc.nextByte();
            int minax = Math.min(x1,x2),maxax = Math.max(x1,x2);
            int minay = Math.min(y1,y2),maxay = Math.max(y1,y2);
            int minbx = Math.min(x3,x4),maxbx = Math.max(x3,x4);
            int minby = Math.min(y3,y4),maxby = Math.max(y3,y4);
            if(solution(minax,minay,maxax,maxay,minbx,minby,maxbx,maxby)){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }
    }
    public static boolean solution(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4){
        if(x3>=x2 || x1>=x4 || y1>=y4 || y3>=y2) return false;
        return true;
    }
}
