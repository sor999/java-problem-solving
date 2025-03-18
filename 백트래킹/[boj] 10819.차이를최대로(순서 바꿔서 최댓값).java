/*
정수 순서를 바꿔서 특정 식의 최댓값 구하기

n이 8이니 완전탐색? 8!*8

양수, 음수 나눠보자
뒤에 - 에 -가 들어가야 최대.

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int [] arr;
    private static int n;
    private static boolean [] visited;
    private static List<Integer> num = new ArrayList<>();
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean [n];
        arr = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs();

        System.out.println(max);
    }

    private static void dfs(){
        if(num.size() == n){
            int sum = 0;
            for(int i=0; i<n-1; i++){
                int a = num.get(i);
                int b = num.get(i+1);
                sum += Math.abs(a-b);
            }
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            num.add(arr[i]);
            dfs();
            visited[i] = false;
            num.remove(num.size()-1);
        }
    }
}
