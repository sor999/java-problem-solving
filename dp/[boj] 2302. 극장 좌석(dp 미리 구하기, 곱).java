import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int [] dp = new int [41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        if(m == 0) {
            System.out.println(dp[n]);
            return;
        }

        boolean [] visited = new boolean [n+1];
        for(int i=0; i<m;i++){
            int idx = Integer.parseInt(br.readLine());
            visited[idx] = true;
        }

        int cnt = 0;
        int ans = 1;
        for(int i=1; i<=n ;i++){
            if(visited[i]){
                if(cnt > 0) ans *= dp[cnt];
                cnt = 0;
            }else{
                cnt++;
            }
        }
        if(cnt > 0) ans*= dp[cnt];

        System.out.println(ans);

    }
}

