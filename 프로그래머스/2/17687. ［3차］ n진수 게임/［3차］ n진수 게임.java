import java.util.*;

class Solution {
    
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int check = 0;
        int number = 0;
        int turn = 0;
        
        while (true) {
            if (check == t) {
                break;
            }
            String transNumber = Integer.toString(number, n).toUpperCase();
            for (int i = 0; i < transNumber.length(); i++) {
                if (check == t) {
                    break;
                }
                turn++;
                if (turn > m) {
                    turn = 1;
                }
                if (turn == p) {
                    sb.append(transNumber.substring(i, i + 1));
                    check++;
                }
            }
            
            number++;
            
        }
        
        return sb.toString();
    }

}