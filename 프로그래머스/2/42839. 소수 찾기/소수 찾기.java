import java.util.*;

class Solution {
    
    String[] number;
    boolean[] visited;
    StringBuilder sb = new StringBuilder();
    Set<Integer> check = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        number = numbers.split("");
        int size = number.length;
        visited = new boolean[size];
        
        for (int i = 1; i <= size; i++) {
            findPrimeNumber(i, 0);
        }
        
        for (int num : new ArrayList<>(check)) {
            if (isPrimeNumber(num)) {
                answer += 1;
            }
        }
        
        return answer;
    }
    
    private void findPrimeNumber(int n, int k) {
        if (k == n) {
            check.add(Integer.parseInt(sb.toString()));
            return;
        }
        
        for (int i = 0; i < number.length; i++) {
            if (sb.toString().isBlank() && number[i].equals("0")) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                sb.append(number[i]);
                findPrimeNumber(n, k + 1);
                sb.deleteCharAt(sb.toString().length() - 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        
        for (int i = 2; i<= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}