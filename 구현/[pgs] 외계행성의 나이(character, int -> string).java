/*
더 효율적: 한글자씩 바꾼다.
 */
import java.util.*;
class Solution {
    public String solution(int age) {
        String str = Integer.toString(age);
        for(int i=0; i<10; i++){
            str = str.replaceAll(Integer.toString(i), Character.toString((char)(i + 'a')));
        }
        return str;
    }
}