
/*
dp -> o
1 4 9 16 ... 만들고서 큰 수부터 빼주기. -> 틀린 풀이

dp[i - j*j] + 1 에서 가져온다. j*j <= i 전까지

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] dp = new int [n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}

