/*
공백으로 나누어져 있으니 공백으로 파싱
모스부호에 해당하는 알파벳에 대해 O(1)만에 검색을 하면 좋다.-> Map 모스부호:알파뱃
*/
import java.util.*;
class Solution {
    public String solution(String letter) {
        String [] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String [] letters = letter.split(" ");

        Map<String, String> morseMap = new HashMap<>();
        for(int i=0; i<morse.length; i++){
            String value = Character.toString(i + 'a');
            String key = morse[i];
            morseMap.put(key, value);
        }
        StringBuilder sb = new StringBuilder();
        for(String str : letters){
            sb.append(morseMap.get(str));
        }


        return sb.toString();
    }
}