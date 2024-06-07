import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            
            // 스택이 비어있는 경우
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            
            if (stack.peek().equals(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        if (stack.isEmpty()) {
            answer = 1;
        }
        
        return answer;
    }
}