import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> queueA = new LinkedList<>();
        Queue<Integer> queueB = new LinkedList<>();
        long queueASum = 0;
        long queueBSum = 0;
        
        long queue1Sum = 0;
        long queue2Sum = 0;
        
        for (int i = 0; i < queue1.length; i++) {
            queueA.offer(queue1[i]);
            queueASum += queue1[i];
            queue1Sum += queue1[i];
            
            queueB.offer(queue2[i]);
            queueBSum += queue2[i];
            queue2Sum += queue2[i];
        }
        
        if ((queueASum + queueBSum) % 2 == 1) {
            return -1;
        }
        
        while (true) {
            if (queueASum == queueBSum) {
                break;
            }
            
            if (answer > (queueA.size() + queueB.size()) * 2) {
                return -1;
            }       
            
            if (queueASum > queueBSum) {
                while (queueASum > queueBSum) { 
                    answer++;
                    Integer number = queueA.poll();
                    queueASum -= number;
                    queueBSum += number;
                    queueB.offer(number);
                }
                continue;
            }
            
            while(queueBSum > queueASum) {
                answer++;
                Integer number = queueB.poll();
                queueASum += number;
                queueBSum -= number;
                queueA.offer(number);
            }
        }
        
        return answer;
    }
}