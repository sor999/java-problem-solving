/*
문자 뒤집기.

trim으로 앞뒤 공백 제거, 정규표현식으로 1개 이상의 공백 제거
sb로 마지막에만 공백 안들어가게 해서 str을 뒤에서부터 추가해주면 됨

O(n)
*/
class Solution {
    public String reverseWords(String s) {
        String [] str = s.trim().split("[ ]+");
        
        StringBuilder sb = new StringBuilder();

        for(int i=str.length-1; i>=0; i--){
            sb.append(str[i]);
            if(i!=0) sb.append(" ");
        }

        return sb.toString();
    }
}
