import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [][] arr = new int [n+1][3];
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][] dp = new int [n+1][3];
        for(int i=1; i<=n; i++) {
            for(int j=0; j<3; j++) {
                dp[i][j] = Math.min(dp[i-1][(j + 3 - 1)%3], dp[i-1][(j + 3 + 1)%3]) + arr[i][j];
            }
        }


        int min = Math.min(dp[n][2], Math.min(dp[n][0], dp[n][1]));

        System.out.println(min);
    }
}
