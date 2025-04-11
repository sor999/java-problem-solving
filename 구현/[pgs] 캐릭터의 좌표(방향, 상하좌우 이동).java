import java.util.*;
class Solution {
    Map<String, Integer> dir = Map.of(
            "up", 0, "down", 1, "left", 2, "right", 3
    );
    int [] dx = {0, 0, -1, 1};
    int [] dy = {1, -1, 0, 0};
    public int[] solution(String[] keyinput, int[] board) {
        int n = board[0]/2;
        int m = board[1]/2;

        int cx = 0;
        int cy = 0;
        for(String cur : keyinput){
            int dirIdx = dir.get(cur);
            int nx = cx + dx[dirIdx];
            int ny = cy + dy[dirIdx];
            if(nx > n || ny > m || nx < -n || ny < -m) continue;
            cx = nx;
            cy = ny;
        }

        return new int [] {cx, cy};
    }
}