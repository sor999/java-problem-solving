/*
1인 곳 빼고 전체 돌리면서 visit처리 = map을 1로 바꾸면 됨 
영역을 나눈다(동시에 개수도 셈) -> dfs
[Silver I] Title: 영역 구하기, Time: 112 ms, Memory: 15244 KB -BaekjoonHub
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,m;
    static int [][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken()); // n이 행, m이 열이라 가정
        int k =  Integer.parseInt(st.nextToken());
        map = new int [n][m];

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int a=x1; a<x2; a++){
                for(int b=y1; b<y2; b++){
                    map[b][a] = 1;
                }
            }
        }
        int area = 0;
        StringBuilder sb = new StringBuilder();

        List<Integer> areas = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1) continue;
                areas.add(dfs(i, j));
                area++;
            }
        }

        Collections.sort(areas);
        sb.append(area).append("\n");
        for(int v : areas){
            sb.append(v).append(" ");
        }
        System.out.println(sb);

    }

    private static int dfs(int cx, int cy){
        int cnt = 1;

        map[cx][cy] = 1;

        for(int i=0; i<4; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if(nx >= n || ny>=m || nx <0 || ny<0 || map[nx][ny]  == 1 ) continue;
            cnt += dfs(nx, ny);
        }

        return cnt;
    }
}
