/*
두 곳 나눠서 다익스트라 하면 됨.
a -> b인 경우와 b -> a인 경우의 최솟값을 구하자

길을 거쳐 가는 것 vs 각자 이동하는 것
각자 이동하는 경우랑 비교하자.

s -> a -> b
s -> b -> a
s -> a + s -> b
s -> c까지 함께 -> a,b갈라짐
최솟값

플로이드 워셜도 될듯함
*/
import java.util.*;
class Solution {
    static Map<Integer, List<int[]>> g = new HashMap<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        for(int i=1; i<=n; i++){
            g.put(i, new ArrayList<>());
        }
        for(int [] fare : fares){
            int x = fare[0];
            int y = fare[1];
            int w = fare[2];
            g.get(x).add(new int [] {y,w});
            g.get(y).add(new int [] {x,w});
        }

        int [] startA = dij(a, n);
        int [] startB = dij(b, n);
        int [] startS = dij(s, n);

        int min = Math.min(startS[a] + startA[b], Math.min(startS[b] + startB[a], startS[a] + startS[b]));

        for(int c = 1; c <= n; c++) {
            int cost = startS[c] + startA[c] + startB[c]; // c까지 같이 탐
            min = Math.min(min, cost);
        }


        return min;
    }
    static int INF = 20_000_001;
    private static int [] dij(int start, int n){
        int [] dist = new int [n+1];

        for(int i=1; i<=n; i++){
            dist[i] = INF;
        }
        dist[start] = 0;

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        pq.offer(new int []{start, 0});

        while(!pq.isEmpty()){
            int [] cur = pq.poll();

            int cx = cur[0];
            int cw = cur[1];

            if(dist[cx] < cw) continue;

            for(int [] next : g.get(cx)){
                int nx = next[0];
                int nw = next[1];

                if(cw + nw < dist[nx]){
                    dist[nx] = cw + nw;
                    pq.offer(new int [] {nx, cw + nw});
                }
            }

        }

        return dist;
    }
}