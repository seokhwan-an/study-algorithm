import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> cake1 = new HashMap<>();
        Map<Integer, Integer> cake2 = new HashMap<>();
        
        for (int i = 0; i < topping.length; i++) {
            int n = topping[i];
            if (cake1.containsKey(n)) {
                cake1.put(n, cake1.get(n) + 1);
            } else {
                cake1.put(n, 1);
            }
        }
        
        for (int i = 0; i < topping.length; i++) {
            int n = topping[i];
            
            if (cake1.get(n) == 1) {
                cake1.remove(n);
            } else {
                cake1.put(n, cake1.get(n) - 1);
            }
            
            if (cake2.containsKey(n)) {
                cake2.put(n, cake2.get(n) + 1);
            } else {
                cake2.put(n, 1);
            }
            
            
            if (cake1.keySet().size() == cake2.keySet().size()) {
                answer++;
            }
        }
        return answer;
    }
}