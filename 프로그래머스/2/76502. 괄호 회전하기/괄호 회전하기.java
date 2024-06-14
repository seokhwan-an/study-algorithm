import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            int start = i;
            Stack<Character> stack = new Stack<>();
            int cnt = 0;
            boolean available = true;
            while(true) {
                if (cnt == chars.length) {
                    if (!stack.isEmpty()) {
                        available = false;
                    } 
                    break;
                }
                
                cnt++;
                char c = chars[start];
                if (c == '[' || c == '{' || c == '(') {
                    stack.push(c);
                    start = (start + 1) % chars.length;
                    continue;
                } 
                
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }
                
                if (c == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
                
                if (c == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
                
                if (c == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
                
                start = (start + 1) % chars.length;
            }
            
            if (available) {
                answer++;
            }
        }
        return answer;
    }
}

