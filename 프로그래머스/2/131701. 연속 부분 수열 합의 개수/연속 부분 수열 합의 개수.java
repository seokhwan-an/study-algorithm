import java.util.*;

class Solution {
    
    Set<Integer> sums = new HashSet<>();
    int[] numbers;
    
    public int solution(int[] elements) {
        numbers = elements;
        
        for (int i = 1; i <= elements.length; i++) {
            findSum(i);
            System.out.println();
        }
        return sums.size();
    }
    
    public void findSum(int n) {
        if (n == 1) {
            for (int number : numbers) {
                sums.add(number);
            }
            
            return;
        }
        
        int start = 0;
        int end = n - 1;
        int sum = 0;
        
        for (int i = start; i <= end; i++) {
            sum += numbers[i];
        }
        sums.add(sum);
        
        while (true) {
            sum -= numbers[start];
            start = (start + 1) % numbers.length;
            
            if (start == 0) {
                break;
            }
            
            end = (end + 1) % numbers.length;
            sum += numbers[end];
            sums.add(sum);
        }
    }
}