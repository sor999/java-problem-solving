
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
        dfs(1, sb, new ArrayList<>(), n, m);

        System.out.println(sb);
    }

    private static void dfs(int at, StringBuilder sb, List<Integer> perm, int n, int m){
        if(perm.size() == m){
            for(int p : perm){
                sb.append(p).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=at; i<=n; i++){
            perm.add(i);
            dfs(i+1, sb, perm, n, m);
            perm.remove(perm.size()-1);
        }
    }
}