/*
방향, 전체를 연결하는 최소 가중치 합.
방법 1. 완탐 n<=10
방법 2. 비트마스킹 n<=16
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

//방법1. 완탐 n<=10
//    public static int n;
//    public static int [][] w;
//    public static boolean [] visited;
//    public static int minW = Integer.MAX_VALUE;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//
//        w = new int[n + 1][n + 1];
//        visited = new boolean[n + 1];
//
//        for (int i = 1; i <= n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 1; j <= n; j++) {
//                w[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        dfs(1, 0, 0); // 1출발
//
//        System.out.println(minW);
//    }
//
//    private static void dfs(int s, int sum, int depth){
//        if(depth == n-1){
//            if(w[s][1] != 0){
//                minW = Math.min(minW, sum + w[s][1]);
//            }
//            return;
//        }
//
//        for(int e=2; e<=n; e++){
//            if(visited[e] || w[s][e] == 0) continue;
//            visited[e] = true;
//            dfs(e, sum+w[s][e], depth+1);
//            visited[e] = false;
//        }
// 방법2. 비트마스킹 n<=16
    static int n;
    static int [][] w;
    static int [][] dp;
    static final int INF = 16_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = new int [n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // i: 현재 위치 도시, j: 지금까지 방문한 도시(2진수)
        dp = new int [n][(1 << n) - 1]; // 1 << 5 이면 100000 => 32 이고 32 -1 이 11111 라서 -1 해줌
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1); // INF로 초기화하면 시간초과 뜸.
        }

        System.out.println(dfs(0,1));
    }

    private static int dfs(int city, int visited){
        if(visited == (1 << n) -1){ // 모든 도시 방문
            if(w[city][0] == 0) return INF;
            return w[city][0];
        }

        if(dp[city][visited] != -1) return dp[city][visited]; // 이미 dp값이 존재하면

        dp[city][visited] = INF;

        for(int i=0; i<n; i++){
            if((visited & (1 << i)) == 0 && w[city][i] != 0){ // i 도시 방문 가능 = 미 방문 도시 && i 도시로 가는 길이 존재
                dp[city][visited] = Math.min(dp[city][visited], dfs(i, visited | (1 << i)) + w[city][i]);
            }
        }

        return dp[city][visited];
    }
}