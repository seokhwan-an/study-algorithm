import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            String prePhoneNumber = phone_book[i];
            String nextPhoneNumber = phone_book[i+1];
            if (nextPhoneNumber.startsWith(prePhoneNumber)) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}