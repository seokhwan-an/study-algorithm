import java.util.*;

class Solution {
    
    public String[] solution(String[] records) {
        Map<String, String> idNicknameChecker = new HashMap<>();
        List<String> messages = new ArrayList<>();
        
        for (String record : records) {
            String[] split = record.split(" ");
            if (split[0].equals("Leave")) {
                continue;
            }
            
            idNicknameChecker.put(split[1], split[2]);
        }
        
        for (String record : records) {
            String[] split = record.split(" ");
            
            if (split[0].equals("Enter")) {
                messages.add(String.format("%s님이 들어왔습니다.", idNicknameChecker.get(split[1])));
            }
            
            if (split[0].equals("Leave")) {
                messages.add(String.format("%s님이 나갔습니다.", idNicknameChecker.get(split[1])));
            }
        }
        
        String[] answer = new String[messages.size()];
        int index = 0;
        
        for (String message : messages) {
            answer[index++] = message;
        }
        
        return answer;
    }
}