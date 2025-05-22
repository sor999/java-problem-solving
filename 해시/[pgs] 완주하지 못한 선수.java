import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for(String str : participant){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for(String str : completion){
            if(map.get(str) <= 1) map.remove(str);
            else map.put(str, map.get(str) - 1);

        }
        String ans = null;
        for(String key : map.keySet()){
            ans = key;
        }
        return ans;
    }
}