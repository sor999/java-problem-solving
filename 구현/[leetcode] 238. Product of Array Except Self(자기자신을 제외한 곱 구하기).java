/*
방법1. zero의 카운트를 셈
자신을 제외한 모든 곱 출력
미리 곱해놓고 자신을 나누면 O(n)에 해결
0일때 예외 케이스가 있으니까 제외 해서 곱해 놓았다가
내가 0 이면 나머지 곱만 가져오면 된다.
내가 0이 아닌데, 다른 0이 있으면 0이다.
근데 0이 2개 이상이면 다 0이 될 수밖에 없다.

방법2. 왼쪽 곱, 오른쪽 곱을 따로 구함
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {

        // //방법 1. zero의 카운트를 셈
        // int zeroCnt = 0;
        // int product = 1;
        // for(int v : nums){
        //     if(v==0) zeroCnt++;
        //     else product *= v;
        //     if(zeroCnt >= 2) break;
        // }

        // int [] ans = new int[nums.length];
        // if(zeroCnt >= 2) return ans;

        // for(int i=0; i<nums.length; i++){
        //     if(nums[i] == 0) ans[i] = product;
        //     else if(zeroCnt >= 1) ans[i] = 0;
        //     else ans[i] = product/nums[i];
        // }

        // return ans;

        //방법 2. 현재값을 제외하고 왼쪽, 오른쪽 따로 구하기

        int [] ans = new int[nums.length];

        Arrays.fill(ans, 1);

        int left = 1;
        for(int i=0; i<nums.length; i++){ // 왼 -> 오
            ans[i] *= left; // 현재 기준 왼쪽만 포함한 곱
            left *= nums[i]; // 현재 값까지 포함한 곱
        }

        int right = 1;
        for(int i=nums.length-1; i>=0; i--){ // 오-
            ans[i] *= right; // 현재 기준 오른쪽만 포함한 곱
            right *= nums[i]; //  현재 값까지 포함한 곱
        }
        return ans;
    }
}