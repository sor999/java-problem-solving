/*
무방향그래프 시작점 -> 끝점 까지의 거리
dfs or bfs 돌면서 end 나오면 return
시간복잡도: O(n+m)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Map<Integer, List<Integer>> g = new HashMap<>();
    private static int ans = -1;
    private static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++) g.put(i, new ArrayList<>());
        visited = new boolean[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g.get(a).add(b);
            g.get(b).add(a);
        }

        dfs(s,e,0);
//        bfs(s,e);
        System.out.println(ans);
    }

    private static void dfs(int cur, int e, int cnt){
        if(cur == e) {
            ans = cnt;
            return;
        }
        visited[cur] = true;
        for(int next : g.get(cur)){
            if(visited[next]) continue;
            dfs(next, e, cnt+1);
        }
    }

    private static void bfs(int s, int e){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {s,0});
        visited[s] = true;
        while(!q.isEmpty()){
            int [] curs = q.poll();
            int cur = curs[0];
            int cnt = curs[1];

            if(cur == e){
                ans = cnt;
                return;
            }

            for(int next : g.get(cur)){
                if(visited[next]) continue;
                visited[next] = true;
                q.offer(new int []{next, cnt+1});
            }
        }
    }
}
