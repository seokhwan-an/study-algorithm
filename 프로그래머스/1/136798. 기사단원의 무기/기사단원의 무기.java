import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] numbers = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            numbers[i] = getDivisionCnt(i);
        }
        
        for (int i = 1; i <= number; i++) {
            if (numbers[i] > limit) {
                answer += power;
            } else {
                answer += numbers[i];
            }
        }
        
        return answer;
    }
    
    private int getDivisionCnt(int number) {
        Set<Integer> measures = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                measures.add(i);
                measures.add(number / i);
            }
        }
        return measures.size();
    }
}