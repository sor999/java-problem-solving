/*
1 -> n 최단 경로
이동했던 정점 다시 이동 가능
무방향

다익스트라를 할 것.
끊어서 하기

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n;
    private static final int INF = Integer.MAX_VALUE;
    private static Map<Integer, List<int[]>> g = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            g.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            g.get(a).add(new int[]{b, w});
            g.get(b).add(new int[]{a, w});

        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int [] startDist = dij(1);
        int [] v1Dist = dij(v1);
        int [] v2Dist = dij(v2);

        if(startDist[v1] == INF || startDist[v2] == INF || v1Dist[v2] == INF || v1Dist[n] == INF || v2Dist[n] == INF || v2Dist[v1] == INF) {
            System.out.println(-1);
            return;
        }

        long ans = Math.min((long)startDist[v1] + v1Dist[v2] + v2Dist[n], (long)startDist[v2] + v2Dist[v1] + v1Dist[n]);

        System.out.println(ans);
    }

    private static int [] dij(int start){

        int[] dist = new int[n+1];
        boolean [] visited = new boolean [n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int cx = cur.end;
            int cw = cur.w;

            if(visited[cx]) continue;
            visited[cx] = true;

            //if(cw > dist[cx]) continue; -> visited 안 써도 됨

            for (int[] nexts : g.get(cx)) {
                int nx = nexts[0];
                int nw = nexts[1];

                if (dist[nx] > nw + cw) {
                    dist[nx] = nw + cw;
                    pq.offer(new Node(nx, nw + cw));
                }
            }
        }

        return dist;
    }
    static class Node {
        int end;
        int w;

        public Node(int end, int w) {
            this.end = end;
            this.w = w;
        }
    }
}
