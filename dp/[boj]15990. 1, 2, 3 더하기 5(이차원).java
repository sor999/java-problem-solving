import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int [][] dp = new int [100001][4];

        int mod = 1_000_000_009;

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;


        for(int i=4; i<dp.length; i++){
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % mod;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % mod;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % mod;
        }


        while(t-- != 0){
            int n = Integer.parseInt(br.readLine());

            int sum = 0;

            for(int i=1; i<=3; i++){
                sum = (sum + dp[n][i])%mod;
            }

            System.out.println(sum);
        }
    }
}
