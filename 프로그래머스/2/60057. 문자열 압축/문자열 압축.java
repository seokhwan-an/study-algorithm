/**
문제풀이 아이디어
1. s의 길이가 1000이하 -> 최대 500자로 나누어서 압축하는 것이 가능
2. Stack을 이용해서 처리하는 것이 가장 최적화된 방법인것 같음
*/

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int i = 1; i <= s.length() / 2; i++) {
            int length = getPressLength(s, i);
            answer = Math.min(answer, length);
        }
        
        
        return answer;
    }
    
    private int getPressLength(String s, int i) {
        int length = 0;
        Stack<String> checker = new Stack<>();
        int repeat = 0;
        for (int j = 0; j < s.length(); j += i) {
            String press = getSplit(s, j, j + i);
            if (checker.isEmpty()) {
                checker.push(press);
                length += press.length();
                repeat = 1;
                continue;
            }
            
            if (checker.peek().equals(press)) {
                repeat += 1;
            } else {
                checker.pop();
                if (repeat > 1) {
                    length += repeatLength(repeat);
                }
                repeat = 1;
                checker.push(press);
                length += press.length();
            }
        }
        if (repeat > 1) {
            length += repeatLength(repeat);
        }
        
        return length;
    }
    
    private String getSplit(String s, int start, int end) {
        if (end > s.length()) {
            return s.substring(start, s.length());
        }
        
        return s.substring(start, end);
    }
    
    private int repeatLength(int repeat) {
        if (repeat / 1000 > 0) {
            return 4;
        }
        
        if (repeat / 100 > 0) {
            return 3;
        }
        
        if (repeat / 10 > 0) {
            return 2;
        }
        
        return 1;
    }
}