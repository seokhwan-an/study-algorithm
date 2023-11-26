class Solution {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        
        for (int i = 0; i < length; i++) {
            int cnt = 0;
            int price = prices[i];
            for (int j = i + 1; j < length; j++) {
                int nextPrice = prices[j];
                if (price > nextPrice && i != length -1) {
                    cnt += 1;
                    break;
                }
                if (price <= nextPrice) {
                    cnt += 1;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}