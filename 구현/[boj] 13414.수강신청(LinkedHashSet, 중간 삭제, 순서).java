

/*

map -> 학생 번호 : 순서

map 크기 <= k

맨 마지막에 배열에 넣어서 value를 기준으로 정렬 -> nlogn 가능.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); // 수강 가능 인원
        int l = Integer.parseInt(st.nextToken());

        Map<String, Integer> orderMap = new HashMap<>();
        for(int i=0; i<l; i++){
            String num = br.readLine();
            orderMap.put(num, i);
        }

        List<String> result = new ArrayList<>(orderMap.keySet());

        Collections.sort(result, (a,b) -> orderMap.get(a) - orderMap.get(b));

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<k && i<result.size(); i++){ // 주의: k > result 일 경우도 고려해야 한다.
            sb.append(result.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}

// 방법2. LinkedHashSet(LinkedList + Hash) -> 삽입/삭제/조회 O(1)
// 순서가 있고, 중간 요소를 삭제를 해야할 경우.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); // 수강 가능 인원
        int l = Integer.parseInt(st.nextToken());

        Set<String> result = new LinkedHashSet<>();

        for(int i=0; i<l; i++){
            String num = br.readLine();

            if(result.contains(num)){
                result.remove(num);
            }
            result.add(num);
        }
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for(String str : result){ // 주의: k > result 일 경우도 고려해야 한다.
            if(cnt >= k) break;
            sb.append(str).append("\n");
            cnt++;
        }

        System.out.println(sb);
    }
}