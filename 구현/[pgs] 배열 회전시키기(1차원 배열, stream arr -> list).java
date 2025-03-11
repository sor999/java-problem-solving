import java.util.*;
import java.util.stream.*;
class Solution {
    public List<Integer> solution(int[] numbers, String direction) {
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        if(direction.equals("left")){
            int temp = list.get(0);
            list.remove(0);
            list.add(temp);
        }else{
            int temp = list.get(list.size()-1);
            list.remove(list.size()-1);
            list.add(0, temp);
        }
        return list;
    }
}