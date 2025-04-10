
/*
해시로 풀까 고민했다. treeMap 을 이용하면 자동 정렬이긴 한데 nlogn이 걸리기 때문에,
그냥 배열을 이용했다.
 */
class Solution {
    public String solution(String s) {
        int [] alphabet = new int [26];

        for(char c : s.toCharArray()){
            alphabet[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            if(alphabet[i] == 1){
                sb.append((char)(i+'a'));
            }
        }

        return sb.toString();
    }
}