/*
최댓값만큼 뛸 수 있지 않나?
1. 완탐 -> 2억번 가능
5만 살아남는다 가정
0 0 5 0 0 0 0 0 5 0 -> 불가
4
0 4 5 0 0 0 4 0 5 1 -> 불가
3
0 4 5 3 0 0 4 0 5 0 -> 가능

2. k를 stones길이로 잡고 하나씩 내리면서 구하자. -> n^2
3. 우선순위큐 -> 끝점을 내보낼 수가 없음 -> X
3. 슬라이딩 윈도우 + 최댓값 -> n^2
4. 이분탐색 - 파라메트릭 서치(최적화 -> 결정) -> nlogm


고려할 점
1. 디딤돌 거리 수 k -> k만큼의 공백이 있으면 안되니, k개 이하의 원소를 0으로 만들고 연속 몇개가 0인지 찾을까? -

2. 디딤돌의 최댓값 max
3. stones의 길이 -> 0의 개수가 달라질 수 있으니?

*/

// 3. 슬라이딩 윈도우: 효율성 테스트 실패
// import java.util.*;
// class Solution {
//     public int solution(int[] stones, int k) {

//         Queue<Integer> q = new LinkedList<>();


//         for(int i=0; i<Math.min(k, stones.length); i++){
//             q.offer(stones[i]);
//         }
//         // int min = pq.peek();
//         int min = Integer.MAX_VALUE;

//         if(true){
//             List<Integer> list = new ArrayList<>(q);
//             int max = 0;
//             for(int v : list){
//                 max = Math.max(v, max);

//             }

//             // System.out.println(q);
//             min = Math.min(min, max);
//         }


//         int s = 0;
//         for(int e=k; e<stones.length; e++){

//             q.offer(stones[e]);
//             q.poll();

//             List<Integer> list = new ArrayList<>(q);
//             int max = 0;
//             for(int v : list){
//                 max = Math.max(v, max);
//             }

//             min = Math.min(min, max);
//         }

//         return min;
//     }
// }
/*
4.이분탐색 - 파라메트릭 서치

왜냐면 특정 명수 이하까지는 100% 가능, 특정 명수 이상부터는 100% 불가능한 상황

최대 몇명 징검다리 통과 가능?(최적화문제) -> a명이 최대 칸수 k일때 건널 수 있나?(결정문제)


최소 명수, 최대 명수 구한 다음, 그 사이의 a명을 선택.(이분탐색의 target 대상)
TTTTTFFFF 같은 구조

*/
import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {

        int end = 0;
        int start = Integer.MAX_VALUE;

        for(int v : stones){
            end = Math.max(end, v);
            start = Math.min(start, v);
        }

        int result = 0;
        while(start <= end){
            int mid = (start + end)/2;

            if(isValid(mid, k, stones)){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return end;
    }

    private static boolean isValid(int target, int k, int [] stones){
        int cnt = 0;
        for(int v : stones){
            if(v - target >= 0){
                cnt = 0;
            }else{
                cnt++;
            }

            if(cnt >= k) return false;
        }
        return true;
    }
}