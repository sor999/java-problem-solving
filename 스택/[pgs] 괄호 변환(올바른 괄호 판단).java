
/*
균형잡힌: '(' 개수 == ')'
올바른: 스택
u와 v로 나눈다.
u는 2의 배수로 자름. 올바른 이라면 그래야함
v는 공백이 되니까, u는 p길이까지 가능

()들어가야. ㅇ
*/
import java.util.*;
class Solution {
    public String solution(String p) {



        return recurse(p);
    }

    private String reverse(String str){
        StringBuilder sb = new StringBuilder();

        for(char c : str.toCharArray()){
            if(c == '(') sb.append(")");
            else sb.append("(");
        }
        return sb.toString();
    }



    private String recurse(String str){
        if(str.length() == 0 || isValid(str)) return str;
        String u = "";
        String v = "";
        int a = 0;
        int b = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '(') a++;
            else b++;
            if(a==b){
                u = str.substring(0,i+1);
                v = str.substring(i+1, str.length());
                break;
            }
        }


        if(isValid(u)){
            return u + recurse(v);
        }else{
            return '(' + recurse(v) + ')' + reverse(u.substring(1, u.length()-1));
        }

    }

    private static boolean isValid(String str){
        Stack<Character> st = new Stack();
        for(char c : str.toCharArray()){
            if(c == '(') st.add('(');
            else{
                if(!st.isEmpty()) st.pop();
                else return false;
            }
        }
        return st.isEmpty() ? true : false;
    }
}