package enplee.algorithms_JAVA.newcoder.Shopee2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WuLiuZhongZhuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            List<int[]> one = new ArrayList<>();
            List<int[]> zero = new ArrayList<>();
            int n = sc.nextInt();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int num = sc.nextInt();
                    if(num==1) one.add(new int[]{i,j});
                    else zero.add(new int[]{i,j});
                }
            }
            System.out.println(solution(one,zero));
        }
    }
    public static long solution(List<int[]> one,List<int[]> zero){
        if(zero.size()==0) return -1;
        long res = Long.MAX_VALUE;
        for(int[] z:zero){
            long temp = 0;
            for(int[] o:one){
                temp+= Math.abs(o[0]-z[0])+Math.abs(o[1]-z[1]);
            }
            res = Math.min(res,temp);
        }
        return res;
    }
}
