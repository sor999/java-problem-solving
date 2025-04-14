
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] dp = new int [n+1][2];
        dp[1][0] = 0;
        dp[1][1] = 1;
        final int MOD = 15746;
        for(int i=2; i<=n; i++){
            dp[i][0] = dp[i-1][1];
            dp[i][1] = (dp[i-1][0]+ dp[i-1][1])%MOD;
        }
        System.out.println((dp[n][0]+dp[n][1])%MOD);
    }
}

