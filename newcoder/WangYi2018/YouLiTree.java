package enplee.algorithms_JAVA.newcoder.WangYi2018;

import java.util.Scanner;

/**
 *  https://www.nowcoder.com/questionTerminal/923b9dacf8544e4e83d5e22f5a0e731a
 *  题目描述：给定制定的步数，求出最多能遍历到树上的多少节点
 *  题目分析：最多遍历就是少走回头路，遍历整棵树回头路走的最少的情况就是树深度最深的那条路径只走一次
 *  解题：如果步数<树的深度 直接按照深度走
 *       否则最大深度代价为1,其余节点的代价为2。
 */
public class YouLiTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int l = sc.nextInt();
            int[] parent = new int[n-1];
            for(int i=0;i<n-1;i++) parent[i] = sc.nextInt();
            System.out.println(solution(n,l,parent));
        }
    }
    public static int solution(int n,int l,int[] parent){
        int maxDeep = 1;
        for(int i=0;i<n-1;i++){
            int p = parent[i],temp =1;
            while (p!=0){
                temp++;
                p = parent[p-1];
            }
            maxDeep = Math.max(maxDeep,temp);
        }
        if(l<=maxDeep) return l+1;
        return Math.min(n,1+maxDeep+(l-maxDeep)/2);
    }
}
