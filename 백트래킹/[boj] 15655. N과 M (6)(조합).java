
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
        dfs(0, sb, new ArrayList<>(), n, m, num);

        System.out.println(sb);
    }

    private static void dfs(int at, StringBuilder sb, List<Integer> ans, int n, int m, List<Integer> num){
        if(ans.size() == m){
            for(int p : ans){
                sb.append(num.get(p)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=at; i<n; i++){
            ans.add(i);
            dfs(i+1, sb, ans, n, m, num);
            ans.remove(ans.size()-1);
        }
    }
}