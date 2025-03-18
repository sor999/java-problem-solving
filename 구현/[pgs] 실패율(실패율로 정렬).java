/*

스테이지 번호 : 실패율
실패율로 sort

*/
import java.util.*;
class Solution {
    public List<Integer> solution(int N, int[] stages) {
        int [] cnt = new int [N+2]; // 마지막 스테이지 수를 세준다.
        Map<Integer, Double> map = new HashMap<>();
        for(int v : stages){
            cnt[v]++;
        }
        int down = stages.length;
        for(int i=1; i<=N; i++){
            int up = cnt[i];
            if(down == 0){ // 분모 0 일 경우 예외처리
                map.put(i, (double)0);
                continue;
            }
            map.put(i, (double)up/down);
            down -= up;
        }

        List<Integer> ans = new ArrayList<>(map.keySet());

        Collections.sort(ans, (a,b) -> Double.compare(map.get(b),map.get(a)));

        return ans;
    }
}