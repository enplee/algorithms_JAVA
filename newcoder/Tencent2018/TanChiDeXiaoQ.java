package enplee.algorithms_JAVA.newcoder.Tencent2018;

import java.util.Scanner;

/**
 *  https://www.nowcoder.com/questionTerminal/d732267e73ce4918b61d9e3d0ddd9182
 *  贪吃的小Q  二分法
 */
public class TanChiDeXiaoQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(solution(m,n));
        }
    }
    public static int solution(int m,int n){
        int i = 1,j=m;
        while (i<=j){
            int mid = (i+j)>>1;
            if(check(mid,n,m)) i = mid+1;
            else j=mid-1;
        }
        return j;
    }
    public static boolean check(int eat,int day,int num){
        for(int i =0;i<day;i++){
            if(num<eat) return false;
            num -= eat;
            eat = (int)Math.ceil(eat/2.0);
        }
        return true;
    }
}
