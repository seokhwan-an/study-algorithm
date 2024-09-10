import java.util.*;

class Solution {
    
    class Stone {
        Integer count;
        boolean available;
        
        public Stone(int count, boolean available) {
            this.count = count;
            this.available = available;
        } 
        
    }
    
    public int solution(int[] stones, int k) {
        int answer = 0;
        List<Stone> stoneList = new ArrayList<>();
        for (int stone : stones) {
            stoneList.add(new Stone(stone, true));
        }
   
        Queue<Stone> queue = new PriorityQueue<>((s1, s2) -> s2.count.compareTo(s1.count));
        for (int i = 0; i < k; i++) {
            queue.offer(stoneList.get(i));
        }
        answer = queue.peek().count;
        
        for (int i = k; i < stones.length; i++) {
            Stone delete = stoneList.get(i - k);
            delete.available = false;
            
            queue.offer(stoneList.get(i));
            while(true) {
                if (queue.peek().available) {
                    break;
                }
                queue.poll();
            }
            
            answer = Math.min(answer, queue.peek().count);
        }
        return answer;
    }
}