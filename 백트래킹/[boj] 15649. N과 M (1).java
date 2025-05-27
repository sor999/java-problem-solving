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

        StringBuilder sb = new StringBuilder();
        dfs(sb, new ArrayList<>(), n, m, new boolean[n+1]);

        System.out.println(sb);
    }

    private static void dfs(StringBuilder sb, List<Integer> perm, int n, int m, boolean [] visited){
        if(perm.size() == m){
            for(int p : perm){
                sb.append(p).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++){

            if(visited[i]) continue;
            perm.add(i);
            visited[i] = true;
            dfs(sb, perm, n, m, visited);
            visited[i] = false;
            perm.remove(perm.size()-1);
        }
    }
}