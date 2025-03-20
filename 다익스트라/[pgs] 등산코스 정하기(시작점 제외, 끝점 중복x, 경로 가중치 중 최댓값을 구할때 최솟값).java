/*
가는 경로가 있다 -> 돌아오는 경로도 있다.
가는 경로의 intensity 최소값만 구하면 된다.
그리고 산봉우리 번호, intensity 최소값 출력

그럼 최솟값은 다익스트라 - 출발점 start -> 산봉우리 end
그 과정에서 intensity를 구하기 위해 어떻게 저장해야할까? -> 최댓값만을 저장하는 배열을 따로 만들자. = dist 응용

모든 gates 에서의 다익스트라.

모든 summits 까지의 end

주의
- 어차피 dist는 쓰이지 않는다. 최소 경로 거리 구하는 게 아님. 경로 이동시에는 최대 가중치값이고, end 점에 도달했을 때 최소 intensity로 갱신
- 출입구로 가지 않기, 특정 노드를 마지막으로 가기 -> set으로 검증
- 성능 최적화
    -if (cw > intensities[cx]) continue; 이미 지금 최솟값이 최종 배열에 저장되어 있다면 이 경로는 필요없는 경로임.
    -처음부터 큐에 모든 시작점을 넣어야 한다. 그렇지 않으면 시간 초과.
*/

import java.util.*;
import java.util.stream.*;
class Solution {

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        //그래프 세팅

        Set<Integer> endSet = Arrays.stream(summits).boxed().collect(Collectors.toSet());
        Set<Integer> startSet = Arrays.stream(gates).boxed().collect(Collectors.toSet());
        List<Node>[] g = new ArrayList[n + 1];
        for(int i=1 ;i<=n; i++) g[i] = new ArrayList<>();

        for(int [] path : paths){
            int a = path[0];
            int b = path[1];
            int c = path[2];

            g[a].add(new Node(b,c));
            g[b].add(new Node(a,c));

        }

        int [] ans = new int [2];

        int minSummit = Integer.MAX_VALUE;
        int minIntensity = Integer.MAX_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue(Comparator.comparingInt(a -> ((Node)a).w));

        int [] intensities = new int [n+1];

        final int INF = Integer.MAX_VALUE;
        Arrays.fill(intensities, INF);

        for(int start : gates){
            pq.offer(new Node(start, 0)); // 미리 여러개를 넣어놓고 시작을 해도 된다.
            intensities[start] = 0;
        }



        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int cx = cur.end;
            int cw = cur.w;
            // 현재 intensity가 이미 더 작은 값으로 저장되어 있으면 스킵
            if (cw > intensities[cx]) continue; // 최적화
            if(endSet.contains(cx)) continue; //산봉우리면 더 이상 다음으로 가지 않을 것!
            for(Node next : g[cx]){
                int nx = next.end;
                int nw = next.w;

                if(startSet.contains(nx)) continue; // start 위치 제외

                nw = Math.max(cw, nw);// 경로 상 최대 가중치 계산

                if(intensities[nx] > nw){ // 더 작은 값이라면 갱신.
                    intensities[nx] = nw;
                    pq.offer(new Node(nx, nw));
                }
            }
        }

        for(int end : summits){
            if(intensities[end] <= minIntensity){
                if(intensities[end] == minIntensity){ // 같을 때는 나누어서 처리해야한다.
                    minSummit = Math.min(end, minSummit);
                }else{
                    minSummit = end;
                }

                minIntensity = intensities[end];
            }
        }

        return new int [] {minSummit, minIntensity};
    }

    static class Node{
        int end;
        int w;

        public Node(int end, int w){
            this.end = end;
            this.w = w;
        }
    }
}
