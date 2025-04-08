
/*
sgcd -> 1~i 최대공약수
egcd -> i+1 ~n 최대공약수
arr[i]의 최대공약수 -> gcd(sgcd[i], egce[i+1])
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

        st = new StringTokenizer(br.readLine());
        int [] arr = new int [n+2];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int [] sgcd = new int [n+2];
        for(int i=1; i<=n; i++){
            sgcd[i] = gcd(sgcd[i-1], arr[i]);
        }

        int [] egcd = new int [n+2];
        for(int i=n; i>=1; i--){
            egcd[i] = gcd(egcd[i+1], arr[i]);
        }

        int max = -1;
        int k = -1;
        for(int i=1; i<=n; i++){
            int gcd = gcd(sgcd[i-1], egcd[i+1]);

            if(max < gcd){
                if(arr[i]%gcd == 0) continue;
                max = gcd;
                k = arr[i];
            }
        }

        System.out.println(max == -1 ? -1 : max + " " + k);
    }

    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}

