class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = findAnswer(brown, yellow);
        return answer;
    }
    
    private int[] findAnswer(int brown, int yellow) {
        int total = brown + yellow;
        int[] answer = new int[2];
        
        for (int i = 3; i <= Math.sqrt(total); i++) {
            if (total % i == 0) {
                int h = i;
                int w = total / i;
                
                if (h < 3 || w < 3) {
                    continue;
                }
                
                int yellowCheck = (h - 2) * (w - 2);
                int brownCheck = total - yellowCheck;
                
                if (yellow == yellowCheck && brown == brownCheck) {
                    answer[0] = Math.max(h, w);
                    answer[1] = Math.min(h, w);
                    break;
                }
            }
        }
        return answer;
    }
}