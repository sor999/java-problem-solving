/*
길이가 다르면 미리 false
//방법1
스왑 어디서든 가능 = 위치 상관 없다
결국 알파벳의 종류와 개수만이 상관 있음 -> map
//방법2 배열로 테이블 생성 -> 나중에 다시 풀거
*/
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i=0; i<word1.length() ; i++){
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0)+1);
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0)+1);
        }

        List<Character> c1 = new ArrayList<>(map1.keySet());
        List<Character> c2 = new ArrayList<>(map2.keySet());

        Collections.sort(c1);
        Collections.sort(c2);

        if(!c1.equals(c2)) return false;

        List<Integer> i1 = new ArrayList<>(map1.values());
        List<Integer> i2 = new ArrayList<>(map2.values());

        Collections.sort(i1);
        Collections.sort(i2);
        if(!i1.equals(i2)) return false;

        return true;
    }
}