import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(int[] numbers) {

        List<String> str = Arrays.stream(numbers).boxed().map(i -> Integer.toString(i)).collect(Collectors.toList());

        Collections.sort(str, (a,b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();

        if(str.get(0).equals("0")) return "0";

        for(String cur : str){
            sb.append(cur);
        }

        return sb.toString();
    }
}