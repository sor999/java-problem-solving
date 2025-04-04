/*
직선 -> 100
코너 -> 100 + 500(이전 방향과 다를 때)

경주로를 건설 비용 최소
1. 백트래킹 -> 너무 많은 경우의 수?
2. bfs -> 특정 횟수만 이동 제한 -> 불가. 전부 봐야함

25*100 + 25*500


최적화
dp배열을 만들어서 최솟값을 저장. 다음값이 현재+1 or 5 보다 크게되면 이 경로는 스킵한다.

엣지케이스
어떤 곳으로 경로가 모였을 때, 그 다음 경로에서 방향이 바뀌면서 최솟값 경로가 최솟값이 아니게 될 수 있다. 따라서 방향정보에 따른 dp가 필요
*/
import java.util.*;
class Solution {
    private static int [] dx = {1,0,-1,0};
    private static int [] dy = {0,1,0,-1};
    private static boolean [][] visited;
    private static int n;
    private static int [][] board;
    private static int [][][] dist;
    public int solution(int[][] board) {
        int answer = 0;
        this.board = board;
        n = board.length;
        visited = new boolean [n][n];
        dist = new int [n][n][4];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        for(int i=0; i<4; i++){
            dist[0][0][i] = 0;
        }

        dfs(0, 0, -1);
        int min = Integer.MAX_VALUE;


        for(int i=0; i<4; i++){
            min = Math.min(dist[n-1][n-1][i], min);
        }
        return min*100;
    }

    private static void dfs(int cx, int cy, int dir){
        if(cx == n-1 && cy == n-1){
            return;
        }

        visited[cx][cy] = true;
        for(int i=0; i<4; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if(nx >= n || ny >= n || nx < 0 || ny < 0 || board[nx][ny] == 1 || visited[nx][ny]) continue;

            if(dir == i || dir == -1){
                if(dir != -1 && dist[nx][ny][i] < dist[cx][cy][dir] + 1) continue;
                dist[nx][ny][i] = dir == -1 ? 1 : dist[cx][cy][dir] + 1;
                dfs(nx, ny, i);
            }else{
                if(dist[nx][ny][i] < dist[cx][cy][dir] + 6) continue;
                dist[nx][ny][i] = dist[cx][cy][dir] + 6;
                dfs(nx, ny, i);
            }

        }
        visited[cx][cy] = false;
    }

    private static void print(){
        for(int i=0; i<n; i++){
            System.out.println(Arrays.toString(visited[i]));
        }
        for(int i=0; i<n; i++){
            System.out.println(Arrays.toString(dist[i]));
        }
        System.out.println();
    }
}