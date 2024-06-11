class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        
        int attendee1 = Math.min(a, b);
        int attendee2 = Math.max(a, b);
        
        while(true) {
            answer++;
            if (isMatched(attendee1, attendee2)) {
                break;
            }
            
            attendee1 = nextRound(attendee1);
            attendee2 = nextRound(attendee2);
        }

        return answer;
    }
    
    private boolean isMatched(int attendee1, int attendee2) {
        if (attendee2 % 2 != 0) {
            return false;
        }
        
        if (attendee1 % 2 != 1) {
            return false;
        }
        
        if (attendee1 + 1 == attendee2) {
            return true;
        }
        
        return false;
    }
    
    private int nextRound(int attendee) {
        if (attendee % 2 == 1) {
            return (attendee + 1) / 2;
        }
        
        return attendee / 2;
    }
}