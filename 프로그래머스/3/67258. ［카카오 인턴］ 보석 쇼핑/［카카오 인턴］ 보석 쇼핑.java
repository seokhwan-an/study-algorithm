import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        answer = new int[2];
        
        Map<String, Integer> map = new HashMap<>();
        
        int totalGemCnt = getGemCnt(gems);
        int start = 0;
        int end = 1;
        map.put(gems[start], 1);
        
        while (start < end && end <= gems.length) {
            // 모두 포함
            if (map.size() == totalGemCnt)  {
                if (answer[0] == 0 && answer[1] == 0) {
                    answer[0] = start + 1;
                    answer[1] = end;
                } else {
                    if (answer[1] - answer[0] > end - (start + 1)) {
                        answer[0] = start + 1;
                        answer[1] = end;
                    }
                }
                String startGem = gems[start];
                int gemCnt = map.get(startGem);
                if (gemCnt - 1 == 0) {
                    map.remove(startGem);
                } else {
                    map.put(startGem, gemCnt - 1);
                }
                start++;
                continue;
            }
            
            if (end == gems.length) {
                break;
            }
            
            String nextGem = gems[end];
            
            if (!map.keySet().contains(nextGem)) {
                map.put(nextGem, 1);
            } else {
                map.put(nextGem, map.get(nextGem) + 1);
            }
            end++;
        }
        
        return answer;
    }
                
    private int getGemCnt(String[] gems) {
        Set<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }
        
        return set.size();
    }

}