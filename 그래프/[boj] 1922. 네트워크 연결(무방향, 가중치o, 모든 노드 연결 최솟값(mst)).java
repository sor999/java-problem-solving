
/*
모든 노드 연결의 최소 값 - mst - 프림
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Map<Integer, List<int []>> g = new HashMap<>();

        for(int i=1; i<=n; i++) g.put(i, new ArrayList<>());
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g.get(a).add(new int []{b,c});
            g.get(b).add(new int []{a,c});
        }

        int ans = 0;

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        boolean [] visited = new boolean [n+1];
        pq.offer(new int []{1,0});

        while(!pq.isEmpty()){
            int [] curs = pq.poll();
            int cur = curs[0];
            int cw = curs[1];

            if(visited[cur]) continue;
            visited[cur] = true; // 먼저 체크해야하는 거 주의
            ans += cw;

            for(int [] nexts : g.get(cur)){
                int next = nexts[0];
                int nw = nexts[1];

                pq.offer(new int []{next, nw});
            }
        }

        System.out.println(ans);
    }
}