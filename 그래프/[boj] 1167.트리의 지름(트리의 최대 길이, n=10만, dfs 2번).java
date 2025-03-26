/*

모든 점에서 dfs를 해도 결국 n^2

1:37
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
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g[a].add(new int []{b, w});
            g[b].add(new int []{a, w});
        }

        for(int i=1; i<=n; i++){
            dfs(i, 0, new boolean [n+1]);
        }

        System.out.println(max);
    }

    private static void dfs(int cx, int sum, boolean [] visited){

        max = Math.max(max, sum);
//        System.out.println(max);

        visited[cx] = true;
        for(int [] next : g[cx]){
            int nx = next[0];
            int nw = next[1];
            if(visited[nx]) continue;
            dfs(nx, sum + nw, visited);
            visited[nx] = false;
        }
    }
}