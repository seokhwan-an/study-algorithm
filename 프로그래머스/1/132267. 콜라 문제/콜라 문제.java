class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int coke = n;
        
        while (coke >= a) {
            int givenCoke = (coke / a) * b;
            answer += givenCoke;
            coke = coke - (givenCoke / b) * a + givenCoke;
        }
        return answer;
    }
}