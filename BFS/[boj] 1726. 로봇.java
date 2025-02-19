/*
bfs
방향 k번 이동 당 +1
방향 바꿀때 +1 or +2
O(nm)

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

    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); // n이 행, m이 열이라 가정

        map = new int [n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken())-1;
        int sy = Integer.parseInt(st.nextToken())-1;
        int sd = Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());
        int ex = Integer.parseInt(st.nextToken())-1;
        int ey = Integer.parseInt(st.nextToken())-1;
        int ed = Integer.parseInt(st.nextToken())-1;

        bfs(sx, sy, sd, ex, ey, ed);

        System.out.println(ans);

    }

    static void print(boolean [][][] visited){
        System.out.println();
        for(int i=0; i<n; i++){
            for(int j=0 ;j<m; j++){
                System.out.print(visited[i][j][0] +" ");
            }
            System.out.println();
        }
    }
    static void bfs(int sx, int sy, int sd, int ex, int ey, int ed) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sx, sy, sd, 0});
        boolean[][][] visited = new boolean[n][m][4];
        visited[sx][sy][sd] = true;
        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cd = cur[2];
            int cnt = cur[3];

            if (ex == cx && ey == cy && ed == cd) {
                ans = cnt;
                return;
            }

            for (int k = 1; k <= 3; k++) {
                int nx = cx + dx[cd]*k;
                int ny = cy + dy[cd]*k;

                if (nx >= n || ny >= m || nx < 0 || ny < 0) break;
                if(map[nx][ny] == 1) break; // 벽이면 건너뛰기 멈춰야.
                if (visited[nx][ny][cd]) continue;
                visited[nx][ny][cd] = true;
                q.offer(new int[]{nx, ny, cd, cnt + 1});
            }

            // 180도면 +2 아니면 +1
            for (int nd = 0; nd < 4; nd++) {
                if (visited[cx][cy][nd] || cd == nd) continue;
                int idx = 1;
                if(cd == 0){
                    if(nd == 1) idx++;
                }else if(cd == 1){
                    if(nd == 0) idx++;
                }else if(cd == 2){
                    if(nd == 3) idx++;
                }else if(cd == 3){
                    if(nd == 2) idx++;
                }

                visited[cx][cy][nd] = true;
                q.offer(new int[]{cx, cy, nd, cnt + idx});
            }

        }
    }
}
