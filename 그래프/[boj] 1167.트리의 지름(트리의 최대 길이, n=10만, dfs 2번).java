/*

모든 점에서 dfs를 하면 n^2 > 1초 -> 다른 방법?
가중치도 1만이어서 long을 쓰자.
- 1이 루트 보장 x -> 1에서 시작한다 가정하고, 양방향 그래프로 열결하고 visited 처리
- 1에서 dfs해서 돌아올 떄 왼쪽과 오른쪽 중에 더 큰 값을 가져오자.
- 마지막으로 루트에서 출력
// 1이 아닐 경우도 생각해야함. 1을 포함하는 루트가 별로일 수도 있다.
-> 1에대해서 x, 리프 노드를 먼저 구하자.
-> 리프노드를 어떻게 구할까. 처음에 간선 입력받을때 노드와 연결된 간선이 1개 이면 리프노드.
// 근데 리프노드로 하면 O(N^2) -> x. 중간에 가장 많은 간선과 연결된 노드를 구하면 반드시 지나지 않을까? -> 아님
-> O(N)

//한 점에서 시작했을 때, 가장 먼 정점을 구하고 그 점에서 시작해야한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n;
    private static Map<Integer,List<int []>> g = new HashMap<>();;

    private static int start = 0;
    private static long maxSum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++) g.put(i, new ArrayList<>());

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            while(true){
                int b = Integer.parseInt(st.nextToken());

                if(b == -1) break;

                int w = Integer.parseInt(st.nextToken());

                g.get(a).add(new int []{b, w});
                // 어차피 모든 연결된 간선을 보여주니까 b -> a는 넣을 필요가 없다.
            }
        }



        dfs(1, new boolean [n+1], 0);

        maxSum = 0;

        dfs(start, new boolean [n+1], 0);
        System.out.println(maxSum);

    }
    private static void dfs(int cx, boolean [] visited, long sum){
        if(maxSum < sum){
            maxSum = sum;
            start = cx;
        }
        visited[cx] = true;

        for(int [] next : g.get(cx)){
            int nx = next[0];
            int nw = next[1];
            if(visited[nx]) continue;
            dfs(nx, visited, sum + nw);
        }
    }
}