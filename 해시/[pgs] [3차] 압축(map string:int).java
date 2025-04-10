/*

원본 <-> 압축

길이 1. 모든 단어 사전 초기화. -> List<String> : word

-> 더 나은 방법: Map word : idx -> contains를 word에 걸어야 하니까.색인번호는 따로 idx 변수 생성

입력에서 w를 제거한다 -> msg 인덱스 ++.

*/
import java.util.*;
class Solution {
    public List<Integer> solution(String msg) {
        Map<String, Integer> wordMap = new HashMap<>();

        for(int i=0; i<26; i++){
            wordMap.put(Character.toString((char)(i + 'A')), i+1);
        }

        int idx = 27;

        List<Integer> ans = new ArrayList<>();
        System.out.println(wordMap.keySet());

        int s = 0;
        while(s < msg.length()){

            String w = Character.toString(msg.charAt(s));

            int e = s + 1;

            while(e < msg.length()){
                String wc = w + msg.charAt(e);

                if(!wordMap.containsKey(wc)){
                    break;
                }
                w = wc;
                e++;
            }

            ans.add(wordMap.get(w));

            if (e < msg.length()){

                String wc = w + msg.charAt(e);
                wordMap.put(wc, idx);
                idx++;
            }
            s = e;
        }
        return ans;
    }
}