/*
방향
회전 - 45

목표: 개수 -> 완전 탐색.
dfs

방법의 수가 1,000,000보다 작으니 1초 안에 가능

가로 ->  (x1 == x2) && (y1 != y2)
세로->  (x1 != x2) && (y1 == y2)
대각 ->  (x1 != x2) && (y1 != y2)
x1, y1은 x2,y2가 되고
x2, y2는 x,y를 한칸 이동

---
하나의 방향성만 있으니 dp 풀이도 가능
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int [][] map;
    static int [] dx = {0, 1, 1}; // 오른쪽, 왼쪽, 대각선으로 이동
    static int [] dy = {1, 0, 1};
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int [n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,0,1);

        System.out.println(cnt);
    }

    public static void dfs(int x1, int y1, int x2, int y2){
        if(x2 == n-1 && y2 == n-1){
            cnt++;
            return;
        }

//        System.out.println(List.of(x1+1,y1+1,x2+1,y2+1));
        for(int i=0; i<3; i++){
            if((x1 == x2) && (y1 != y2)){ // 가로
                if(i==1) continue;

            }else if((x1 != x2) && (y1 == y2)){
                if(i==0) continue;

            }else{
                if(x2+1 > n && y2+1 > n) break;

            }

            if(i==0){
                if(y2+1 < n && map[x2][y2+1] == 1) continue;
            }else if(i==1){
                if(x2+1 < n && map[x2+1][y2] == 1) continue;
            }else{
                if(x2+1 < n && y2+1 < n && (map[x2+1][y2+1] == 1 || map[x2+1][y2] == 1 || map[x2][y2+1] == 1)) break;
            }

            int nx = x2 + dx[i];
            int ny = y2 + dy[i];

            if(nx >= n || ny >= n) continue;
            dfs(x2,y2,nx,ny);
        }
    }
}