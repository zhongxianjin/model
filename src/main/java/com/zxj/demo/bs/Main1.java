package com.zxj.demo.bs;

/**
 * Created by upc on 2019/7/29.
 */
import java.util.*;

public class Main1 {
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int t1=0,t2=0;
//        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
//        int[] a = new int[n+m];
//        int[] b = new int[m];
//        for(int i=0;i<n;i++){
//            t1 = sc.nextInt();
//            t2 = sc.nextInt();
//            a[i] = t1;
//            hs.put(t1,t2);
//        }
//        for(int i=0;i<m;i++){
//            t1 = sc.nextInt();
//            a[n+i] = t1;
//            b[i] = t1;
//            System.out.println("get:"+hs.get(t1));
//            if(!hs.containsKey(t1))
//                hs.put(t1,0);
//        }
//        Arrays.sort(a);
//        int max = 0;
//        for(int i=0;i<m+n;i++){
//            System.out.println("a="+a[i]);
//            System.out.println("get:"+hs.get(a[i]));
//            max = Math.max(max,hs.get(a[i]));
//            hs.put(a[i],max);
//        }
//        for(int i=0;i<m;i++){
//            System.out.println(hs.get(b[i]));
//        }

//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        int[][] arr = new int[N][2];
//        TreeMap map = new TreeMap();
//        for(int i = 0; i < N; i++) {
//            arr[i][0] = sc.nextInt();
//            arr[i][1] = sc.nextInt();
//        }
//        Arrays.sort(arr, (e1, e2) -> (int)(e1[0]-e2[0]));
//        for(int i = 1; i < arr.length; i++) {
//            System.out.println("ap"+arr[i][1]);
//            arr[i][1] = Math.max(arr[i-1][1], arr[i][1]);
//            System.out.println("ab"+arr[i][1]);
//        }
//        for(int i = 0; i < arr.length; i++) {
//            map.put(arr[i][0], arr[i][1]);
//        }
//        for(int i = 0; i < M; i++) {
//            int ability = sc.nextInt();
//            Integer index = (Integer) map.floorKey(ability);
//            if(index != null) {
//                System.out.println(map.get(index));
//            } else {
//                System.out.println(0);
//            }
//        }

//        Scanner scan=new Scanner(System.in);
//        int l=scan.nextInt();
//        int r=scan.nextInt();
//        if(l>=r){
//            System.out.print(0);
//        }
//        int countL=0,countR=0;
//        if((l-1)%3==2){
//            countL=(int)((l-1)/3)*2+1;
//        }else{
//            countL=(int)((l-1)/3)*2;
//        }
//        if(r%3==2){
//            countR=(int)(r/3)*2+1;
//        }else{
//            countR=(int)(r/3)*2;
//        }
//
//        System.out.print(countR-countL);
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for(int i=0;i<t;i++){
            int n=scan.nextInt();
            String s=scan.next();
            if(s==null||s.toCharArray().length<=0||n<=0){
                System.out.println(0);
                continue;
            }
            if(n<=3){
                System.out.println(1);
                continue;
            }
            System.out.println(min(n,s));
        }
    }
    public static int min(int n,String s){
        char[] carray=s.toCharArray();
        int count=0,countStack=0,countX=0;;
        for(int i=0;i<n;i++){
            if(carray[i]=='.'){
                countStack++;
                if(countStack%3==0){
                    count++;
                    countStack=0;
                    countX=0;
                    continue;
                }
            }else{
                countX++;
                if(countX%3==0){
                    countX=0;
                    continue;
                }
                if((countStack+countX)>=3){
                    count++;
                    countStack=0;
                    countX=0;
                    continue;
                }

            }
        }
        return count;
    }
}
