class Solution {
    public boolean isSubsequence(String s, String t) {
        //방법1. 이중 for문
        // int j = 0; // s의 인덱스 위치
        // if(s.length() == 0) return true;
        // for(int i=0; i<t.length(); i++){
        //     if(t.charAt(i) == s.charAt(j)) j++;
        //     if(j >= s.length()) return true; // s의 문자를 모두 발견하면 true
        // }

        // return false;

        //방법2. while
        int sp = 0;
        int tp = 0;
        while(sp<s.length() && tp <t.length()){
            if(s.charAt(sp) == t.charAt(tp)){
                sp++;
            }
            tp++;
        }
        return sp == s.length();
    }
}