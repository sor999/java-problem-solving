
import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        int m = board[0].length;
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for(int move : moves){
            move = move -1;
            int doll = -1;
            for(int i=0; i<n; i++){
                if(board[i][move] != 0){
                    doll = board[i][move];
                    board[i][move] = 0; // 0으로 처리해줘야 하는 거 주의
                    break;
                }
            }

            if(doll != -1){
                if(list.size() >= 1 && list.get(list.size() -1) == doll){

                    list.remove(list.size()-1);
                    cnt+=2;

                }else{
                    list.add(doll);
                }
            }
        }
        return cnt;
    }
}