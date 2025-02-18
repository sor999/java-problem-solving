/*
모음만 뒤집어 배치하기

알아야 할 것은 모음 위치,
모음에 있는 값들을 reverse한 값

n = 10^5 정도 되니까 O(n) 만에 끝내자
방법 1. 투포인터로 왼쪽 모음 -> 오른쪽 모음 위치 찾아서 뒤집기 -> 시간 적게 걸릴듯
방법 2. sb에 먼저 모음 담아놓고 뒤집은 후 다시 배치하기 -> 더 구현은 간단할듯
*/
class Solution {
    public String reverseVowels(String s) {
        char [] str = s.toCharArray();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length; i++){
            if(vowels.contains(str[i])) sb.append(str[i]);
        }
        char [] reverse = sb.reverse().toString().toCharArray();


        int idx = 0;
        for(int i=0; i<str.length; i++){
            if(vowels.contains(str[i])){
                str[i] = reverse[idx];
                idx++;
            }
        }

        return new String(str);


    }
}
