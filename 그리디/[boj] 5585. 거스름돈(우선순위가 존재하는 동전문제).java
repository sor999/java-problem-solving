/*
문제: 1000 - n원의 거스름돈 최소 개수

제약
n = 1000

접근 방법: 그리디
- 가장 큰 잔돈을 먼저 쓰는게 문제의 최적해와 일치

알고리즘
1. 1000 - 잔돈
2. / 연산으로 큰 동전으로 개수 더함
3. % 연산으로 남은 잔돈 확인
4. 2, 3 무한 반복. 3의 결과가 0이 될때까지.

시간복잡도: O(1)
*/

import java.util.*;
import java.io.*;
public class Main {
    //1. 그리디

     public static void main(String[] args) throws IOException{

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         int n = 1000 - Integer.parseInt(br.readLine());

         int [] coins = {500, 100, 50, 10, 5, 1};

         int cnt = 0;

         for(int coin : coins){
             if(n == 0) break;
             cnt += n/coin;
             n %= coin;
         }

         System.out.println(cnt);
     }

//    // 2. 완전탐색
//    // 시간복잡도: O(2*10*20*100*200) < 1억
//
//    public static void main(String[] args) throws IOException{
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = 1000 - Integer.parseInt(br.readLine());
//
//        int [] coins = {500, 100, 50, 10, 5, 1};
//
//        int cnt = Integer.MAX_VALUE;
//
//        // 999까지 가능.
//        // 2
//        for(int c500=0; c500<2; c500++) { // 0~1개 쓰기
//            for (int c100 = 0; c100 < 10; c100++) { // 0~9
//                for (int c50 = 0; c50 < 20; c50++) { // 0~19
//                    for (int c10 = 0; c10 < 100; c10++) { // 0~99
//                        for (int c5 = 0; c5 < 200; c5++) { // 0~199
//                            // c1은 나머지가 결정되면 결정됨
//                            int now = c500 * 500 + c100 * 100 + c50 * 50 + c10 * 10 + c5 * 5;
//                            int c1 = n - now;
//                            if (c1 >= 0) {
//                                cnt = Math.min(cnt, c500 + c100 + c50 + c10 + c5 + c1);
//                            }
//                        }
//                    }
//
//                }
//            }
//        }
//
//        System.out.println(cnt);
//    }
}