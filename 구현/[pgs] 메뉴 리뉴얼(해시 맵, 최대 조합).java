import java.util.*;
class Solution {

    static Map<String, Integer> combMap = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> ans = new ArrayList<>();

        for(int courseLen : course){
            int max = 0;
            combMap = new HashMap<>();

            for(String order : orders){
                char [] arr = order.toCharArray();
                Arrays.sort(arr);
                order = new String(arr);

                comb(order, 0, new StringBuilder(), courseLen);
            }
            for(int cnt : combMap.values()){ // 가장 많이 주문된 횟수
                max = Math.max(max, cnt);
            }

            if(max >=2 ){
                for(Map.Entry<String, Integer> e : combMap.entrySet()){
                    if(e.getValue() == max){
                        ans.add(e.getKey());
                    }
                }
            }
        }
        Collections.sort(ans);
        return ans.toArray(new String[0]);
    }
    private void comb(String order, int at, StringBuilder sb, int len){
        if(sb.length() == len){
            String cur = sb.toString();
            combMap.put(cur, combMap.getOrDefault(cur, 0) + 1);
            return;
        }

        for(int i=at ; i<order.length(); i++){
            sb.append(order.charAt(i));
            comb(order, i+1, sb, len);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}