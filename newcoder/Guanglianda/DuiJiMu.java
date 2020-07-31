package enplee.algorithms_JAVA.newcoder.Guanglianda;

import edu.princeton.cs.algs4.In;

import java.util.*;

public class DuiJiMu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            Map<Integer,Integer> parents = new HashMap<>();
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                parents.put(arr[i],arr[i]); //表示现在每个arr[i]的父节点都是自己本身
            }
            System.out.println(solution(n,m,arr,parents));
        }
    }
    public static int solution(int n,int m,int[] arr,Map<Integer,Integer> parents){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((arr[i]&arr[j])==arr[j]){
                    if(parents.get(arr[j])==arr[j]){
                        parents.put(arr[j],arr[i]);
                    }else {
                        parents.put(findRoot(parents,arr[j]),arr[i]);
                    }
                }
            }
        } // 至此，已经可以在不改动的情况下 分成若干堆了 接下来只用考虑会不会发生合并

        int cnt = 0;
        for(int key: parents.keySet()){
            if(key == parents.get(key)) cnt++;
        }
        return cnt;
    }
    public static int findRoot(Map<Integer,Integer> parents,int key){
        int p = parents.get(key);
        if(p==key) return p;
        parents.put(key,findRoot(parents,p)); // 并查集查找树压缩
        return parents.get(key);
    }
}
