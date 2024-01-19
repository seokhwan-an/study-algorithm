import java.util.*;

class Solution {
    public int solution(int n) {
        Set<Integer> divisors = new HashSet<>();
        if (n == 1) {
            return 1;
        }
    
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                divisors.add(n / i);
            }
        }
        
        int answer = sumAll(divisors);
        
        return answer;
    }
    
    public int sumAll (Set<Integer> divisors) {
        int sum = 0;
        
        for (Integer divisor : divisors) {
            sum += divisor;
        }
        return sum;
    }
}