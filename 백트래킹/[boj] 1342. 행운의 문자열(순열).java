/*
접근 방법: 완탐
방법론: 백트래킹, 순열
- 재귀시 이전값만 인수로 넘겨서 효율화
시간복잡도: O(10!) - 모든 알파벳이 다를 경우
*/

import java.util.*;
import java.io.*;
public class Main {
    static Map<Character, Integer> alphabet = new HashMap<>();
    static String s;
    static int cnt = 0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();

        for(int i=0; i<s.length(); i++){
            char now = s.charAt(i);
            alphabet.put(now, alphabet.getOrDefault(now, 0) + 1);

        }

        dfs(0, '0');

        System.out.println(cnt);
    }

    public static void dfs(int depth, char prev){ // 전체 perm list를 저장해도 되지만, 인접 원소 판단엔 바로 전 원소만 필요하므로
        // base
        if(depth == s.length()){
            cnt++;
            return;
        }

        // recursive
        for(Map.Entry<Character, Integer> e : alphabet.entrySet()){
            char now = e.getKey();
            int nowCnt = e.getValue();
            if(prev == now || nowCnt == 0) continue;
            alphabet.put(now, --nowCnt);
            dfs(depth + 1, now);
            alphabet.put(now, ++nowCnt);
        }
    }
}