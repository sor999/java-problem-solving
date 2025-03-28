
/*
일단 요리를 쓸지 말지 정해서
신맛, 쓴맛 각각 전체 조합을 만든다. -> 여기서 미리 조합의 계산 값을 저장해준다.
nC1, nC2... nC10 ->  완탐

그리고 나서 차이를 구한다.
1. 완탐
2. 비트마스킹
 */

// 1. 완탐
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<long []> list = new ArrayList<>();
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            list.add(new long [] {a,b});
        }
        dfs(0, n, 1, 0, 0);
        System.out.println(min);
    }

    private static void dfs(int at, int n, long a, long b, int depth){
        if(depth >= 1){
            min = Math.min(min, Math.abs(a - b));
        }

        if(n == depth){
            return;
        }

        for(int i=at; i<n; i++){
            long [] nexts = list.get(i);
            dfs(i+1, n, a*nexts[0], b + nexts[1], depth+1);
        }
    }
}
/*
비트 마스킹 풀이 참고.

1 ~ 2^n-1 -> 1부터 모든 가능한 부분 집합. 1이면 선택 0이면 선택x
모든 가능한 부분집합을 돌아가면서 비트 마스킹.

2^10 = 00000 00001, ... 11111 11111
 */

// 2. 비트마스킹
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<long []> list = new ArrayList<>();
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            list.add(new long [] {a,b});
        }

        for(int mask = 1; mask < (1 << n) ; mask++){ // 1 00000 00000 전까지.
            long a = 1;
            long b = 0;

            for(int i=0; i<n; i++){
                if((mask & (1 << i)) == 0) continue;
                //1이면 선택
                a *= list.get(i)[0];
                b += list.get(i)[1];
            }

            min = Math.min(min, Math.abs(a - b));
        }

        System.out.println(min);
    }
}