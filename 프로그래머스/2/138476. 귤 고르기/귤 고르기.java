import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> orangeSizeAndCount = new HashMap<>();
    
        for (int i = 0; i < tangerine.length; i++) {
            if (orangeSizeAndCount.containsKey(tangerine[i])) {
                orangeSizeAndCount.put(tangerine[i], orangeSizeAndCount.get(tangerine[i]) + 1);
            } else {
                orangeSizeAndCount.put(tangerine[i], 1);
            }
        }
        
        List<Integer> keySet = new ArrayList<>(orangeSizeAndCount.keySet());
        
        keySet.sort((o1, o2) -> orangeSizeAndCount.get(o2).compareTo(orangeSizeAndCount.get(o1)));
    
        int count = k;
        
        for (Integer key : keySet) {
            Integer orangeCount = orangeSizeAndCount.get(key);
            if (count > 0) {
                answer++;
                count -= orangeCount;
            }
            
        }
        
        return answer;
    }
}