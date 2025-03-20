/*
일정을 정해서 최대 수익

n이 150만 -> O(N)으로 끝내야한다.-> dp
선택과 미선택

총 n일이면 n일 배열 가정.

dp[i] = i이후의 일들을 사용했을떄 최댓값
dp[i+t] + arr[i] 사용, dp[i+1] 중 최솟값.

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int [] dp = new int [n+2]; // 오른쪽 끝 범위 넘는 거 방지
        int [] t = new int [n+1];
        int [] p = new int [n+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=n; i>=1; i--){
            if(i+t[i] <= n+1){ // 현재 값 활용.
                dp[i] = dp[i+t[i]] + p[i];
            }

            dp[i] = Math.max(dp[i], dp[i+1]); // 현재값 미활용과 비교
        }

        System.out.println(dp[1]);

    }
}