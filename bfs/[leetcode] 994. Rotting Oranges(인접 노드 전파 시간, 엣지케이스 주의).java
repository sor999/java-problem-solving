/*
썩은 오렌지의 4방향이 연쇄적으로 썩음. 모두 썩는데 걸리는 최소 시간?

최소 시간 + 그리드 입력 + 사방탐색 -> bfs

//방법1.
일단 grid에서 썩은 오렌지(2)의 좌표를 저장한다.
이 좌표를 큐에 넣는다.

이 큐를 바탕으로 bfs를 계속하여 시도한다.
이때 0, 2이면 가지 않고, 1이면 다음으로 가고 2로 바꾼다.(방문배열 따로 필요x)

신선한 오렌지가 다 쓰였는지 확인이 되어야 하기 때문에 처음에 신선한 오렌지 수도 구해준다.

엣지케이스:
grid = [[0,1]] ...-> 아예 2가 없으면 퍼질 수가 없다. -1을 리턴해야한다. == fresh가 0이 아닌데, 2가 없는 것 -> 미리 끝낸다.
grid = [[0]] ...-> fresh가 0이면, 0을 리턴해야한다.(큐를 거치지 않으므로 time을 그대로 리턴하면 안됨)

*/
class Solution {
    public int orangesRotting(int[][] grid) {
        int [] dx = {-1,1,0,0};
        int [] dy = {0,0,1,-1};
        Queue<int []> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2) q.offer(new int []{i,j});
                else if(grid[i][j] == 1) fresh++;
            }
        }
        if(fresh == 0) return 0; // 엣지케이스 [[0]]
        if(q.isEmpty()) return -1; // 엣지케이스 [[0,1]]

        int time = -1;
        while(!q.isEmpty()){
            int qSize = q.size();

            for(int r=0; r<qSize; r++){
                int [] cur = q.poll();
                int cx = cur[0];
                int cy = cur[1];

                for(int i=0; i<4; i++){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if(nx >= n || ny >= m || nx < 0 || ny < 0 || grid[nx][ny] == 2 || grid[nx][ny] == 0) continue;
                    fresh--;
                    q.offer(new int []{nx,ny});
                }
            }

            time++;
        }

        if(fresh == 0) return time;
        return -1;
    }
}