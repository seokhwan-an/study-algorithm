class Solution {
    public int solution(int n) {
        int answer = 0;
        int oneCnt = Integer.bitCount(n);
        int nextNumber = n + 1;
        
        while(true) {
            if (oneCnt == Integer.bitCount(nextNumber)) {
                answer = nextNumber;
                break;
            }
                
            nextNumber += 1;
        }
        return answer;
    }
}