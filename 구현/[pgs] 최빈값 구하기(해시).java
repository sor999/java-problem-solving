/*
key : value, 숫자: 빈도수
*/
import java.util.*;
class Solution {
    public int solution(int[] array) {

        if(array.length == 0) return -1;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i : array){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int maxKey = -1;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int v = e.getValue();
            int k = e.getKey();

            if(maxKey == -1){
                maxKey = k;
                continue;
            }

            if(v > map.get(maxKey)){
                maxKey = k;
            }
        }

        int cnt = 0;
        for(int v : map.values()){
            if(v == map.get(maxKey)){
                cnt++;
                if(cnt > 1) return -1;
            }
        }
        return maxKey;
    }
}