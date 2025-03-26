/*

모든 점에서 dfs를 하면 n^2 > 1초 -> 다른 방법?
가중치도 1만이어서 long을 쓰자.
- 1이 루트 보장 x -> 1에서 시작한다 가정하고, 양방향 그래프로 열결하고 visited 처리
- 1에서 dfs해서 돌아올 떄 왼쪽과 오른쪽 중에 더 큰 값을 가져오자.
- 마지막으로 루트에서 출력

-> O(N)

트리 dp

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n;
    private static List<int []>[] g;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        g = new ArrayList[n+1];
        for(int i=1; i<=n; i++) g[i] = new ArrayList<>();
        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            while(true){
                int b = Integer.parseInt(st.nextToken());

                if(b == -1) break;

                int w = Integer.parseInt(st.nextToken());

                g[a].add(new int []{b, w});
                g[b].add(new int []{a, w});

            }
        }

        System.out.println(dfs(1, 0, new boolean [n+1]));
    }

    private static int dfs(int cx, int sum, boolean [] visited){

        int max = 0;

        visited[cx] = true;
        for(int [] next : g[cx]){
            int nx = next[0];
            int nw = next[1];
            if(visited[nx]) continue;
            max = Math.max(dfs(nx, sum + nw, visited) + nw, max);
            visited[nx] = false;
        }

        return max;
    }
}