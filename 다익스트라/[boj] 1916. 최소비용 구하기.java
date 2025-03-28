
/*

다익스트라: 비용이 양수, 한 점에서 다른 도시. 최소 비용(w존재)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, List<int []>> g = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++){
            g.put(i, new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            g.get(a).add(new int [] {b,w});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        int [] dist = new int [n+1];
        final int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new int [] {start, 0});

        while(!pq.isEmpty()){
            int [] curs = pq.poll();
            int cx = curs[0];
            int cw = curs[1];

            if(dist[cx] < cw) continue;
            for(int [] nexts : g.get(cx)){
                int nx = nexts[0];
                int nw = nexts[1];

                if(dist[nx] > dist[cx] + nw){
                    dist[nx] = dist[cx] + nw;
                    pq.offer(new int [] {nx, dist[nx]});
                }
            }
        }

        System.out.println(dist[end]);
    }
}