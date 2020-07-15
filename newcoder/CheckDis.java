package enplee.algorithms_JAVA.newcoder;

import java.util.Scanner;

public class CheckDis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            String path = sc.next();

            int cnt = 0;
            for(char c:path.toCharArray()){
                if(c=='L') cnt--;
                else cnt++;
            }
            cnt = cnt%4;
            if(cnt<0) cnt+=4;
            if(cnt==0) System.out.println("N");
            else if(cnt==1) System.out.println("E");
            else if(cnt==2) System.out.println("S");
            else System.out.println("W");
        }
    }
}
