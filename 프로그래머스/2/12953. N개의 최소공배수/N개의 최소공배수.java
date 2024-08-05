class Solution {
    public int solution(int[] arr) {
        int answer = getLCM(arr);
        return answer;
    }
    
    private int getLCM(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int gcd = getGCD(arr[0], arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;
        
        for (int i = 2; i < arr.length; i++) {
            gcd = getGCD(lcm, arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }
        
        return lcm;
    }
    
    private int getGCD(int n, int m) {
        if (n % m == 0) {
            return m;
        }
        
        return getGCD(m, n % m);
    }
}