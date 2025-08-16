/*

1. dp - bottom up

관계 확인
- f(0) : -
- f(1) : - -
- f(2) : - -   - - // 3^1 개 공백
- f(3) : - -   - -         - -   - - // 3^2 개 공벡 = 3^(n-1) 개 공백

n은 n-1이 양끝에 존재, 그리고 가운데 공백을 넣어주는 형태

- 1. 정의: f(n): 입력 n일 때 정답
- 2. 점화식: f(n) = f(n-1) + 공백이 3^(n-1) + f(n-1)
- 3. dp[i]: 입력이 i일 때 답
- 시간복잡도: O(3^n)
dp[0] ~ [12]
dp[i] 길이 = 3^i
3^0 + ... + 3^12 = 3^12

--- top down ---
2. 재귀 + 규칙 (void)

3. 재귀 + 규칙 (문자열 반화): 3^n

4. 재귀 + 메모이제이셔

5. 재귀 + 구현
3^n 개의 배열을 만든다.
n = 3
3^3 = 27
일단 전체 -로 세팅


[recursive]
0~1/3: 재귀
전체 길이 1/3 ~ 2/3 까지 공백 으로
2/3~3/3: 재귀

[base]
문자열 길이 1 이면 return

왜 재귀?: f(x)의 함수에서 x이전의 값으로 함수를 표현 가능

재귀만 -> O(3^n) = 3^12



*/

import java.util.*;
import java.io.*;
public class Main {
    // // 1. botton up
    // public static void main(String[] args) throws IOException{

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringBuilder sb = new StringBuilder();
    //     String line;
    //     while((line = br.readLine()) != null){
    //         int n = Integer.parseInt(line);
    //         String [] dp = new String [n+1];

    //         dp[0] = "-";

    //         for(int i=1; i<=n; i++){
    //             dp[i] = dp[i-1] + " ".repeat((int)Math.pow(3, i-1)) + dp[i-1];
    //         }

    //         sb.append(dp[n]).append("\n");
    //     }

    //     System.out.print(sb.toString());
    // }


    // // 2. 재귀 + 규칙(void)

    // static StringBuilder sb = new StringBuilder();
    // public static void main(String[] args) throws IOException{

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     String line;
    //     while((line = br.readLine()) != null){
    //         int n = Integer.parseInt(line);

    //         recursive(n);
    //         sb.append("\n");
    //     }

    //     System.out.print(sb.toString());
    // }


    // public static void recursive(int x){
    //     // base case
    //     if(x == 0){
    //         sb.append('-');
    //         return;
    //     }

    //     // recursive case
    //     recursive(x-1);
    //     sb.append(" ".repeat((int)Math.pow(3,x-1)));
    //     recursive(x-1);
    // }

    // 3. 재귀 + 규칙(문자열 반환)

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while((line = br.readLine()) != null){
            int n = Integer.parseInt(line);

            sb.append(recursive(n)).append("\n");
        }

        System.out.print(sb.toString());
    }


    public static String recursive(int x){ // 입력이 x일때 답을 반환하는 함수
        // base case
        if(x == 0){
            return "-";
        }

        // recursive case
        return recursive(x-1) + " ".repeat((int)Math.pow(3,x-1)) + recursive(x-1);
    }



    // // 4. 재귀 + 메모이제이션
    // static String [] dp =  new String [13];
    // public static void main(String[] args) throws IOException{

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringBuilder sb = new StringBuilder();
    //     String line;
    //     while((line = br.readLine()) != null){
    //         int n = Integer.parseInt(line);

    //         dp[0] = "-";

    //         recursive(n);
    //         sb.append(dp[n]).append("\n");
    //     }

    //     System.out.print(sb.toString());
    // }

    // public static String recursive(int x){
    //     // base case
    //     if(dp[x] != null){
    //         return dp[x];
    //     }

    //     // recursive case
    //     dp[x] = recursive(x-1) + " ".repeat((int)Math.pow(3, x-1)) + recursive(x-1);
    //     return dp[x];
    // }


    // 5. 재귀 + 구현
    // public static void main(String[] args) throws IOException{

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringBuilder sb = new StringBuilder();
    //     String line;
    //     while((line = br.readLine()) != null){
    //         int n = Integer.parseInt(line);
    //         int end = (int)Math.pow(3,n);
    //         char [] c = new char [end];
    //         Arrays.fill(c, '-');
    //         recursive(0, end, c);
    //         sb.append(new String(c)).append("\n");

    //     }

    //     System.out.print(sb.toString());
    // }

    // public static void recursive(int s, int e, char [] c){

    //     //base case
    //     if(e-s <= 1) return;


    //     //recursive case
    //     recursive(s, s + (e-s)/3, c);
    //     for(int i=s + (e-s)/3; i < s + (e-s)*2/3; i++){
    //         c[i] = ' ';
    //     }
    //     recursive(s + (e-s)*2/3, e, c);
    // }
}