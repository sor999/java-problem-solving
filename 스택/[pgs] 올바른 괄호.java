import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stk = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '('){
                stk.add(c);
            }else{

                if(stk.isEmpty()) return false;
                if(!stk.isEmpty() && stk.peek() == '('){
                    stk.pop();
                }
            }
        }

        if(stk.isEmpty()) return true;

        return false;
    }
}