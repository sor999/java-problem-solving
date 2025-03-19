/*


리스트 사이즈 < 3 -> 그냥 넣기  + 5
else -> 모든 배열 돌기. 있음 -> 1 , 빼서 맨 뒤로 가져오기 / 없음 -> 맨 앞에 빼기, 맨 뒤에 넣기

아무리 해도 60*100000 -> 완탐 가능

대소문자 구분 x -> 소문자로



*/
import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int ans = 0;

        if(cacheSize == 0) return cities.length * 5; // 엣지케이스

        List<String> cache = new ArrayList<>();
        for(String v : cities){
            String lowV = v.toLowerCase();
            boolean isHit = cache.contains(lowV);

            if(isHit){
                ans+= 1;
                cache.remove(lowV);
                cache.add(lowV);
            }else{
                ans+= 5;
                if(cache.size() >= cacheSize) cache.remove(0);
                cache.add(lowV);
            }
        }
        return ans;
    }
}