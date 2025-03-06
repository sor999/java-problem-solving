/*
모든 노드가 0을 방문할 수 있게 최소 횟수로 재배치.
연결을 모두 해보기(무방향)

0부터 시작해서 다 탐색을 하는데, 그래프가 거꾸로 되어있으면 뒤집기. 그러면서 횟수를 늘린다
n-1개의 엣지만 존재하기 때문에 가능.(사이클 가능성 없음)

*/
class Solution {
    // 방법1. 완탐 dfs -> 시간 초과
    // int cnt = 0;

    // public int minReorder(int n, int[][] connections) {

    //     n = connections.length +1;
    //     dfs(0, n, connections, new boolean [n]);

    //     return cnt;
    // }
    // public void dfs(int cur, int n, int [][] connections, boolean [] visited){

    //     for(int i=0; i<connections.length; i++){
    //         if(visited[i]) continue;
    //         int a = connections[i][0];
    //         int b = connections[i][1];

    //         if(a != cur && b != cur) continue;

    //         visited[i] = true;

    //         if(a == cur){
    //             cnt++;
    //             dfs(b, n, connections, visited);
    //         }else{
    //             dfs(a, n, connections, visited);
    //         }

    //     }
    // }

    // 방법 2 그래프 + 메모이제이션 set O(n + n + n) = O(n)
    // int cnt = 0;

    // Set<String> memo = new HashSet<>();
    // Map<Integer, List<Integer>> g = new HashMap<>();
    // public int minReorder(int n, int[][] connections) { // 시간 초과

    //     n = connections.length +1;
    //     for(int i=0; i<n; i++){
    //         g.put(i, new ArrayList<>());
    //     }

    //     for(int [] arr : connections){
    //         int a = arr[0];
    //         int b = arr[1];
    //         memo.add(a + " " + b);

    //         g.get(a).add(b);
    //         g.get(b).add(a);
    //     }

    //     dfs(0, n, new boolean [n]);

    //     return cnt;
    // }
    // public void dfs(int cur, int n , boolean [] visited){
    //     visited[cur] = true;
    //     for(int next : g.get(cur)){
    //         if(visited[next]) continue;
    //         String key = cur + " " + next;
    //         if(memo.contains(key)){
    //             cnt++;
    //         }
    //         dfs(next, n, visited);
    //     }
    // }


    //방법3. connections 이차원 배열을 이차원 리스트로 변경한다. 거꾸로 가는 방향은 도착점을 -로 넣는다.
    public int minReorder(int n, int[][] connections) {

        n = connections.length +1;

        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }

        for(int [] arr : connections){
            int a = arr[0];
            int b = arr[1];
            list.get(a).add(b);
            list.get(b).add(-a);
        }

        return dfs(list, new boolean [n], 0);

    }
    public int dfs(List<List<Integer>> list , boolean [] visited, int cur){
        int cnt = 0;

        visited[cur] = true;

        for(int next : list.get(cur)){
            if(visited[Math.abs(next)]) continue;
            cnt+= dfs(list,visited, Math.abs(next));
            cnt+= next > 0 ? 1 : 0;
        }
        return cnt;
    }
}