/*
응급도의 순서대로 정렬을 하게 된다면 원래 자리가 어디었는지 원래의 위치에 저장해야한다.
응급도, 원래 자리, 우선순위

- 자신보다 큰 값 conut하면 순위
- 자리를 Map에 저장해도 됨
*/
import java.util.*;
class Solution {
    public int[] solution(int[] emergency) {

        int [][] order = new int [emergency.length][2];

        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(int i=0; i<emergency.length; i++){
            pq.offer(new int [] {emergency[i], i});
        }
        int [] ans = new int [emergency.length];
        for(int i=1; i<=emergency.length; i++){
            int [] cur = pq.poll();
            int pos = cur[1];

            ans[pos] = i;
        }

        return ans;
    }
}