import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for (int move: moves) {
            
            int height = -1;
            while(height < board.length - 1) {
                height++;
                if (board[height][move - 1] != 0) {
                    break;
                }
            }
            
            int doll = board[height][move - 1];
            if (doll == 0) {
                continue;
            }
            board[height][move - 1] = 0;
            if (stack.empty()) {
                stack.push(doll);
            } else {
                if (stack.peek() == doll) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(doll);
                }
            }
        }
        
        return answer;
    }
}