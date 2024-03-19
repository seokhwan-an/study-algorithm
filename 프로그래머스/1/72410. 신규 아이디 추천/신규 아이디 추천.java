class Solution {
    public String solution(String new_id) {  
        String id = changeSmallCharactor(new_id);
        id = deleteWrongChar(id);
        id = deleteContinueDot(id);
        id = deleteDotForStartEnd(id);
        id = checkBlank(id);
        id = checkLength(id);
        id = modifyLength(id);
        
        return id;
    }
    
    private String changeSmallCharactor(String new_id) {
        String id = "";
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if ('A' <= c && c <= 'Z') {
                id += (char) (c + 32);                
            } else {
                id += c;
            }
        }
        return id;
    }
    
    private String deleteWrongChar(String new_id) {
        String id = "";
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || c == '-' || c == '_' || c == '.') {
                id += c;
            }
        }
        return id;
    }
    
    private String deleteContinueDot(String new_id) {
        String id = "";
        char pre = new_id.charAt(0);
        id += pre;
        for (int i = 1; i < new_id.length(); i++) {
            char next = new_id.charAt(i);
            
            if (pre == '.' && next == '.') {
                continue;
            }
            id += next;
            pre = next;
        }
        
        return id;
    }
    
    private String deleteDotForStartEnd(String new_id) {
        String id = "";
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if ((i == 0 && c == '.') || (i == new_id.length() - 1 && c == '.')) {
                continue;
            } 
            id += c;
        }
        
        return id;
    }
    
    private String checkBlank(String new_id) {
        if (new_id.isBlank()){
            return "a";
        }
        
        return new_id;
    }
    
    private String checkLength(String new_id) {
        String id = new_id;
        if (id.length() >= 16) {
            id = id.substring(0, 15);
            if (id.charAt(14) == '.') {
                id = id.substring(0, 14);
            }
        }
        
        return id;
    }
    
    private String modifyLength(String new_id) {
        String id = new_id;
        if (id.length() <= 2) {
            char c = id.charAt(id.length() - 1);
            while(id.length() < 3) {
                id += c; 
            }
        }
        
        return id;
    }
}