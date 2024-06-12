import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> subContainer = new Stack<>();
        int mainContainer = 1;
        
        for (int i = 0; i < order.length; i++) {
            int need = order[i];
            
            if (need >= mainContainer) {
                while (true) {
                    if (mainContainer == need) {
                        mainContainer++;
                        answer++;
                        break;
                    }
                    
                    subContainer.push(mainContainer++);
                }
            } else {
                if (subContainer.peek() == need) {
                    answer++;
                    subContainer.pop();
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}