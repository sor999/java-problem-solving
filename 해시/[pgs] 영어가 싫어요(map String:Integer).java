/*
영어 단어를 넣는 것 -> hash
각각의 숫자가 있으니 map -> 영어 : 대응되는 숫자

영어 길이 만큼 건너 뛰자. -> 50*10
*/
import java.util.*;
class Solution {
    public long solution(String numbers) {

        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = Map.of(
                "zero", 0, "one", 1, "two", 2, "three", 3, "four", 4, "five", 5, "six", 6, "seven", 7, "eight", 8, "nine", 9
        );
        for(int i=0; i<numbers.length();){
            String temp = numbers.substring(i, numbers.length());
            for(String key : map.keySet()){
                if(temp.indexOf(key) == 0){
                    sb.append(map.get(key));
                    i += key.length();
                    break;
                }
            }
        }
        return Long.parseLong(sb.toString());
    }
}