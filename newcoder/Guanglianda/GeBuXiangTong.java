package enplee.algorithms_JAVA.newcoder.Guanglianda;
import java.util.*;

/**
 *  题目描述：给定一个数字序列，有重复；定义一个操作，对数列中最小的重复元素x:将数列中最左的x删除
 *          将第二左的x *=2；制定若干次操作，知道无重复。返回无重复的数列。
 *  题目分析：操作每回删除一个元素，将另外一个元素放大2倍，相当于每回的操作数组的长度-1
 *          每回需要知道最小重复元素，和位置
 *  题目解法：没有想到更好的方法，直接暴力模拟
 *          用TreeMap去统计元素(key有序) 用list去存储元素
 *          当TreeMap中key的size=list的size 说明没用重复
 *          否则：遍历keys，找到最小重复key，在list中进行操作，同时维护TreeMap
 */

public class GeBuXiangTong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<n;i++){
            int temp = sc.nextInt();
            list.add(temp);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        solution(n,list,map);

    }
    public static void solution(int n,List<Integer> list,Map<Integer,Integer> map){
        while (map.keySet().size()<list.size()){
            for(int key : map.keySet()){
                if(map.get(key)>1){
                    int idx = list.indexOf(key);
                    list.remove(idx);
                    idx = list.indexOf(key);
                    list.set(idx,key*2);
                    int value = map.getOrDefault(key,0);
                    if(value-2<=0){
                        map.remove(key);
                    }else {
                        map.put(key,value-2);
                    }
                    map.put(key*2,map.getOrDefault(key*2,0)+1);
                    break;
                }
            }
        }
        for(int i:list){
            System.out.print(i+" ");
        }
    }
}
