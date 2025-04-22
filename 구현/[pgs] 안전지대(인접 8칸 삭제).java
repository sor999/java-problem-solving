/*
n*n에서 x 제외하기
*/

class Solution {
    private static int [] dx = {-1,1,0,0,1,-1,1,-1};
    private static int [] dy = {0,0,-1,1,-1,1,1,-1};
    private static boolean [][] visited;

    public int solution(int[][] board) {
        int n = board.length;

        visited = new boolean [n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1) move(i,j,n);
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]) cnt++;
            }
        }

        return cnt;
    }

    private static void move(int cx, int cy, int n){
        visited[cx][cy] = true;
        for(int i=0; i<8; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            if(nx >= n || ny >=n || nx < 0 || ny < 0) continue;
            visited[nx][ny] = true;
        }
    }
}