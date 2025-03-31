import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        int n = queue1.length;

        for (int v : queue1) {
            sum1 += v;
        }
        for (int v : queue2) {
            sum2 += v;
        }

        // 합이 홀수면 절대 불가
        long totalSum = sum1 + sum2;
        if (totalSum % 2 != 0) {
            return -1;
        }

        long target = totalSum / 2;
        int[] combined = new int[n * 2];
        Queue<Integer> q1 = new LinkedList<>(Arrays.stream(queue1).boxed().map(i->i).collect(Collectors.toList()));
        Queue<Integer> q2 =new LinkedList<>(Arrays.stream(queue2).boxed().map(i->i).collect(Collectors.toList()));
        long curSum = sum1;
        int moves = 0;
        int cnt = 0;
        while(!q1.isEmpty() && !q2.isEmpty() && cnt++ < 4*n){
            if (curSum == target){
                return moves;
            } else if (curSum > target){
                q2.offer(q1.peek());
                curSum -= q1.poll();


            } else{
                q1.offer(q2.peek());
                curSum += q2.poll();

            }
            moves++;
        }

        return -1;
    }
}

//풀이참고
import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        int n = queue1.length;

        for (int v : queue1) {
            sum1 += v;
        }
        for (int v : queue2) {
            sum2 += v;
        }

        // 합이 홀수면 절대 불가
        long totalSum = sum1 + sum2;
        if (totalSum % 2 != 0) {
            return -1;
        }

        long target = totalSum / 2;
        int[] combined = new int[n * 2];

        System.arraycopy(queue1, 0, combined, 0, n);
        System.arraycopy(queue2, 0, combined, n, n);

        int left = 0, right = n;
        long curSum = sum1;
        int moves = 0;

        while (left < right && right < 2 * n) {
            if (curSum == target) {
                return moves;
            } else if (curSum > target) {
                curSum -= combined[left];
                left++;
            } else {
                curSum += combined[right];
                right++;
            }
            moves++;
        }

        return -1;
    }
}