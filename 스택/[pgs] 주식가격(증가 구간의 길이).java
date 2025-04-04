
/*
n or nlogn 안에 끝내야 함
- 스택에 인덱스를 넣어서 값을 찾는다.
i번째의 가격 < 바로 전 저장값 -> i - 바로전 저장값
- 스택에 남아있는 인덱스는 나중에 n에서 빼기

stk : 1 2 3 2
idx : 0 1 2 3
idx == 2, 3 - 2 = 1

stk : 1 2 2 3
idx : 0 1 3 4
ans[4] = 5 - 4 -1 = 0
ans[3] = 5 - 3 -1 = 1
ans[1] = 5 - 1 -1 = 3
ans[0] = 5 - 0 -1 = 4

*/
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stk = new Stack<>();
        int n = prices.length;
        int [] ans = new int [n];
        for(int i=0; i<n; i++){ // 증가하다가 감소하는 시점에 대해서만 바로 처리해주자.
            while(!stk.isEmpty() && prices[i] < prices[stk.peek()]){ // 1 3 5 2
                int top = stk.pop();
                ans[top] = i - top; // ans[2] = 3 - 2 = 1
            }
            stk.push(i);
        }

        while(!stk.isEmpty()){
            int top = stk.pop();
            ans[top] = n - top - 1; // ans[0] = 5 - 0 - 1 = 4

        }
        return ans;
    }
}