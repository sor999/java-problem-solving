import java.util.*;
import java.util.stream.*;
class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());

        List<Integer> ans = new ArrayList<>();
        for(int [] command : commands){
            int start = command[0]-1;
            int end = command[1]-1;
            int num = command[2]-1;

            List<Integer> partision = new ArrayList<>(list.subList(start, end+1));

            Collections.sort(partision);

            ans.add(partision.get(num));
        }

        return ans;
    }
}