class Solution {
    public long solution(int n, int[] money) {
        int answer = 0;
        long inf = 1_000_000_007;
        
        long[] dp = new long[n + 1];
        
        for (int i = 0; i < money.length; i++) {
            int cur = money[i];
            if (cur > n) {
                continue;
            }
            dp[cur] += 1;
            for (int j = 1; j <= n; j++) {
                if (j - cur >= 0) {
                    dp[j] += dp[j - cur];
                    dp[j] %= inf;
                }
            }
        }
        return dp[n];
    }
}