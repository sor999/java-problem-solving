/*
슬라이딩 윈도우
*/
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i=0; i<k; i++) sum+=nums[i];
        int max = sum;

        for(int i=k; i<nums.length; i++){
            sum += nums[i];
            sum -= nums[i-k];
            max = Math.max(sum, max);
        }
        return (double)max/k;
    }
}