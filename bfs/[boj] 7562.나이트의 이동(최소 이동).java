
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int [] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int [] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static boolean [][] visited;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-->0){
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            visited =  new boolean[n][n];

            sb.append(bfs(sx,sy,ex,ey)).append("\n");
        }
        System.out.print(sb);
    }

    private static int bfs(int cx, int cy, int ex, int ey){
        Queue<int []> q = new LinkedList<>();
        visited[cx][cy] = true;
        int cnt = 0;
        q.offer(new int [] {cx, cy});
        while(!q.isEmpty()){
            int qSize = q.size();
            for(int r=0; r<qSize; r++){
                int [] cur = q.poll();
                cx = cur[0];
                cy = cur[1];
                if(cx == ex && cy == ey){
                    return cnt;
                }
                for(int i=0; i<8; i++){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if(nx >= n || ny >= n || nx < 0 || ny < 0) continue;
                    if(visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    q.offer(new int [] {nx, ny});
                }
            }
            cnt++;
        }

        return -1;
    }

}