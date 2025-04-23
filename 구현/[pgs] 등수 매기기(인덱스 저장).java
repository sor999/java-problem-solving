/*
평균 구할 때 각 자리의 인덱스가 필요함
75, 70 55 65
0, 1, 2, 3
55 65 70 75
2 4 1 0 -> idx
ans[idx] = cnt
cnt++

indexOf를 사용하면 가장 작은 인덱스 얻을 수 있음.
*/
import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        List<int []> avg = new ArrayList<>();
        int [] ans = new int [score.length];
        for(int i=0; i<score.length; i++){
            avg.add(new int []{score[i][0] + score[i][1], i});
        }

        Collections.sort(avg, (a,b) -> b[0] - a[0]);

        int idx = avg.get(0)[1];
        ans[idx] = 1;
        int priority = 1;
        for(int i=1; i < avg.size(); i++){
            idx = avg.get(i)[1];

            if(avg.get(i-1)[0] != avg.get(i)[0]){
                priority = i+1;
            }

            ans[idx] = priority;
        }

        return ans;
    }
}