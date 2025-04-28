
class Solution {
    public int solution(int[] numbers, int k) {
        int idx = 0;
        int n = numbers.length;
        for(int i=0; i<k-1; i++){
            idx+=2;
            idx%=n;
        }

        return numbers[idx];
    }
}