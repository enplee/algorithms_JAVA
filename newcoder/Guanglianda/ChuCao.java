package enplee.algorithms_JAVA.newcoder.Guanglianda;
/**
 *  题目描述：一行草地，从左至右i位置的高度为hi。现有m平药剂，每瓶可以让一棵草长高x。
 *          使用m瓶药剂之后，左右小草里最矮的小草的最大值是多少
 *  题目分析：贪心的思想，使用m次药剂，每次给最矮的小草使用。
 *  题目解法：如何给每次最矮的小草使用，也就是每次的最矮小草长高之后要重新获得新的最矮小草
 *          这种需求非常切合优先队列或者是小顶堆的用法，使用小顶堆每次获取最小+x重新入堆
 */
import java.util.PriorityQueue;
import java.util.Scanner;

public class ChuCao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0;i<n;i++){
                pq.offer(sc.nextInt());
            }
            System.out.println(solution(n,m,x,pq));
        }
    }
    public static int solution(int n,int m,int x,PriorityQueue<Integer> pq){
        int temp = 0;
        for(int i=0;i<m;i++){
            temp = pq.poll();
            temp+=x;
            pq.offer(temp);
        }
        return pq.poll();
    }
}

