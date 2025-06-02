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

        st = new StringTokenizer(br.readLine());
        List<Integer> num = new ArrayList<>();
        for(int i=0; i<n; i++){
            num.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(num);

        StringBuilder sb = new StringBuilder();
        dfs(sb, new ArrayList<>(), n, m, num, new boolean[n]);

        System.out.println(sb);
    }

    private static void dfs(StringBuilder sb, List<Integer> ans, int n, int m, List<Integer> num, boolean [] visited){
        if(ans.size() == m){
            for(int p : ans){
                sb.append(num.get(p)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            ans.add(i);
            visited[i] = true;
            dfs(sb, ans, n, m, num, visited);
            visited[i] = false;
            ans.remove(ans.size()-1);
        }
    }
}