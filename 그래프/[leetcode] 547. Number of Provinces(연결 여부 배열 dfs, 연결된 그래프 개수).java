/*

일단 그래프를 만드는게 편할듯
방문하면 방문체크 하면서 for문 안에 dfs

*/
class Solution {
    // 방법1. 그래프 만듦
    // Map<Integer, Set<Integer>> g = new HashMap<>();
    // int n;
    // public int findCircleNum(int[][] isConnected) {

    //     n = isConnected.length;

    //     for(int i=1; i<=n; i++){
    //         g.put(i, new HashSet<>());
    //     }

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<n; j++){
    //             if(isConnected[i][j] == 1 && i != j){
    //                 g.get(i+1).add(j+1);
    //                 g.get(j+1).add(i+1);
    //             }
    //         }
    //     }
    //     int cnt = 0;
    //     boolean [] visited =  new boolean [n+1];
    //     for(int i=1; i<=n; i++){
    //         if(visited[i]) continue;
    //         dfs(i,visited);
    //         cnt++;
    //     }
    //     return cnt;
    // }

    // private void dfs(int cur, boolean [] visited){

    //     visited[cur] = true;

    //     for(int next : g.get(cur)){
    //         if(visited[next]) continue;
    //         dfs(next, visited);
    //     }

    // }

    //방법 2
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }
    public void dfs(int[][] isConnected, int[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(isConnected, visited, j);
            }
        }
    }


}