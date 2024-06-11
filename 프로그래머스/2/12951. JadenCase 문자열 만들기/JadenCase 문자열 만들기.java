class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
          
        for (int i = 0; i < str.length; i++) {
            String check = str[i];
            
            char[] chars = check.toCharArray();
            
            for (int j = 0; j < chars.length; j++) {
                if ('a' <= chars[j] && chars[j] <= 'z' && j == 0) {
                    chars[j] = Character.toUpperCase(chars[j]);
                } 
                
                if ('A' <= chars[j] && chars[j] <= 'Z' && j != 0) {
                    chars[j] = Character.toLowerCase(chars[j]);
                }
            }    
            
            str[i] = String.valueOf(chars);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length - 1; i++) {
            sb.append(str[i]).append(" ");
        }
        sb.append(str[str.length - 1]);
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!s.substring(i, i + 1).isBlank()) {
                break;
            }
            sb.append(" ");
        }
        
        return sb.toString();
    }
}