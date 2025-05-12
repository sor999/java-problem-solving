/*

우선순위 큐 + 위상정렬
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, List<Integer>> g = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++){
            g.put(i, new ArrayList<>());
        }

        int [] ind = new int [n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            g.get(a).add(b);
            ind[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1; i<=n; i++){
            if(ind[i] == 0) pq.add(i);
        }
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur).append(" ");

            for(int next : g.get(cur)){
                ind[next]--;
                if(ind[next] == 0) pq.offer(next);
            }
        }

        System.out.println(sb);

    }
}
