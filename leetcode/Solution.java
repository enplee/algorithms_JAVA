package enplee.algorithms_JAVA.leetcode;

import java.util.*;
import java.util.List;

import edu.princeton.cs.algs4.In;
import enplee.algorithms_JAVA.leetcode.*;
/**
 * @author lee
 * 内容：leetcode的相关代码java版本
 */

public class Solution {

    public static void main(String[] args) {
        System.out.println(-5%4);
    }

    public int[][] reconstructQueue(int[][] people) {
        /*
        *   406. 根据身高重建队列 贪心
        */
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o1[1] ? o1[1]-o2[1] :o2[0]-o1[0];
            }
        });
        List<int[]> queue = new LinkedList<>();
        for(int[] i : people){
            queue.add(i[1],i);
        }
        return  queue.toArray(new int[people.length][2]);
    }
    public int coinChange(int[] coins, int amount) {
        /*
        *   322. 零钱兑换 01背包
        */
        int maxN = amount+1;
        Arrays.sort(coins);
        int[] dp = new int[maxN];
        Arrays.fill(dp,maxN);
        dp[0] = 0;
        for(int i=1;i<maxN;i++){
            for(int coin : coins){
                if(i-coin>=0){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }else{
                    break;
                }
            }
        }
        return dp[amount];
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        /*
         *  347. 前 K 个高频元素  优先队列
         */
        Map<Integer,Integer> count = new HashMap<>();
        for(int i:nums){
            count.put(i,count.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));
        for(int i : count.keySet()){
            heap.add(i);
            if(heap.size()>k){
                heap.poll();
            }
        }
        List<Integer> list = new LinkedList<>();
        while (!heap.isEmpty()){
            list.add(heap.poll());
        }
        return list;
    }
    public String decodeString(String s) {
        /*
         *   394 字符串解码 递归解法
         */
        String res = "";
        int num = 0 , i = 0;
        while (i<s.length()){
            if(Character.isAlphabetic(s.charAt(i))){
                res += s.charAt(i);
            }else if(Character.isDigit(s.charAt(i))){
                num = num*10 + ((int)s.charAt(i)-48);
            }else if(s.charAt(i)=='['){
                int start = i,cnt = 1;
                while (cnt!=0){
                    i++;
                    if(s.charAt(i)=='['){
                        cnt++;
                    }
                    if(s.charAt(i)==']'){
                        cnt--;
                    }
                    String innerS = decodeString(s.substring(start,i));
                    res += new String(new char[num]).replace("\0",innerS);
                    num = 0;
                }
            }
            i++;
        }
        return res;
    }
    public String decodeString_2(String s){
        /*
        *   394 字符串解码 栈解法
        */
         Deque<String> resStack = new LinkedList<>();
         Deque<Integer> numStack = new LinkedList<>();
         StringBuilder res = new StringBuilder();
         int num = 0;
         for(Character c :s.toCharArray()){
             if(Character.isAlphabetic(c)){
                 res.append(c);
             }else if(Character.isDigit(c)){
                 num = num*10 + Integer.parseInt(c+"");  //将字符转化成数字
             }else if(c=='['){
                 numStack.push(num);
                 resStack.push(res.toString());
                 num = 0;
                 res = new StringBuilder();
             }else if(c==']'){
                 int cur_num = numStack.pop();
                 StringBuilder temp = new StringBuilder();
                 for(int i=0;i<cur_num;i++) temp.append(res);
                 res = new StringBuilder(resStack.pop()+temp);
             }
         }
         return res.toString();
    }
    public boolean canPartition(int[] nums) {
        /*
         *   416 分割等和子集 01背包
         */
        if(nums.length==0 || (sum(nums)&1)==1) return false;
        int half = sum(nums)/2;
        boolean[] dp = new boolean[half+1];
        dp[0] = true;
        for(int num : nums){//前n个背包可以拿取得成都
            for(int i=half;i>=num;i--){//反向便利保证不会影响后续的选择 使用二维写法就不会这样
                if(dp[i-num]) dp[i] = true;
            }
        }
        return dp[half];
    }
    public int sum(int[] nums){
        int sum = 0;
        for(int i:nums) sum+=i;
        return sum;
    }
    public int countSubstrings(String s) {
        /*
         *   647 回文子串个数 扫描解法
         */
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            int l=i,r=i;
            while (l>=0 && r<s.length() && (s.charAt(l)==s.charAt(i))){
                cnt++;
                l--;
                r++;
            }
        }
        for(int i=0;i<s.length()-1;i++){
            int l=i,r=i+1;
            while (l>=0 && r<s.length() &&(s.charAt(l)==s.charAt(r))){
                cnt++;
                l--;
                r++;
            }
        }
        return cnt;
    }
    public int scanS(String s,int flag){//代码复用
        int cnt = 0;
        for(int i=0;i<s.length()-flag;i++){
            int l=i,r=i+flag;
            while (l>=0 && r<s.length() && (s.charAt(l)==s.charAt(r))){
                cnt++;
                l--;
                r++;
            }
        }
        return cnt;
    }
    public int[] dailyTemperatures(int[] T) {
        /*
         *   739 每日温度 单调栈
         */
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[T.length];
        for(int i=0;i<T.length;i++){
            while (!stack.isEmpty() && T[i]>T[stack.getFirst()]){
                int temp = stack.pop();
                res[temp] = i-temp;
            }
            stack.push(i);
        }
        return res;
    }
    public List<Integer> findAnagrams(String s, String p) {
        /*
         *   438 匹配字符串中所有的字母异位置词 滑动窗口 解法一 效率不高
         */
        List<Integer> res = new LinkedList<>();
        if(s.length()<p.length()) return res;

        Map<Character,Integer> stringMap = new HashMap<>();
        Map<Character,Integer> windowMap = new HashMap<>();
        int deff = p.length(),sLen = s.length(),pLen = p.length();

        for(char c:p.toCharArray()){
            stringMap.put(c,stringMap.getOrDefault(c,0)+1);
            windowMap.put(c,0);
        }
        for(int i=0;i<pLen;i++){
            if(stringMap.containsKey(s.charAt(i))){
                if(windowMap.get(s.charAt(i))<stringMap.get(s.charAt(i))){
                    deff--;
                }
                windowMap.put(s.charAt(i),windowMap.getOrDefault(s.charAt(i),0)+1);
            }
        }
        if(deff == 0) res.add(0);
        for(int l=0,r=pLen;r<pLen-1;l++,r++){
            if(stringMap.containsKey(s.charAt(r+1))){
                if(windowMap.get(s.charAt(r+1))<stringMap.get(s.charAt(r+1))){
                    deff --;
                }
                windowMap.put(s.charAt(r+1),windowMap.getOrDefault(s.charAt(r+1),0)+1);
            }
            if(stringMap.containsKey(s.charAt(l))){
                if(windowMap.get(s.charAt(l))<=stringMap.get(s.charAt(l))){
                    deff ++;
                }
                windowMap.put(s.charAt(l),windowMap.getOrDefault(s.charAt(l),0)-1);
            }
            if(deff==0) res.add(l+1);
        }
        return res;
    }
    public List<Integer> findAnagrams_2(String s, String p) {
        /*
         *   438 匹配字符串中所有的字母异位置词 滑动窗口 解法2 利用数组充当map
         */
        List<Integer> res = new LinkedList<>();
        int[] stringMap = new int[128];
        int[] windowMap = new int[128];
        for(char i : p.toCharArray()){
            stringMap[i]++;
        }
        int left = 0 , right = 0;
        while (right<s.length()){
            char c = s.charAt(right);
            windowMap[c]++;
            right++;
            while (windowMap[c]>stringMap[c]){
                windowMap[s.charAt(left)]--;
                left++;
            }
            if((right-left)==p.length()){
                res.add(left);
            }
        }
        return res;
    }
    public void compareStringToStringBuilder(){
        StringBuilder sb = new StringBuilder();
        long num1 = Runtime.getRuntime().freeMemory();
        long tim1 = System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            sb.append(i);
        }
        long num2 = Runtime.getRuntime().freeMemory();
        long tim2 = System.currentTimeMillis();
        System.out.format("sb内存消耗了%d: 时间消耗了: %d",num1-num2,tim2-tim1);
        String s = "";
        long num3 = Runtime.getRuntime().freeMemory();
        long tim3 = System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            s += i;
        }
        long num4 = Runtime.getRuntime().freeMemory();
        long tim4 = System.currentTimeMillis();
        System.out.format("sb内存消耗了%d: 时间消耗了: %d",num3-num4,tim4-tim3);
    }
    public int leastInterval(char[] tasks, int n) {
        /*
         *   621. 任务调度器 设计思想
         */
        int[] charMap = new int[26];
        for(char c : tasks){
            charMap[c-'A']++;
        }
        Arrays.sort(charMap);
        int left = (charMap[25]-1)*n;
        int max_contain = charMap[25]-1;
        for(int i=24;i>=0&&charMap[i]>0;i--){
            left -= Math.min(max_contain,charMap[i]);
        }
        return left>0 ? tasks.length+left : tasks.length;
    }
    public boolean checkInclusion(String s1, String s2) {
        /*
         *   567. 字符串的排列 滑动窗口
         */
        int[] stringMap = new int[128];
        int[] windowMap = new int[128];
        for(char c : s1.toCharArray()){
            stringMap[c]++;
        }
        int left = 0, right = 0;
        while(right<s2.length()){
            char c = s2.charAt(right);
            windowMap[c]++;
            right++;
            while (windowMap[c]>stringMap[c]){
                windowMap[s2.charAt(left)]--;
                left++;
            }
            if(right-left==s1.length()) return true;
        }
        return false;
    }

    int[][] dirt = new int[][]{new int[]{0,0,1},new int[]{0,0,-1},
                               new int[]{0,1,0},new int[]{0,-1,0},
                               new int[]{1,0,0},new int[]{-1,0,0}};

    int N;
    int[] visited;
    public int maxEnergy(int[] Energy,int N){
        int[] maxInfo = getMaxEnergyPosition(Energy,N);
        visited = new int[N*N*N];
        Arrays.fill(visited,-1);
        int res = dp(maxInfo[0],maxInfo[1],maxInfo[2],N,Energy);
        return res;
    }
    public int dp(int x,int y,int z,int N,int[] Energy){
        int res = Energy[deCode(x,y,z,N)];
        int maxValue = 0;
        for(int[] dir : dirt){
            int xNew = x+dir[0], yNew = y+dir[1], zNew = z+dir[2];
            if(xNew>=0 && yNew>=0 && zNew>=0 && xNew<N && yNew<N && zNew<N
                && Energy[deCode(x,y,z,N)]>Energy[deCode(xNew,yNew,zNew,N)]){
                if(visited[deCode(xNew,yNew,zNew,N)]!=-1){
                    maxValue = Math.max(maxValue,visited[deCode(xNew,yNew,zNew,N)]);
                }else {
                    maxValue = Math.max(maxValue,dp(xNew,yNew,zNew,N,Energy));
                }
            }
        }
        res += maxValue;
        visited[deCode(x,y,z,N)]=res;
        return res;
    }
    public int deCode(int x,int y,int z,int N){
        return x*N*N+y*N+z;
    }
    public int[] getMaxEnergyPosition(int[] Energy,int N){
        int[] res = new int[3];
        int maxE = Energy[0];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    if(Energy[deCode(i,j,k,N)]>maxE){
                        maxE = Energy[deCode(i,j,k,N)];
                        res = new int[]{i,j,k};
                    }
                }
            }
        }
        return res;
    }
    public int findTargetSumWays(int[] nums, int S) {
        /*
            494. 目标和 位运算写法 超时
         */
        int res = 0;
        for(long i=0;i<(1<<nums.length);i++){
            long sum = 0;
            for(int j=0;j<nums.length;j++){
                if((i&(1<<j))==1){
                    sum += nums[j];
                }else {
                    sum -= nums[j];
                }
            }
            if(sum==S) res++;
        }
        return res;
    }
    public int findTargetSumWays2(int[] nums, int S){
        /*
            494. 目标和 dp方法  S = Sum_p - Sum_n => S + 2*Sum_n = Sum
         */
        if(sum(nums)<S || ((sum(nums)-S)%2)==1){
            return 0;
        }
        int target = (sum(nums)-S)>>1;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int num : nums){
            for(int j=target;j>num-1;j--){
                dp[j] += dp[j-num];
            }
        }
        return dp[target];
    }
    public int findTargetSumWays3(int[] nums,int S){
        List<Map<Integer,Integer>> remenberMap = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            Map<Integer,Integer> temp = new HashMap<>();
            remenberMap.add(temp);
        }
        return dfsTargetSumWay(nums,S,remenberMap,nums.length-1);
    }
    private int dfsTargetSumWay(int[] nums,int S,List<Map<Integer,Integer>> map,int i){
        if(i==0) return nums[i]==S || -nums[i]==S ? 1:0;
        if(map.get(i).getOrDefault(S,0)>0) return map.get(i).get(S);
        int res = dfsTargetSumWay(nums,S+nums[i],map,i-1)+dfsTargetSumWay(nums,S-nums[i],map,i+1);
        map.get(i).put(S,res);
        return res;
    }
    public static List<Integer> findMaxInnerSum(int[] nums){
        int left=0,right=0;
        List<Integer> res = new LinkedList<>();
        int sum = 0,max = Integer.MIN_VALUE;
        while (right<nums.length){
            sum += nums[right];
            if(sum==max && !res.contains(left)){
                res.add(left);
            }else if(sum>max){
                max = sum;
                res = new LinkedList<>();
                res.add(left);
            }
            right++;
            while (sum<=0 && left<right){
                sum -= nums[left];
                left++;
            }
        }
        return res;
    }
    public void flatten(TreeNode root) {
        if(root==null) return;
        flattenTree(root);
    }
    private TreeNode flattenTree(TreeNode root){
        if (root.left==null && root.right==null) return root;
        else if(root.left==null){
            TreeNode right = flattenTree(root.right);
            root.right = right;
        }else if(root.right==null){
            TreeNode left = flattenTree(root.left);
            root.right = left;
            root.left = null;
        }else {
            TreeNode right = flattenTree(root.right);
            TreeNode left = flattenTree(root.left);
            TreeNode temp = left;
            while (temp.right!=null){
                temp = temp.right;
            }
            root.left = null;
            root.right = left;
            temp.right = right;
        }
        return root;
    }
    private TreeNode flattenTree1(TreeNode root){
        if(root==null) return null;
        if(root.left!=null){
            TreeNode temp = root.left;
            while (temp.right!=null) temp = temp.right;
            temp.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        root.right=flattenTree1(root.right);
        return root;
    }
    public int[] shuffle(int[] nums, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<2*n-1;i++) sb.append(0);
        for(int i=0;i<2*n-1;i++){
            int temp = countEndpos(i,n);
            int changeVal = nums[i];
            if(sb.charAt(i)!='1'){
                sb.setCharAt(i,'1');
                while(temp!=i){
                    sb.setCharAt(temp,'1');
                    int tempVal = nums[temp];
                    nums[temp] = changeVal;
                    changeVal = tempVal;
                    temp = countEndpos(temp,n);
                }
                nums[i] = changeVal;
            }
        }
        return nums;
    }
    private int countEndpos(int i,int n){
        if(0<=i && i<n){
            return i*2;
        }else{
            return (i-n)*2+1;
        }
    }
    public int[] getStrongest(int[] arr, int k) {
        int[] res = new int[arr.length];
        return res;
    }
    private boolean cmp(int mid,int a,int b){
        if(Math.abs(a-mid)>Math.abs(b-mid)) return true;
        if(Math.abs(a-mid)==Math.abs(b-mid) && a>b) return true;
        return false;
    }
    public int pathSum(TreeNode root, int sum){
        Map<Integer,Integer> prixMap = new HashMap<>();
        prixMap.put(0,1);
        return count(root,sum,0,prixMap);
    }
    private int count(TreeNode node,int sum,int pathSum,Map<Integer,Integer> prixMap){
        if(node==null) return 0;
        pathSum = pathSum+node.val;
        int prix = pathSum - sum;
        int res = prixMap.getOrDefault(prix,0);
        prixMap.put(pathSum,prixMap.getOrDefault(pathSum,0));
        res += count(node.left,sum,pathSum,prixMap);
        res += count(node.right,sum,pathSum,prixMap);
        prixMap.put(pathSum,prixMap.get(pathSum)-1);
        return res;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q);
    }
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = dfs(root.left,p,q);
        TreeNode right = dfs(root.right,p,q);
        if(left!=null && right!=null) return root;
        return left == null ?  right : left;
    }
    public int maxPathSum(TreeNode root) {
        /*
            124 hard 树的最大路径
         */
        cntPathSum(root);
        return res;

    }
    int res = Integer.MIN_VALUE;
    private int cntPathSum(TreeNode root){
        if(root==null) return 0;
        int left = cntPathSum(root.left);
        int right = cntPathSum(root.right);
        res = Math.max(left+right+root.val,res);
        return Math.max(Math.max(left, right) + root.val, 0);
    }
    public static double cntDistance(double[] o1,double[] o2){
        return Math.sqrt(Math.pow((o1[0]-o2[0]),2)+Math.pow((o1[1]-o2[1]),2));
    }
    public int longestPalindromeSubseq(String s) {

        int len = s.length();
        if(len==0) return 0;
        int[][] dp = new int[len][len];
        for(int i=0;i<len;i++)    dp[i][i] = 1;

        for(int i=len-1;i>=0;i--){
            for(int j=i+1;j<len;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(i+1==j) dp[i][j] = 2;
                    else dp[i][j] = dp[i+1][j-1]+2;
                }else if(i+1 < j){
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<len-2;i++){
            int l=i+1,r=len-1;
            while (l<r){
                int s = nums[i]+nums[l]+nums[r];
                if(Math.abs(s-target)>Math.abs(res-target)) res= s;
                if(s>target) r--;
                else if(s<target) l++;
                else return target;
            }
        }
        return res;
    }
    public int firstMissingPositive(int[] nums) {
        /*
         *  41. 缺失的第一个正整数 类归巢
         */
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]>=1 && nums[i]<=len ){
                while (nums[i]>=1 && nums[i]<=len && nums[nums[i]-1] != nums[i]){
                    swap(nums,nums[i]-1,i);
                }
            }
        }
        for(int i=0;i<len;i++){
            if(nums[i] == i+1) continue;
            else return i+1;
        }
        return len+1;
    }
    public void swap(int[] nums,int ind1,int ind2){
        nums[ind1] = nums[ind1]^nums[ind2];
        nums[ind2] = nums[ind1]^nums[ind2];
        nums[ind1] = nums[ind1]^nums[ind2];
    }
    public static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int i = 0,j = nums.length-1;
        while (i<=j){
            if(nums[i]+nums[j]>target){
                j--;
            }else {
                res += (1*(Math.pow(2,(j-i))));
                i++;
            }
        }
        return (int)res%(1000000000+7);
    }
    public boolean canArrange(int[] arr, int k) {
        /*
         *  5449. 检查数组对是否可以被 k 整除  整除的问题考虑取余的思想  类数学
         *  刚开始考虑搜索，能解决超时，剪枝仍然超时
         */
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i]%k;
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        for(int i=0;i<(int)k/2;i++){
            if(map.getOrDefault(i,0)!=map.getOrDefault(k-i,0)){
                return false;
            }
        }
        if(k%2==0 && map.getOrDefault((int)k/2,0)%2==1) return false;
        return true;
    }
    public int findLength(int[] A, int[] B) {
        /*
         * 718. 最长重复子数组 典型动态规划
         */
        int[] dp = new int[A.length];
        int res = 0;
        for(int i=0;i<B.length;i++){
            for(int j=A.length-1;j>=0;j--){
                if(A[j]==B[i]){
                    if(j==0 || i==0) dp[j] = 1;
                    else dp[j] = dp[j-1]+1;
                    res = Math.max(res,dp[j]);
                }else {
                    dp[j] = 0;
                }
            }
        }
        return res;
    }
    public List<String> topKFrequent(String[] words, int k) {
        /*
         *  692. 前K个高频单词
         */
        Map<String,Integer> map  = new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,1)+1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
                (o1,o2)-> map.get(o1).equals(map.get(o2)) ?
                        o2.compareTo(o1):map.get(o1)-map.get(o2)
        );
        for(String key : map.keySet()){
            /*if(pq.size()<k){
                pq.offer(key);
            }else {
                String top = pq.peek();
                if(map.get(key)>map.get(top) || (map.get(key)==map.get(top) && key.compareTo(top)<0)){
                    pq.poll();
                    pq.offer(key);
                }
            }*/
            pq.offer(key);
            if(pq.size()>k) pq.poll();
        }
        List<String> res = new LinkedList<>();
        for(int i=0;i<k;i++){
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1,o2)-> o1[0]-o2[0]
        );
        int n = matrix.length;
        for(int i=0;i<n;i++){
            pq.offer(new int[]{matrix[i][0],i,0});
        }
        int[] item = null;
        for(int cnt=0;cnt<k;cnt++){
            item = pq.poll();
            if(item[2]<n-1) pq.offer(new int[]{matrix[item[1]][item[2]+1],item[1],item[2]+1});
        }
        return item[0];
    }
    public int longestValidParentheses(String s) {
        /*
         * 32. 最长有效括号
         * 思路1: 指针
         */
        int left = 0,right = 0,res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') left++;
            else right++;
            if(left==right) res = Math.max(res,left);
            else if(right>left){
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right =0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='(') left++;
            else right++;
            if(left==right) res = Math.max(res,left);
            else if(left>right){
                left = 0;
                right = 0;
            }
        }
        return res;
    }
    public int longestValidParentheses_2(String s){
        /*
         *  32. 最长有效括号
         *  思路2: 动态规划
         *        1.状态定义：dp[i]是以i位置结尾的合法括号
         *        2.状态转移：s[i]: if '(' dp[i]=0  if ')': 1.s[i-1]=='(' dp[i] = dp[i-2]+2
         *                                                2.s[i-1]==')' if s[i-1-dp[i-1]]=='(' dp[i] = dp[i-1]+2+next
         *        3.初始状态：s[0]=0;s[1]==2 if"()" else 0
         */
        int len = s.length(),res = 0;
        if(len<=1) return 0;
        int[] dp = new int[len];
        if(s.charAt(0)=='(' && s.charAt(1)==')'){
            dp[1] = 2;
            res = 2;
        }
        for(int i=2;i<len;i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = dp[i-2]+2;
                }else {
                    int next = i-1;
                    int temp = next-dp[next];
                    if(dp[next]>0  && temp>=0 && s.charAt(temp)=='('){
                        dp[i] += dp[next]+2;
                        if(temp>=1) dp[i] += dp[temp-1];
                    }
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
    public boolean isMatch(String s, String p) {
        /*
         *  44. 通配符匹配
         *      1.动态规划的处理：
         *             -1: dp[i][j]是s[0-i]与p[0-j]是否匹配
         *             -2: 状态转移: if(*) dp[i][j] = dp[i-1][j] || dp[i][j-1];!!!!
         *      2.改善的细节：利用加入""空字符，解决*匹配空的问题
         */
        int lenS = s.length(),lenP = p.length();
        boolean[][] dp = new boolean[lenS+1][lenP+1];

        dp[0][0] = true;
        for(int i=1;i<=lenS;i++){
            if(s.charAt(i-1)=='*'){
                dp[i][0] = true;
            }else break;
        }
        for(int j=1;j<=lenP;j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j] = true;
            }else break;
        }
        for (int i=1;i<=lenS;i++){
            for (int j=1;j<=lenP;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        // for(int i=0;i<=lenS;i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        return dp[lenS][lenP];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
         *  63. 不同路径 II 经典dp 细节
         */
        int m = obstacleGrid.length;
        if(m==0) return 0;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        if(obstacleGrid[0][0]==0) dp[0] = 1;
        for(int i=1;i<n;i++){
            if(obstacleGrid[0][i]==0) dp[i] = dp[i-1];
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    if(obstacleGrid[i][j]==1) dp[j] = 0;
                }else {
                    if(obstacleGrid[i][j]==1){
                        dp[j] = 0;
                    }else {
                        dp[j] += dp[j-1];
                    }
                }
            }
        }
        return dp[n-1];
    }

    @Deprecated
    public String removeKdigits(String num, int k) {
        /*
         *  402. 移掉K位数字 删除效率实在不高
         */
        StringBuilder sb = new StringBuilder(num);
        int n = num.length();
        for(int i =0;i<k;i++){
            for(int j=0;j<sb.length();j++){
                if(j<sb.length()-1){
                    if(sb.charAt(j)>sb.charAt(j+1)){
                        sb.deleteCharAt(j);
                        break;
                    }
                }else {
                    sb.deleteCharAt(sb.length()-1);
                    break;
                }
            }
        }
        while (sb.length()>0 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        if(sb.length()==0) sb.append('0');
        return sb.toString();
    }
    public String removeKdigits_2(String num, int k) {
        /*
         *  402. 移掉K位数字 单调栈操作 高明
         */
        Deque<Character> stack = new LinkedList<>();
        int popNum = 0;
        for(char c:num.toCharArray()){
            if(stack.size()==0 || stack.peekLast()<c){
                stack.offerLast(c);
            }else {
                while (popNum<k && stack.size()>0 && stack.peekLast()>c){
                    stack.pollLast();
                }
                stack.offerLast(c);
            }
        }
        System.out.println(stack.toString());
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            if(!(sb.length()==0 && c=='0')){
                sb.append(c);
            }
        }
        if(sb.length()==0) sb.append('0');
        return sb.toString();
    }

    @Deprecated
    public String removeDuplicateLetters(String s) {
        /*
         *  316. 去除重复字母 与402相同 单调栈
         */
        Deque<Character> stack = new LinkedList<>();
        Map<Character,Integer> counter = new HashMap<>();
        Set<Character> inStact = new HashSet<>();

        for(char c : s.toCharArray()){
            counter.put(c,counter.getOrDefault(c,0)+1);
        }

        for(char c : s.toCharArray()){
            if(!inStact.contains(c)){
                while (stack.size()>0 && stack.peekLast()>c && counter.get(stack.peekLast())>0){
                    inStact.remove(stack.pollLast());
                }
                stack.offerLast(c);
                inStact.add(c);
            }
            counter.put(c,counter.get(c)-1);
        }

        StringBuilder sb = new StringBuilder();
        for(char c : stack) sb.append(c);
        return sb.toString();
    }

    public String removeDuplicateLetters_1(String s){
        /*
         *  316. 去除重复字母 与402相同 单调栈 改进map的用法 map的作用只是区分当前stack中是否是最后一个了
         */
        Deque<Character> stack = new LinkedList<>();
        Map<Character,Integer> map = new HashMap<>();
        Set<Character> inStact = new HashSet<>();

        for(int i=0;i<s.length();i++) map.put(s.charAt(i),i);

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!inStact.contains(c)){
                while (!stack.isEmpty() && stack.peekLast()>c && map.get(stack.peekLast())>i){
                    inStact.remove(stack.pollLast());
                }
                stack.offerLast(c);
                inStact.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : stack) sb.append(c);
        return sb.toString();
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        
        if(root==null){
            if(sum == 0) return true;
            else return false;
        }
        if(hasPathSum(root.left,sum-root.val)) return true;
        else return hasPathSum(root.right,sum-root.val);
    }

    public int respace(String[] dictionary, String sentence) {
        /*
         *  面试题 17.13. 恢复空格 暴力dp  java的subString表现有点差 几乎超时
         */
        int n = sentence.length();
        int[] dp = new int[n+1];
        Set<String> set = new HashSet<>();
        for(String s : dictionary) set.add(s);

        for(int i=1;i<n+1;i++){
            dp[i] = dp[i] + 1;
            for(int j=0;j<i;j++){
                if(set.contains(sentence.substring(j,i))){
                    dp[i] = Math.min(dp[i],dp[j]);
                }
            }
        }
        return dp[n];
    }
/*    public int respace_1(String[] dictionary,String sentence){
        *//*
         * 面试题 17.13. 恢复空格 dp+Trie 优化搜索
         *//*
        Trie trie = new Trie();
        for(String s:dictionary) trie.reverseInsert(s);
        int n = sentence.length();
        int[] dp = new int[n+1];

        for(int i=1;i<n+1;i++){
            dp[i] = dp[i] + 1;
            List<Integer> idxList = trie.search(sentence,i);
            for(int j : idxList){
                dp[i] = Math.min(dp[i],)
            }
        }

    }*/

    public int balancedString(String s) {

        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
        int N = s.length();
        int cnt = N/4;
        int left = 0,right = 0,res = N;
        while (right<N){
            while (right<N && (map.get("Q")>cnt || map.get("E")>cnt || map.get("W")>cnt || map.get("R")>cnt)){
                map.put(s.charAt(right),map.get(s.charAt(right))-1);
                right++;
            }
            while (left<right && map.get("Q")<=cnt && map.get("E")<=cnt && map.get("W")<=cnt && map.get("R")<=cnt){
                map.put(s.charAt(left),map.get(s.charAt(left))+1);
                left++;
            }
            res = Math.min(res,right-left+1);
        }
        return res;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        /**
         *  350. 两个数组的交集 II
         *  map计数+小优化
         */
        int len1 = nums1.length,len2 = nums2.length;
        if(len1>len2) return intersect(nums2,nums1);

        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums1) map.put(num,map.getOrDefault(num,0)+1);
        int[] res = new int[len1];
        int cnt = 0;

        for(int num:nums2){
            if(map.containsKey(num) && map.get(num)>0){
                res[cnt++] = num;
                map.put(num,map.get(num)-1);
            }
        }
        return Arrays.copyOfRange(res,0,cnt);
    }

    public int[] intersect_1(int[] nums1,int[] nums2){
        /*
            350. 两个数组的交集 II
            排序+双指针
         */
        int lab1 = 0,lab2 = 0,cnt = 0;
        int[] res = new int[nums1.length];
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while(lab1<nums1.length && lab2<nums2.length){
            if(nums1[lab1] == nums2[lab2]){
                res[cnt++] = nums1[lab1++];
                lab2++;
            }else if(nums1[lab1]>nums2[lab2]){
                lab2++;
            }else lab1++;
        }
        return Arrays.copyOfRange(res,0,cnt);
    }

    public int totalHammingDistance(int[] nums) {
        /*
         * 477. 汉明距离总和 暴力法超时
         */
        int res = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                res += HammingDistance(nums[i],nums[j]);
            }
        }
        return res;
    }
    private int HammingDistance(int num1,int num2){
        int temp = num1 ^ num2;
        int cnt = 0;
        for(int i = 0;i<32;i++){
            if((temp & (1<<i))==1) cnt++;
        }
        return cnt;
    }

    public int totalHammingDistance_1(int[] nums){
        /*
         *  477. 汉明距离总和 关键思想：01集合 互不相同的个数 是cnt_1 * cnt_0 
         */
        int res = 0;
        for(int i=0;i<32;i++){
            int cntZero = 0;
            for(int num:nums){
                if((num & (1<<i))==0) cntZero++;
            }
            res += cntZero*(nums.length-cntZero);
        }
        return res;
    }

    public int wiggleMaxLength(int[] nums) {
        /*
         *  376. 摆动序列 直接贪心思想 直接找波动
         */
        int n = nums.length;
        if(n<=1) return n;
        int cnt = nums[1]!=nums[0]? 2:1;
        int lab = getLab(nums[1],nums[0]);

        for(int i=2;i<n;i++){
            int temp = getLab(nums[i],nums[i-1]);
            if(temp!=0 && (lab==0 || lab != temp)){
                cnt++;
                lab = temp;
            }
        }
        return cnt;
    }
    private int getLab(int a,int b){
        if(a==b) return 0;
        else return a>b? 1:-1;
    }

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i =1;i<=n;i++){
            for(int j=0;j<=i-1;j++){
                dp[i] += dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }
}

