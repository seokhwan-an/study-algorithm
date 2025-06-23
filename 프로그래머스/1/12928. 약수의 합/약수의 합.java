class Solution {
    public int solution(int n) {
        int answer = getAnswer(n);
        return answer;
    }
    
    private int getAnswer(int n) {
        int sum = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                int divide = n / i;
                if (i != divide) {
                   sum += divide; 
                }
                sum += i; 
            }
        }
        
        return sum;
    }
}