/*

접근 방법: 완탐
방법론: 조합
시간복잡도: O(2^n) = 2^20 = 10^6 << 10^9
*/

import java.util.*;
import java.io.*;
public class Main {
    //1. 조합
    // static List<Integer> e = new ArrayList<>();
    // static int cnt = 0;
    // static int n;
    // static int s;
    // public static void main(String[] args) throws IOException{

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     StringTokenizer st = new StringTokenizer(br.readLine());

    //     n = Integer.parseInt(st.nextToken()); // 원소 개수
    //     s = Integer.parseInt(st.nextToken()); // 부분 수열 원소 합

    //     st = new StringTokenizer(br.readLine());
    //     for(int i=0; i<n; i++){
    //         e.add(Integer.parseInt(st.nextToken()));
    //     }

    //     dfs(0, 0);
    //     if(s == 0) cnt--;
    //     System.out.println(cnt);
    // }

    // public static void dfs(int at, int sum){
    //     if(sum == s){
    //         cnt++;
    //     }

    //     // base case
    //     if(at == n){
    //         return;
    //     }
    //     // recursive case
    //     for(int i=at; i<n; i++){
    //         dfs(i+1, sum + e.get(i));

    //     }
    // }

    // 2. 선택/미선택 재귀
    static List<Integer> e = new ArrayList<>();
    static int cnt = 0;
    static int n;
    static int s;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 원소 개수
        s = Integer.parseInt(st.nextToken()); // 부분 수열 원소 합

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            e.add(Integer.parseInt(st.nextToken()));
        }

        dfs(0, 0);
        if(s == 0) cnt--; // 공집합일 경우, s=0 이면, sum == s가 됨.
        System.out.println(cnt);
    }

    public static void dfs(int at, int sum){
        if(n == at){
            if(sum == s) cnt++;
            return;
        }
        dfs(at+1, sum + e.get(at));
        dfs(at+1, sum);
    }

}