/*
발생횟수가 고유한지 찾기

맵에 넣어서 횟수를 따로 구한다
value만 갖고 온 set의 크기가 map의 크기와 같으면 true
*/
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int v : arr){
            map.put(v, map.getOrDefault(v,0)+1);
        }

        return new HashSet<>(map.values()).size() == map.size();
    }
}