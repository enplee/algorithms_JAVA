package enplee.algorithms_JAVA.newcoder.Tencent2018;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/42e7ff5c5696445ab907caff17fc9e15
 * 安排任务
 * 题目要求：尽可能的多执行任务
 * 思路：如果只有一个时间指标，那么我们可以贪心的物尽其用，让能工作时长最长的机器尽可能去执行时间最长的任务；
 *      对于两个评价指标，工作时间和任务难度，贪心法则认为：满足时间的情况下，每次执行用难度低的机器去完成任务
 *      程序设计来说：对于每个任务，先找到所有满足时间尺度的机器，然后选择其中难度最低的
 *                 每个任务和机器仍然按照升序排列，遵循尽可能去完成最高要求的任务
 */
public class AnPaiRenWu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] machine =  new int[n][2];
            int[][] job = new int[m][2];
            for(int i=0;i<n;i++){
                machine[i][0] = sc.nextInt();
                machine[i][1] = sc.nextInt();
            }
            for(int i=0;i<m;i++){
                job[i][0] = sc.nextInt();
                job[i][1] = sc.nextInt();
            }
            long[] res = solution(n,m,machine,job);
            System.out.format("%d %d",res[0],res[1]);
        }
    }
    public static long[] solution(int n,int m,int[][] machine,int[][] job){
        int cnt = 0;
        long cntIncome = 0;
        int[] moLab = new int[101];
        Arrays.sort(machine, (o1, o2) -> {
            if(o1[0]==o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        Arrays.sort(job, (o1, o2) -> {
            if(o1[0]==o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int j = n-1;
        for(int i=m-1;i>=0;i--){
            while (j>=0 && job[i][0]<=machine[j][0]){
                moLab[machine[j][1]]++;
                j--;
            }
            for(int k=job[i][1];k<101;k++){
                if(moLab[k]>0){
                    moLab[k]--;
                    cnt++;
                    cntIncome += job[i][0]*200+job[i][1]*3;
                    break;
                }
            }
        }
        return new long[]{cnt,cntIncome};
    }
}
