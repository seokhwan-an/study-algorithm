import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> hamberger = new ArrayList<>();
        
        for (int i : ingredient) {
            hamberger.add(i);
            
            if (hamberger.size() >= 4) {
                int last = hamberger.size();
                if (hamberger.get(last - 1) == 1
                   && hamberger.get(last - 2) == 3
                   && hamberger.get(last - 3) == 2
                   && hamberger.get(last - 4) == 1) {
                    answer++;
                    for (int j = 1; j <= 4; j++) {
                        hamberger.remove(last - j);
                    }
                }
            }
        }
        
        return answer;
    }
}