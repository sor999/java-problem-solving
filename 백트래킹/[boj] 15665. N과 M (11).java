
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

        Set<String> set = new LinkedHashSet<>();
        dfs(set, new ArrayList<>(), n, m, num, new boolean [n+1]);

        StringBuilder sb = new StringBuilder();
        for(String s : set){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(Set<String> set, List<Integer> ans, int n, int m, List<Integer> num, boolean [] visited){
        if(ans.size() == m){
            StringBuilder s = new StringBuilder();
            for(int p : ans){
                s.append(num.get(p)).append(" ");
            }
            set.add(s.toString());
            return;
        }

        for(int i=0; i<n; i++){
            ans.add(i);
            dfs(set, ans, n, m, num, visited);
            ans.remove(ans.size()-1);
        }
    }
}
