package InfosysTQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static Scanner sc= new Scanner(System.in);

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] tools = new String[]{"black","grey","brown","red","pink"};
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,tools);
        int start =4;
        String tar="black";
        System.out.println(shiftCards(list,start,tar));

    }
    public int mostWordsFound(String[] sentences) {
        int count=0,n=sentences.length;
        for(String s : sentences){
            if(s.equals(" ")){
                count++;
            }
        }
        return count+1;
    }
    public static int processorTime(List<Integer> procestime,List<Integer> tasktime){
        Collections.sort(procestime);
        Collections.sort(tasktime,Collections.reverseOrder());
        int count=0,res=Integer.MIN_VALUE,pre=0;
        for(int i=0;i<procestime.size()-1;i++){
            for(int j=0;j<4;j++){
               pre = procestime.get(i)+tasktime.get(count);
               count++;
               res = Math.max(res,pre);
            }
        }
        return res;

    }
    public static int shiftCards(List<String> cards,int startindex,String target){
        int endindex = cards.indexOf(target);

        if (endindex==startindex)
            return 0;
        if (Math.abs(startindex-endindex)==1)
            return 1;
        int forward=0,backward=0;
        if (startindex<endindex){
             forward = Math.abs(startindex-endindex);
             backward = Math.abs(startindex+((cards.size()-1)-endindex)+1);
        }
        if (startindex>endindex){
            backward = Math.abs(endindex+((cards.size()-1)-startindex)+1);
            forward = Math.abs(endindex-startindex);
        }
        return Math.min(forward,backward);

    }
    public static int getIndex(String s){
        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        char c=s.charAt(0);
        boolean found=false;
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            if (e.getValue()==1){
                c = e.getKey();
                found=true;
                break;
            }
        }
        if (found)
            return s.indexOf(c);
        else
            return -1;
    }
    public String removeDuplicates(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            if(e.getValue() >= k){
               // sb.append(e.getKey());
                map.remove(e.getKey());
            }
            sb.append(e.getValue());
        }
        return sb.toString();
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        for(int i : nums){
            for(int j : nums){
                return Math.abs(nums[i] - nums[j]) <= t && (Math.abs(i - j) <= k);
            }
        }
        return false;
    }
    static int nCr(int n, int r){
        if(r>n)return 0;
        if((n-r) < r) r = n-r;
        int mod  = 1000000007;

        int[] dp = new int[r+1];

        Arrays.fill(dp,0);
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=(Math.min(r,i));j>0;j--){
                dp[j] = (dp[j] + dp[j-1])%mod;
            }
        }

        return dp[r];
    }
    public static void birthGift(){
        int n = sc.nextInt();
        int[][] mat = new int[n][2];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < 2; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(mat));
        int path=0;
        int pre=0;
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if ((mat[i][j] > mat[i-1][j-1]) && (mat[i-1][j-1]<mat[i][j-1])){
                    pre = mat[i-1][j];
                    path += mat[i][j];
                    path +=pre;
                }else {
                    path+=mat[i-1][j];
                }
            }
        }
        System.out.println(path);

    }
    public List<List<Integer>> subsets(int[] nums) {
     List<List<Integer>> allsets = new ArrayList<>();
     int max = 1 << nums.length;
     for(int k=0;k<max;k++){
         List<Integer> subset = convertIntToSet(k,nums);
         allsets.add(subset);
     }
     return allsets;
     }
    List<Integer> convertIntToSet(int x,int[] nums){
        List<Integer> set = new ArrayList<>();
        int index=0;
        for(int k=x;k>=0;k--){
            if((k & 1)==1){
                set.add(nums[index]);
            }
            index++;
        }
        return set;
    }
    public static void gift(int n,int k){
          int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            System.out.println(arr[n / k]);
            n /= k;
        }
        System.out.println();
    }
    public static void RPGgame(){
        int n = sc.nextInt();
        int myex = sc.nextInt();
        int[] pow = new int[n];
        for(int i=0;i<n;i++){
            pow[i] = sc.nextInt();
        }
        int[] bonus = new int[n];
        for (int i=0;i<n;i++){
            bonus[i] = sc.nextInt();
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i=0;i<n;i++){
            map.put(pow[i],bonus[i]);
        }

        System.out.println(map);
        int count=0;
        for (Map.Entry<Integer,Integer> e : map.entrySet()){
            if (myex >= e.getKey()){
                myex += e.getValue();
                ++count;
            }
        }
        System.out.println(myex+" and count "+count);
    }
    public static int maxProfit(int[] arr) {
        int profit = 0,res=0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]){
                profit += (arr[i] - arr[i - 1]);
            }
            res = Math.max(res,profit);
        }
        return res;
    }
    public static void lPalindrome() throws IOException {
        String str = br.readLine();
        char c;
        int sum = 0, n = 0;
        List<String> list = new ArrayList<>();

        for (int i = 0; str.charAt(i) < '='; i++) {
            c = str.charAt(i);
            if (Character.isDigit(c)) {
                n = Character.getNumericValue(c);
                sum += n;
            }

        }
        System.out.println(sum);


    }

    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> h1 = new HashMap<>();
        HashMap<Character, Integer> h2 = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            h1.put(c, h1.getOrDefault(c, 0) + 1);
        }
        for (char c : magazine.toCharArray()) {
            h2.put(c, h1.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> e : h2.entrySet()) {
            if (e.getValue().equals(h1.get(e.getValue()))) {
                return true;
            }
        }


        return false;

    }

    public static int minimum_pluses(String A) {
        int ans = 0;
        int l = A.length();
        for (int i = 0; i < l; i++) {
            if (A.charAt(i) == '=')
                ans = A.charAt(i - 1) + A.charAt(i - 2);
        }
        return ans;
    }

    public static void getAllNegative() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter all the element");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > 0) {
                if (j != k) {
                    int temp = arr[j];
                    arr[j] = arr[k];
                    arr[k] = temp;
                }
                k++;

            }
        }
        System.out.println(Arrays.toString(arr));
    }


}
