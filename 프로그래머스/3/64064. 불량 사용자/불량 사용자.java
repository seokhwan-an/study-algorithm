import java.util.*;

class Solution {
    
    Set<String> check;
    boolean[] visited;
    int answer;
    
    public int solution(String[] user_id, String[] banned_id) {
        check = new HashSet<>();
        visited = new boolean[user_id.length];
        answer = 0;
        
        findBanList(user_id, banned_id, 0);   
        return check.size();
    }
    
    private void findBanList(String[] user_id, String[] banned_id, int n) {
        if (n == banned_id.length) {
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for (int i = 0; i < user_id.length; i++) {
                if (visited[i]) {
                    cnt++;
                    sb.append(user_id[i]).append(", ");
                }
            }
            
            if (cnt == banned_id.length) {
                check.add(sb.toString());
            }
            return;
        }
        
        String banFormat = banned_id[n];
        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && availableBan(banFormat, user_id[i])) {
                visited[i] = true;
                n++;
                findBanList(user_id, banned_id, n);
                n--;
                visited[i] = false;   
            }  
        }
    }
    
    private boolean availableBan(String banFormat, String user) {
        if (banFormat.length() != user.length()) {
            return false;
        }
        
        char[] banChars = banFormat.toCharArray();
        char[] userChars = user.toCharArray();
        
        for (int i = 0; i < banFormat.length(); i++) {
            char banChar = banChars[i];
            char userChar = userChars[i];
            
            if (banChar == '*') {
                continue;
            }
            
            if (banChar != userChar) {
                return false;
            }
        }
        
        return true;
    }
}