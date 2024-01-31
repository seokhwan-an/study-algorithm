import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int cnt = 1;
            int progress = progresses[i];
            int speed = speeds[i];
            
            int lastTime = getLastTime(progress, speed);
            
            int nextCnt = 0;
            for (int j = i + 1; j < progresses.length; j++) {
                if (progresses[j] + lastTime * speeds[j] >= 100) {
                    nextCnt += 1;
                    cnt += 1;
                    i += 1;
                } else {
                    break;
                }
            }
            
            answer.add(cnt);
        }
        
        
        return changeToArray(answer);
    }
    
    private int getLastTime(int progress, int speed) {
        int lastWork = 100 - progress;
        if (lastWork % speed == 0) {
            return lastWork / speed;
        }
        return lastWork / speed + 1;
    }
    
    private int[] changeToArray(List<Integer> answer) {
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}