/*
LIS -> dp 아님 이분탐색
dp, 이분 탐색 -> LIS의 최장 "길이"
dp -> LIS의 최대 "합"
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[n]; // i번째 수열을 사용했을 때 부분 수열의 최댓값

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }

            dp[i] += arr[i];
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}

