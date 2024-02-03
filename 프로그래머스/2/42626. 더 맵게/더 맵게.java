import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        int minScoville = Integer.MAX_VALUE;
        for (int i = 0; i < scoville.length; i++) {
            queue.offer(scoville[i]);
            if (minScoville > scoville[i]) {
                minScoville = scoville[i];
            }
        }
        
        if (minScoville >= K) {
            return 0;
        }
        
        while(!(minScoville >= K) && queue.size() > 2) {
            int food1 = queue.poll();
            int food2 = queue.poll();
            int newScoville = food1 + 2 * food2;
            int nextFoodScoville = queue.peek();
            minScoville = Math.min(newScoville, nextFoodScoville);
            answer++;
            queue.offer(newScoville);
        }
        
        if (minScoville >= K) {
            return answer;
        } else {
            int food1 = queue.poll();
            int food2 = queue.poll();
            int newScoville = food1 + 2 * food2;
            if (newScoville >= K) {
                return answer + 1;
            } else {
                return -1;
            }
        }
    }
}