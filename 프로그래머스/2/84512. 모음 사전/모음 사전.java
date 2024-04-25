import java.util.*;

class Solution {
    
    String[] alphabets = {"A", "E", "I", "O", "U"};
    List<String> words = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        
        findWord("", 0);
        
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    private void findWord(String str, int depth) {
        words.add(str);
        
        if (depth == 5) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            findWord(str + alphabets[i], depth + 1);
        }
    }
}