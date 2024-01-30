class Solution {
    
    static int answer = 0;
    
    public int solution(String s) {
        splitString(s);
        return answer;
    }
    
    private void splitString(String s) {
        if (s.length() == 0) {
            return;
        }
        
        answer += 1;
        int splitLocation = countLetter(s);
        if (splitLocation < s.length()) {
            splitString(s.substring(splitLocation, s.length())); 
        } else {
            splitString("");   
        }
    }
    
    private int countLetter(String s) {
        String firstLetter = s.substring(0, 1);
        int firstLetterCnt = 1;
        int otherLetterCnt = 0;
        
        for (int i = 1; i < s.length(); i++) {
            String letter = s.substring(i, i + 1);
            if (letter.equals(firstLetter)) {
                firstLetterCnt++;
            } else {
                otherLetterCnt++;
            }
            
            if (firstLetterCnt == otherLetterCnt) {
                return i + 1;
            }
        }
        
        return s.length();
    }
}