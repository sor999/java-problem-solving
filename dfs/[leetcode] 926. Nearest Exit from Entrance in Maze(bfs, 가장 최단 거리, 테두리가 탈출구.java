/*
벽에 닿아있는 것이 출입구.
출입구와 맞닿으면 탈출
bfs
*/

class Solution {
    // 방법1. cnt를 큐에 넘기기
    // public int nearestExit(char[][] maze, int[] entrance) {
    //     int n = maze.length;
    //     int m = maze[0].length;
    //     int [] dx = {-1,1,0,0};
    //     int [] dy = {0,0,1,-1};

    //     Queue<int []> q = new LinkedList<>();
    //     int sx = entrance[0];
    //     int sy = entrance[1];
    //     q.offer(new int [] {sx,sy,0});

    //     while(!q.isEmpty()){
    //         int [] cur = q.poll();
    //         int cx = cur[0];
    //         int cy = cur[1];
    //         int cnt = cur[2];

    //         for(int i=0; i<4; i++){
    //             int nx = cx + dx[i];
    //             int ny = cy + dy[i];
    //             if(nx >= n || ny >= m || nx < 0 || ny < 0){
    //                 if(sx == cx && sy == cy) continue; // 처음 위치에서는 옆이 뚫려있어도 갈수 없음
    //                 else return cnt; //  테두리 위치를 포함하는지 여부로 대신 예외를 처리해도 됨.
    //             }
    //             if(maze[nx][ny] == '+') continue;
    //             maze[nx][ny] = '+';
    //             q.offer(new int []{nx,ny,cnt+1});

    //         }
    //     }

    //     return -1;
    // }

    // 방법 2. cnt를 셀 때, 큐 크기 만큼 돌리기로 변경.
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        int [] dx = {-1,1,0,0};
        int [] dy = {0,0,1,-1};

        Queue<int []> q = new LinkedList<>();
        int sx = entrance[0];
        int sy = entrance[1];
        q.offer(new int [] {sx,sy});

        int cnt = 0;
        while(!q.isEmpty()){

            int r = q.size();
            for(int i=0; i<r; i++){
                int [] cur = q.poll();
                int cx = cur[0];
                int cy = cur[1];

                for(int d=0; d<4; d++){
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];
                    if(nx >= n || ny >= m || nx < 0 || ny < 0){
                        if(sx == cx && sy == cy) continue; // 처음 위치에서는 옆이 뚫려있어도 갈수 없음
                        else return cnt; //  테두리 위치를 포함하는지 여부로 대신 예외를 처리해도 됨.
                    }
                    if(maze[nx][ny] == '+') continue;
                    maze[nx][ny] = '+';
                    q.offer(new int []{nx,ny});

                }
            }

            cnt++;
        }

        return -1;
    }
}