class Solution {
    public int solution(int[] array, int n) {

        int num = 100;
        int minDiff = 100;

        for(int v : array){
            int diff = Math.abs(v - n);
            if(diff <= minDiff){
                if(diff == minDiff){
                    num = Math.min(num, v);
                }else{
                    num = v;
                }
                minDiff = diff;
            }
        }
        return num;
    }
}