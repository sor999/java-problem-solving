import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int start = 0;
        int end = people.length-1;
        int cnt = 0;
        Arrays.sort(people);
        while(start<=end){
            if(people[start] + people[end] <= limit){
                start++;
                end--;
            }else{
                end--;
            }
            // System.out.println(start + " " +end);
            cnt++;
        }

        return cnt;
    }
}