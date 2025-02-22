/*
n 노드
m 엣지

줄은 세운다 -> 위상 정렬

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

        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i=1; i<=n; i++) g.put(i, new ArrayList<>());

        int [] ind = new int [n+1];
        for(int i=0; i<m; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g.get(a).add(b);
            ind[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(ind[i] == 0) q.add(i);
        }

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int cur = q.poll();
            ans.add(cur);
            for(int next : g.get(cur)){
                ind[next]--;
                if(ind[next] == 0) {
                    q.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<ans.size(); i++) sb.append(ans.get(i)).append(" ");

        System.out.println(sb);
    }
}
