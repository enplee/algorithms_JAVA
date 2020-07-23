package enplee.algorithms_JAVA.newcoder.Tencent2018;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/42e7ff5c5696445ab907caff17fc9e15
 * 安排任务
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
        Arrays.sort(machine, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        Arrays.sort(job, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
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
