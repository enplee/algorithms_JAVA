package enplee.algorithms_JAVA.newcoder;

import edu.princeton.cs.algs4.In;

import java.util.*;

public class NiuNiuFindJob {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] key = new int[m+n];
            Map<Integer,Integer> map = new HashMap<>();
            int[] A = new int[m];
            for(int i=0;i<n;i++){
                int D = sc.nextInt();
                int V = sc.nextInt();
                map.put(D,Math.max(map.getOrDefault(D,0),V));
                key[i] = D;
            }
            for(int i=0;i<m;i++){
                key[i+n] = sc.nextInt();
                A[i] = key[i+n];
                if(!map.containsKey(key[i+n])) map.put(key[i+n],0);
            }

            Arrays.sort(key);
            int max = 0;
            for(int i=0;i<(m+n);i++){
                max = Math.max(max,map.get(key[i]));
                map.put(key[i],max);
            }

            for(int i=0;i<m;i++){
                System.out.println(map.get(A[i]));
            }
        }
    }
}
