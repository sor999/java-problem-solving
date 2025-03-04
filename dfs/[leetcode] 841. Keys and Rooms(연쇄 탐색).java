/*
dfs를 돌면 될듯함. 대신 여태까지 지나온 키들을 파악해야함.
*/
class Solution {
    int n;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        n = rooms.size();
        boolean [] visited = new boolean[n];
        dfs(0, visited, rooms);

        for(int i=0; i<n; i++){
            if(!visited[i]) return false;
        }
        return true;
    }

    private void dfs(int cur, boolean [] visited, List<List<Integer>> rooms){
        visited[cur] = true;

        List<Integer> curs = rooms.get(cur);

        for(int next : curs){
            if(visited[next]) continue;
            dfs(next, visited, rooms);
        }
    }
}

