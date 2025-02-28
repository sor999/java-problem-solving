/*
방법1. 투포인터
문자열에서 k의 부분 문자열을 추출할 때 가장 많이 포함한 모음 갯수

항상 k개의 문자열이니까 투포인터로 하면 될듯 - 오른쪽/왼쪽 포인터 늘림
그 포인터에 모음이 없어지거나 생기는 갯수 반영
max값을 업뎃한다

방법2. 포인터 1개와 -k를 활용
*/
class Solution {
    // 방법1.
    // public int maxVowels(String s, int k) {
    //     int l=0;
    //     int r=k-1;
    //     int cnt=0;
    //     Set<Character> set = Set.of('a','e','i','o','u');
    //     for(int i=0; i<k; i++){
    //         if(set.contains(s.charAt(i))) cnt++;
    //     }

    //     int max = cnt;

    //     while(r+1<s.length()){
    //         if(set.contains(s.charAt(l))) cnt--;
    //         if(set.contains(s.charAt(r+1))) cnt++;
    //         max = Math.max(cnt, max);
    //         l++;
    //         r++;
    //     }
    //     return max;
    // }
    //방법2.
    public int maxVowels(String s, int k) {
        int idx=k;
        int cnt=0;
        Set<Character> set = Set.of('a','e','i','o','u');
        for(int i=0; i<k; i++){
            if(set.contains(s.charAt(i))) cnt++;
        }

        int max = cnt;

        while(idx<s.length()){
            if(set.contains(s.charAt(idx-k))) cnt--;
            if(set.contains(s.charAt(idx))) cnt++;
            max = Math.max(cnt, max);
            idx++;
        }
        return max;
    }
}