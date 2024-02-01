import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> numbers = new ArrayList<>();
        
        int pre = -1;
        for (int number : arr) {
            if(numbers.size() == 0) {
                numbers.add(number);
                pre = number;
                continue;
            }
            if (pre != number) {
                numbers.add(number);
                pre = number;
            }
        }
        

        return changeToArray(numbers);
    }
    
    private int[] changeToArray(List<Integer> numbers) {
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}