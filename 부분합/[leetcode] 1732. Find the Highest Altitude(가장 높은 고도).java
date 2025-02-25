/*
0에서 시작해서 변하는 높이가 주어질 때 최대 고도
 */
class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int max = 0;
        for(int v : gain){
            sum += v;
            max = Math.max(sum, max);
        }
        return max;
    }
}