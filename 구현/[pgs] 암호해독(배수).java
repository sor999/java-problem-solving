class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();

        for(int i=code-1; i<cipher.length();){
            sb.append(cipher.charAt(i));

            i+=code;
        }
        return sb.toString();
    }
}