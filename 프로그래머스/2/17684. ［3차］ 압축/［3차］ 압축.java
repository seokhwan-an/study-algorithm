import java.util.*;

class Solution {
    
    Map<String, Integer> lzwTable;
    
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        lzwTable = initTable();
        
        int lastValue = 26;
        
        for (int i = 0; i < msg.length(); i++) {
            int index = i;
            String check = msg.substring(index, index + 1);
            while(lzwTable.containsKey(check) && index < msg.length() - 1) {
                index++;
                i++;
                check += msg.substring(index, index + 1);
            }
            if (check.length() > 1) {
                if (index == msg.length() - 1 && lzwTable.containsKey(check)) {
                    answer.add(lzwTable.get(check));
                    continue;
                }
                lzwTable.put(check, ++lastValue);
                answer.add(lzwTable.get(check.substring(0, check.length() - 1)));
                i--;
            } else {
                answer.add(lzwTable.get(check));
            }
        }
        return listToArray(answer);
    }
    
    private Map<String, Integer> initTable() {
        Map<String, Integer> lzwTable = new HashMap<>();
        int A = 65;
        for (int i = 0; i < 26; i++) {
            lzwTable.put(String.valueOf((char) (65 + i)), i + 1);
        }
        
        return lzwTable;
    }
    
    private int[] listToArray(List<Integer> input) {
        int[] answer = new int[input.size()];
        
        for (int i = 0; i < input.size(); i++) {
            answer[i] = input.get(i);
        }
        
        return answer;
    }
}