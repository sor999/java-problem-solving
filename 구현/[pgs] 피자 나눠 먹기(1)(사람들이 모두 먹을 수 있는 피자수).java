class Solution {
    public int solution(int n) {

        int ans = n/7;
        if(n%7 == 0) return ans;

        return ans + 1;
    }
}