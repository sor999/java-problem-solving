import java.util.*;
class Solution {
    //a + (a+1) + .. +(a+num-1) = a*num + 1 + ... + num-1 = num(num-1)/2 + a*num = num(a + (num -1)/2) == total -> a = total/num + num-1/2
    public int[] solution(int num, int total) {
        int s = (total - num*(num-1)/2)/num;

        List<Integer> ans = new ArrayList<>();
        for(int i=s; i<s+num; i++){
            ans.add(i);
        }


        return ans.stream().mapToInt(i->i).toArray();
    }
}