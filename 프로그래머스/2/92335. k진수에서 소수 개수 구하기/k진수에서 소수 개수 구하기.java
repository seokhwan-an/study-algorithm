class Solution {
    
    StringBuilder sb;
    
    public int solution(int n, int k) {
        int answer = 0;
        String kPrime = getPrime(n, k);
        System.out.println(kPrime);
        
        sb = new StringBuilder();
        int index = 0;
        
        while (index <= kPrime.length()) {
            if (index == kPrime.length()) {
                if (!sb.toString().isBlank()) {
                    if (isPrimeNumber(sb.toString())) {
                        answer++;
                    }
                }
                break;
            }
            
            String number = kPrime.substring(index, index + 1);
            if (number.equals("0")) {
                if (!sb.toString().isBlank()) {
                    if (isPrimeNumber(sb.toString())) {
                        answer++;
                    }
                    sb = new StringBuilder();
                }
                index++;
                continue;
            }
            sb.append(number);
            index++;
        } 
        
        return answer;
    }
    
    private String getPrime(int n, int k) {
        sb = new StringBuilder();
        int number = n;
        while(true) {
            sb.insert(0, number % k);
            number = number / k;
            if (number == 0) {
                break;
            }
        }
        return sb.toString();
    }
    
    private boolean isPrimeNumber(String input) {
        long number = Long.parseLong(input);
        
        if (number < 2) {
            return false;
        }
        
        if (number == 2) {
            return true;
        }
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}