/*

최단 경로로 -> 최솟값
가중치 없으니 bfs

여러개의 동일한 길이 노드가 있을 수 있는데 어떻게 처리?
큐 크기를 저장해서 뎁스를 나눈다.

*/

import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> g = new HashMap<>();

        for(int i=1; i<=n; i++){
            g.put(i, new ArrayList<>());
        }

        for(int [] cur : edge){
            int a = cur[0];
            int b = cur[1];

            g.get(a).add(b);
            g.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[n+1];

        q.offer(1);
        visited[1] = true;
        int cnt = 0;

        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0; i<size; i++){

                int cur = q.poll();

                for(int next : g.get(cur)){
                    if(visited[next]) continue;
                    visited[next] = true;
                    q.offer(next);
                }

            }

            cnt = size;
        }

        return cnt;
    }
}