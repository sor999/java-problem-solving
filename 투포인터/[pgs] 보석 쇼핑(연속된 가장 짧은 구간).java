/*
모든 보석을 하나 이상 포함하도록 보석 구매
- 항상 연속된 범위를 선택해야함
n = 10^5니까 n or nlogn으로 끝낸다

투포인터 -> n
- 전체 보석 개수를 구한다. -> o(n)
- 투포인터로 map을 통해 String : Integer로 보석 : 보석의 개수 저장한다.
    - 전체 보석 개수 > 현재 map.size -> end++
    - else ->
        - 연속길이 개수 min값 갱신 -> ans
        - start++ 하면서 start에 해당하는 cnt--
*/
import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int min = 100001;
        int [] ans = new int [2];

        Set<String> set = new HashSet<>();

        for(String str : gems){
            set.add(str);
        }

        int gemsTotalSize = set.size();
        Map<String, Integer> map = new HashMap<>();

        int s = 0;
        int e = 0;

        map.put(gems[s], 1);

        while(s <= e && e < gems.length){
            if(gemsTotalSize > map.size()){
                e++;
                if(e >= gems.length) break;
                map.put(gems[e], map.getOrDefault(gems[e], 0) + 1);

            }else{
                if(min > e - s){
                    min = e - s;
                    ans[0] = s+1;
                    ans[1] = e+1;
                }

                if(map.get(gems[s]) == 1){
                    map.remove(gems[s]);
                }else{
                    map.put(gems[s], map.get(gems[s]) - 1);
                }
                s++;
            }
        }

        return ans;
    }
}