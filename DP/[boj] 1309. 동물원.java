/*
2*n -> 고정된 배열
dp[i][3]  // 안넣음, 왼쪽 넣음, 오른쪽 넣음
O(N)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int MOD = 9901;
        int [][] dp = new int [n+1][3];

        dp[1][0] = dp[1][1] = dp[1][2] = 1;
        for(int i=2; i<=n; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2])%MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1])%MOD;
        }

        int ans = 0;
        for(int i=0; i<3; i++){
            ans += dp[n][i];
            ans%=MOD;
        }
        System.out.println(ans);
    }
}
