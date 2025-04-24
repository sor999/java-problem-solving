import java.util.*;
class Solution {
    public int solution(String my_string) {
        int sum = 0;
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            String str = "0";
            if(Character.isDigit(c)){
                while(i < my_string.length() && Character.isDigit(my_string.charAt(i))){
                    c = my_string.charAt(i);
                    str += c;
                    i++;
                }
            }
            sum += Integer.parseInt(str);
        }

        return sum;
    }
}