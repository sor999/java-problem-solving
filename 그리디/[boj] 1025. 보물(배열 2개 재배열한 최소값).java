/*
접근법: 그리디
제한
n=50
0<= 원소 <=100

알고리즘
a 정렬 > 오름차순
b 정렬 > 내림차순 (재배열 안되지만 a가 대칭적으로 배열된다 생각하면됨.)
각각 곱하기

시간복잡도: O(nlogn + nlogn + n) = O(nlogn)
---
접근법: 완전탐색
알고리즘
a를 순열로 배치 한다음 같은 인덱스 끼리 곱하기

시간복잡도: 50! + 50 -> 불가

*/

import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Main {
    //1. 그리디
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> a = Arrays.stream(br.readLine().split(" ")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        List<Integer> b = Arrays.stream(br.readLine().split(" ")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());


        int ans = 0;
        Collections.sort(a);
        Collections.sort(b, Collections.reverseOrder());


        for(int i=0; i<n; i++){
            ans += a.get(i)*b.get(i);
        }
        System.out.println(ans);
    }
}