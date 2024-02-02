import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        Queue<ChangedWord> queue = new LinkedList<>();
        queue.offer(new ChangedWord(begin, 0));
        
        while(!queue.isEmpty()) {
            ChangedWord word = queue.poll();
            
            if (word.getWord().equals(target)) {
                answer = word.getChangeCnt();
                break;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isOneDifferent(word.getWord(), words[i])) {
                    visited[i] = true;
                    queue.add(new ChangedWord(words[i], word.getChangeCnt() + 1));
                }
            }
        }
        
        return answer;
    }
    
    private boolean isOneDifferent(String word, String changedWord) {
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            char oneOfWord = word.charAt(i);
            char oneOfChangedWord = changedWord.charAt(i);
            
            if (oneOfWord != oneOfChangedWord) {
                cnt++;
            }
        }
        
        if (cnt == 1) {
            return true;
        }
        return false;
    }
    
    static class ChangedWord {
        String word;
        int changeCnt;
        
        public ChangedWord(String word, int changeCnt) {
            this.word = word;
            this.changeCnt = changeCnt;
        }
        
        public String getWord() {
            return this.word;
        }
        
        public int getChangeCnt() {
            return this.changeCnt;
        }
    } 
}