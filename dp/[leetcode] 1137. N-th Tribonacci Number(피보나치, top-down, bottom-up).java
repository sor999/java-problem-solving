class Solution {
    // //방법1. bottom-up
    // public int tribonacci(int n) {
    //     int [] dp = new int [n+1];
    //     dp[1] = dp[2] = 1;

    //     for(int i=3; i<=n; i++){
    //         dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    //     }

    //     return dp[n];
    // }

    //방법2. top-down
    public int tribonacci(int n) {
        int [] dp = new int [n+1];
        Arrays.fill(dp, -1);
        return dfs(n, dp);
    }

    public int dfs(int n, int [] dp){

        if(dp[n] != -1) return dp[n]; // 먼저 memo된 게 있으면 바로 사용.
        int result = 0;
        if(n == 0) result = 0;
        else if(n == 1 || n == 2) result = 1;
        else result = dfs(n-1, dp) + dfs(n-2, dp)+ dfs(n-3, dp); // 바로 return 치지 말고 값을 저장해뒀다가 나중에 한번에 return 하자.

        dp[n] = result; // memo 해주기
        return result;
    }

}