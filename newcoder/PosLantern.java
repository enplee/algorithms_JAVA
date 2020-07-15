package enplee.algorithms_JAVA.newcoder;

import java.util.Scanner;

public class PosLantern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            for(int i=0;i<n;i++){
                int len = sc.nextInt();
                String path = sc.next();
                int cnt = 0 , res = 0;
                for(int j =0;j<len;j++){
                    if(path.charAt(j)=='.'){
                        cnt++;
                    }else {
                        res += (int)(cnt/3);
                        if(cnt%3!=0){
                            res += 1;
                            if(cnt%3==1 && j+1<len && path.charAt(j+1)=='.'){
                                j++;
                            }
                        }
                        cnt = 0;
                    }
                }
                if(cnt!=0) res += (int)Math.ceil(cnt/3);
                System.out.println(res);
            }
        }
    }
}
