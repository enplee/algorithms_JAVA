package enplee.algorithms_JAVA.newcoder;

import java.util.Scanner;

public class CountPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int res = 0;
            if(k==0) res = n*n;
            else{
                for(int j=k+1;j<=n;j++){
                    res = (n/j)*(j-k)+Math.max(0,n%j-k);
                }
            }
            System.out.println(res);
        }
    }
}
