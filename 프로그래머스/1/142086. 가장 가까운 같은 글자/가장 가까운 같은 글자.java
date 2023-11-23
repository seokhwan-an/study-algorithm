import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<String, Integer> checker = new HashMap<>();
        String[] split = s.split("");
        
        for(int i = 0; i < split.length; i++) {
            String str = split[i];
            if (!checker.containsKey(str)) {
                answer[i] = -1;
                checker.put(str, i);
            } else {
                answer[i] = i - checker.get(str);
                checker.put(str, i);
            }
        }
        return answer;
    }
}