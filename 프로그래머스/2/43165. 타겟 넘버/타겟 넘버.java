class Solution {
    
    static int answer = 0;
    static int[] signs;
    
    public int solution(int[] numbers, int target) {
        // +는 1, -는 0
        initSign(numbers);
        findTarget(numbers, 0, target);
        
        return answer;
    }
    
    private void initSign(int[] numbers) {
        signs = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            signs[i] = -1;
        }
    }
    
    private void findTarget(int[] numbers, int n, int target) {
        if (n == signs.length) {
            checkTargetNumber(numbers, target);
            return;
        }
        for (int i = 0; i < 2; i++) {
            signs[n] = i;
            findTarget(numbers, n + 1, target);
            signs[n] = -1;
        }
    }
    
    private void checkTargetNumber(int[] numbers, int target) {
        int number = 0;
        for (int i = 0; i < numbers.length; i++) {
            int sign = signs[i];
            if (sign == 0) {
                number -= numbers[i];
            }
            if (sign == 1) {
                number += numbers[i];
            }
        }
        
        if (target == number) {
            answer++;
        }
    }
}