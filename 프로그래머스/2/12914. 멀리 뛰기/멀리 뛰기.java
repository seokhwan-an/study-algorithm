class Solution {
    
    private static final int DIVIDED_NUMBER = 1234567; 
    
    public long solution(int n) {
        if (n == 1) {
            return 1;
        }
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % DIVIDED_NUMBER;
        }
        return dp[n];
    }
}