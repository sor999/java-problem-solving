
/*

10 15
5 6 9 14 24 31 35 44 53 55 63
s보다 더 크면 e++
s > diff -> s++;
근데 s==e가 되면 e++;
s < e ,e가 마지막에 도달하면 끝
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int [] sum = new int [n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 1;
        int ans = Integer.MAX_VALUE;
        while(end <= n){
            int diff = sum[end] - sum[start];

            if(start == end){
                end++;
                continue;
            }

            if(s > diff) {
                end++;
            }else {
                ans = Math.min(ans, end - start);
                start++;
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}
