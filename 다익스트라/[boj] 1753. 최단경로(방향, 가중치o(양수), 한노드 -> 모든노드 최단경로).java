/*
방향그래프 + 가중치(자연수)
시작점 1개
끝점은 다른 n-1개 정점
-> 다익스트라
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        Map<Integer, List<int []>> g = new HashMap<>();

        for(int i=1; i<=n; i++) g.put(i, new ArrayList<>());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            g.get(a).add(new int []{b,w});
        }

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int [] dist = new int [n+1];
        boolean [] visited = new boolean [n+1];
        final int INF = 3_000_001;
        Arrays.fill(dist,INF);
        dist[k] = 0;
        pq.offer(new int [] {k, 0});

        while(!pq.isEmpty()){
            int [] curs = pq.poll();
            int cx = curs[0];

            if(visited[cx]) continue;
            visited[cx] = true;

            for(int [] nexts : g.get(cx)){
                int nx = nexts[0];
                int nw = nexts[1];

                if(visited[nx]) continue;

                if(dist[nx] > dist[cx] + nw){
                    dist[nx] = dist[cx] + nw;
                    pq.offer(new int [] {nx, dist[nx]});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            if(dist[i] == INF){
                sb.append("INF").append("\n");
            }else{
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
