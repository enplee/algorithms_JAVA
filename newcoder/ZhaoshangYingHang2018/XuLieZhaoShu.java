package enplee.algorithms_JAVA.newcoder.ZhaoshangYingHang2018;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/a7d1856a72404ea69fdfb5786d65539c
 * 序列找数
 */
public class XuLieZhaoShu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int sum = 0;
            for(int i=0;i<n;i++){
                sum += sc.nextInt();
            }
            System.out.println((n*(n+1)/2)-sum);
        }
    }
}
