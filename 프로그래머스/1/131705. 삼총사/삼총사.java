class Solution {
    
    int answer;
    int sum;
    
    public int solution(int[] number) {
        answer = 0;
        sum = 0;
        find(0, -1, number);
        return answer;
    }
    
    private void find(int n, int k, int[] number) {
        if (n == 3) {
            if (sum == 0) {
                answer++;
            }
            
            return;
        }
        
        for (int i = 0; i < number.length; i++) {
            if (i > k) {
                sum += number[i];
                find(n + 1, i, number);
                sum -= number[i];
            }
        }
    }
}