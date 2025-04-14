// 해시, 배열로도 풀 수 있지만 replace 가 더 편함
import java.util.*;
class Solution {
    public int solution(String s) {
        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0; i<str.length; i++){
            String num = str[i];

            s = s.replaceAll(num , i+"");
        }
        return Integer.parseInt(s);
    }
}