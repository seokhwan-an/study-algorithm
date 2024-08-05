class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = getGCD(n, m);
        answer[1] = getLCM(n, m);
        return answer;
    }
    
    private int getLCM(int n, int m) {
        int gcd = getGCD(n, m);
        
        return (n * m) / gcd;
    }
    
    private int getGCD(int n, int m) {
        if (n % m == 0) {
            return m;
        }
        return getGCD(m, n % m);
    }
}