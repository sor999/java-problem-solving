/*
1. 반복문
시간 복잡도: O(n) = 20


---
2. 재귀
시간 복잡도: O(2^n) = 2^20 = 1000*1000 = 10^6


재귀 -> 함수가 자기자신을 호출
f(N) 을 구하기 위해 f(n-1) + f(n-2) 를 더하면 된다.
= 자기 자신을 호출하면 된다. -> 재귀를 쓴다.

Recursive는 해당 식 그대로(자기 자신 호출부)
Base는 종료조건.(Recursive의 끝 부분)
- 끝부분은 0, 1
- n=0을 넣으면 0으로 종료
- n=1을 넣으면 1로 종료


f(n) = f(n-1) + f(n-2)
f(n-1) = f(n-2) + f(n-3);...

---
3. 메모이제이션 + 재귀
시간 복잡도: O(n)
memo[0] ~ memo[n] -> n개의 공간
recursive case에서 2번 접근(f(n-1), f(n-2))
따라서 O(2*n) -> O(n)

*/

import java.util.*;
import java.io.*;
public class Main {
    // // 1. 반복문
    // public static void main(String[] args) throws IOException{

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     int n = Integer.parseInt(br.readLine());


    //     int [] arr = new int [n+1];

    //     arr[1] = 1;

    //     for(int i=2; i<=n; i++){
    //         arr[i] = arr[i-1] + arr[i-2];
    //     }

    //     System.out.println(arr[n]);

    // }

    // // 2. 재귀
    // public static void main(String[] args) throws IOException{

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     int n = Integer.parseInt(br.readLine());

    //     System.out.println(fibo(n));

    // }

    // public static int fibo(int n){
    //     // base case
    //     if(n == 0) return 0;
    //     if(n == 1) return 1;

    //     // recursive case
    //     return fibo(n-1) + fibo(n-2);
    // }

    static int [] memo;
    // 3. 재귀 + 메모이제이션
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int [n+2]; // n+2 > 0일 경우 고려
        Arrays.fill(memo, -1); // -1이 주로 사용하지 않는 수이므로
        memo[0] = 0;
        memo[1] = 1;
        System.out.println(fibo(n));

    }

    public static int fibo(int n){
        // base case
        if(memo[n] != -1) return memo[n];

        // recursive case
        memo[n] = fibo(n-1) + fibo(n-2); // memo에 저장하고 나서 리턴
        return memo[n];


    }
}