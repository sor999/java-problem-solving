
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
        dfs(sb, new ArrayList<>(), n, m);

        System.out.println(sb);
    }

    private static void dfs(StringBuilder sb, List<Integer> num, int n, int m){
        if(num.size() == m){
            for(int p : num){
                sb.append(p).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++){
            num.add(i);
            dfs(sb, num, n, m);
            num.remove(num.size()-1);
        }
    }
}