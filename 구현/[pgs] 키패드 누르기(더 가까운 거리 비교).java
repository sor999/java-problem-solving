/*

2, 5, 8, 0이면 거리 구하기 -> bfs
그게 아니면 1, 4, 7 -> R,
3,6,9 -> L
맨처음은 둘다 거리 같을태니, 예외처리
위치 저장 -> 숫자 다 저장 & 각 수마다 x, y를 저장.
맵 or 이차배열로 으로 저장.
*/
import java.util.*;
class Solution {
    private static int right = -1;
    private static int left = -2;

    private static Map<Integer, int []> map = new HashMap<>();
    public String solution(int[] numbers, String hand) {

        Set<Integer> leftSet = Set.of(1,4,7);
        Set<Integer> rightSet = Set.of(3,6,9);

        for(int i=1; i<=9; i++){
            map.put(i, new int [] {(i-1)/3, (i-1)%3});
        }

        map.put(0, new int []{3,1});
        map.put(-1, new int []{3,0});
        map.put(-2, new int []{3,2});

        StringBuilder sb = new StringBuilder();
        for(int v : numbers){
            if(leftSet.contains(v)){
                left = v;
                sb.append("L");
            }else if(rightSet.contains(v)){
                right = v;
                sb.append("R");
            }else{
                sb.append(getDist(v, hand));
            }
        }

        return sb.toString();
    }
    private static String getDist(int num, String hand){
        int [] cur = map.get(num);
        int cx = cur[0];
        int cy = cur[1];

        int [] r = map.get(right);
        int rx = r[0];
        int ry = r[1];

        int [] l = map.get(left);
        int lx = l[0];
        int ly = l[1];

        int rdist = Math.abs(cx - rx) + Math.abs(cy - ry);
        int ldist = Math.abs(cx - lx) + Math.abs(cy - ly);

        if(rdist > ldist){
            left = num;
            return "L";
        }else if (rdist < ldist){
            right = num;
            return "R";
        }else{
            //      if(num == 8){
            //     System.out.print(left + " " + right + " " + hand.equals("right"));
            // }
            if(hand.equals("right")){
                right = num;
                return "R";
            }else{
                left = num;
                return "L";
            }
        }


    }

}