/*
O(n^2)도 괜찮긴함
포인터 i로 전체 돌리며
같은 값이면 cnt 세주기
cnt > 1 일때와 아닐 때 구분해서 숫자 셈
chars[ans]가 배열 업데이트해야하는 위치

*/
class Solution {
    public int compress(char[] chars) {
        int ans = 0;
        for(int i=0; i<chars.length; i++){
            char cur = chars[i];
            int cnt = 0;
            while(i < chars.length && cur == chars[i]){
                i++;
                cnt++;
            }
            i--;
            chars[ans] = cur;
            ans++;
            if(cnt > 1){
                for(char v : String.valueOf(cnt).toCharArray()){
                    chars[ans] = v;
                    ans++;
                }
            }
        }

        return ans;
    }
}