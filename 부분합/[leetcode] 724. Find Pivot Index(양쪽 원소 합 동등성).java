/*
1. 미리 배열을 만들어서 왼쪽에서 시작하는 부분합, 오른쪽에서 시작하는 부분합 따로 만들면 구현 쉬울것
2. 아님 미리 더해놓고 왼쪽은 빼는 것으로 생각
*/
class Solution {
    public int pivotIndex(int[] nums) {
        int l = 0;
        int r = 0;
        //방법 2
        for(int v : nums){
            r += v;
        }
        for(int i=0; i<nums.length; i++){
            r -= nums[i];
            if(l == r) return i;
            l += nums[i];
        }


        return -1;
    }
}