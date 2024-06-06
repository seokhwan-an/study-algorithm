import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> needs = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            needs.put(want[i], number[i]);
        }
        
        int start = 0;
        int end = 9;
        
        for (int i = start; i <= end; i++) {
            String item = discount[i];
            if (needs.containsKey(item)) {
                needs.put(item, needs.get(item) - 1);
            }
        }
        
        if (checkAll(needs, want)) {
            answer++;
        }
        
        while (true) {
            start += 1;
            end += 1;
            
            if (end == discount.length) {
                break;
            }
            
            if (needs.containsKey(discount[start - 1])) {
                   needs.put(discount[start - 1], needs.get(discount[start - 1]) + 1);
            }
            
            if (needs.containsKey(discount[end])) {
                needs.put(discount[end], needs.get(discount[end]) - 1);
            }
            
            if (checkAll(needs, want)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean checkAll(Map<String, Integer> needs, String[] want) {
        Set<String> needItems = needs.keySet();
        for (String wantItem : want) {
            if (!needItems.contains(wantItem)) {
                return false;
            }
            
            int itemCnt = needs.get(wantItem);
            if (itemCnt != 0) {
                return false;
            }
        }
        
        return true;
    }
}