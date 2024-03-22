

import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliverBox = 0;
        int pickUpBox = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            deliverBox -= deliveries[i];
            pickUpBox -= pickups[i];
            
            while (deliverBox < 0 || pickUpBox < 0) {
                deliverBox += cap;
                pickUpBox += cap;
                answer += (i + 1) * 2;
            }
        }
        
        return answer;
    }
}