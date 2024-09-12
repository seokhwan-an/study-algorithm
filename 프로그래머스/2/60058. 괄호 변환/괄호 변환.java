import java.util.*;

class Solution {  
    
    public String solution(String p) {
        return makeCorrect(p);
    }
    private String makeCorrect(String p) {
        if (p.isEmpty()) {
            return "";
        }
        
        String[] split = splitInput(p);
        String u = split[0];
        String v = split[1];
        if (isCorrect(u)) {
            return u + makeCorrect(v);
        } else {
            u = makeCorrectString(u);
           return "(" + makeCorrect(v) + ")" + u;
        }
    }
    
    private boolean isCorrect(String p) {
        char[] chars = p.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for (char c : chars) {
            if (c == '(') {
                stack.push(c);
                continue;
            } 
            
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() == ')') {
                    return false;
                }
                stack.pop();
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        }
        
        return false;
    }
    
    private String[] splitInput(String p) {
        String[] split = new String[2];
        
        char[] chars = p.toCharArray();
        int left = 0;
        int right = 0;
        int index = 0;
        
        for (char c : chars) {
            if (left != 0 && right != 0 && left == right) {
                break;
            }
            
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                right++;
            }
            index++;
        }
        
        split[0] = p.substring(0, index);
        split[1] = p.substring(index);
        
        return split;
    }
    
    private String makeCorrectString(String u) {
        String removeFirstLast = u.substring(1, u.length() - 1);
        char[] chars = removeFirstLast.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c == '(') {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }
        
        return sb.toString();
    }
}