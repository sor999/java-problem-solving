/*
3개의 부분 증가 수열 있는지 구하기

방법 1. LIS
n= 5*10^5니까 O(nlonn)또는 O(n)만에 끝내야 한다. dp는 안되고 이분 탐색

방법 2. 구현 - 어차피 3개라 변수 2-3개 직접 만들면 됨.

*/
class Solution {
    //방법 1. LIS
    // public boolean increasingTriplet(int[] nums) {

    //     List<Integer> list = new ArrayList<>();

    //     for(int cur : nums){

    //         int idx = lowerbound(cur, list);

    //         if(idx == list.size()) list.add(cur);
    //         else list.set(idx, cur);

    //         if(list.size() >= 3) return true;
    //     }
    //     return false;
    // }

    // public static int lowerbound(int target, List<Integer> list){
    //     int s = 0;
    //     int e = list.size();

    //     while(s < e){
    //         int mid = (s+e)/2;

    //         if(list.get(mid) >= target){
    //             e = mid;
    //         }else{
    //             s = mid+1;
    //         }

    //     }
    //     return e;
    // }

    public boolean increasingTriplet(int[] nums) {

        //방법 2. 구현
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for(int cur : nums){
            if(cur <= first){ // 제일 작음
                first = cur;
            }else if (cur <= second){ // 그 다음으로 작음
                second = cur;
            }else{ // first, second 보단 큼
                return true;
            }
        }
        return false;
    }
}