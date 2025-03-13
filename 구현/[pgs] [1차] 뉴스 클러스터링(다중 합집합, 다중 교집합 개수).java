/*

J = 교집합 / 합집합

a & b 공집합 = 1

다중 min / max

문자열 2개씩 끊어 다중

소문자로 변경, 영어아니면 버리기

1. 집합 a, b 구하기 - 두개씩 끊어 저장 - 만약 모든 요소가 영어가 아니면 탈락. 소문자로 바꿔 저장.
2. 개수 확인 하기 - map을 2개 이용해 저장 문자열 : 개수
3. 합집합, 교집합 구하기.



*/
import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String, Integer> map1 = getMapFromString(str1);
        Map<String, Integer> map2 = getMapFromString(str2);

        System.out.println(map1.keySet());
        System.out.println(map2.keySet());

        //교집합 개수
        int up = 0;
        for(String v : map1.keySet()){
            if(map2.containsKey(v)){
                int cnt1 = map1.get(v);
                int cnt2 = map2.get(v);

                up += Math.min(cnt1, cnt2);
            }
        }

        // 합집합 개수
        int down = 0;
        for(String v : map1.keySet()){
            if(map2.containsKey(v)){
                int cnt1 = map1.get(v);
                int cnt2 = map2.get(v);

                down += Math.max(cnt1, cnt2);
            }else{
                down += map1.get(v); // 다른 집합에 해당이 안되면 개수 만큼 넣어주면 됨.
            }
        }


        for(String v : map2.keySet()){
            if(!map1.containsKey(v)){
                down += map2.get(v);
            }
        }

        if(down == 0) return 1*65536; // 엣지케이스: 교집합이 0 일땐 1로 가정

        return (int)((double)up/down*65536);
    }

    private static Map<String, Integer> getMapFromString(String str){
        char [] chars = str.toCharArray();
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<chars.length-1; i++){

            boolean isAlphabet = true;
            for(int j=0; j<2; j++){
                char c = chars[i+j];
                if(!Character.isAlphabetic(c)){
                    isAlphabet = false;
                    break;
                }
                chars[i+j] = Character.toLowerCase(c);
            }

            String cur = Character.toString(chars[i]) + Character.toString(chars[i+1]);
            if(isAlphabet) map.put(cur, map.getOrDefault(cur, 0)+1);
        }

        return map;
    }
}