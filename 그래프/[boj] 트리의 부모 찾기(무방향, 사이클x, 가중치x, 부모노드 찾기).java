
/*
bfs/ dfs
부모를 저장하면서 탐색하자.
저장 -> parent 배열
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int [] parent = new int [n+1];
        boolean [] visited = new boolean [n+1];

        Map<Integer, List<Integer>> g = new HashMap<>();

        for(int i=1; i<=n; i++){
            g.put(i, new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            g.get(a).add(b);
            g.get(b).add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.offer(1);
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : g.get(cur)){

                if(visited[next]) continue;
                visited[next] = true;
                parent[next] = cur;
                q.offer(next);
            }
        }

        for(int i=2; i<=n; i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }
}
