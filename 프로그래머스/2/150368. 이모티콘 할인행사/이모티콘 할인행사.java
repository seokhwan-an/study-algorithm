// 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것 (최우선)
// 이모티콘 판매액을 최대한 늘리는 것
// n명에 유저에게 m개의 이모티콘 할인 (이모티콘 할인율은 10, 20, 30, 40 중 하나)

class Solution {
    
    int[] salePercent = {10, 20, 30, 40};
    int[] answer = new int[2];
    int[] productSale;
    
    public int[] solution(int[][] users, int[] emoticons) {
        productSale = new int[emoticons.length];
        findMaxPlusUserAndSale(users, emoticons, 0);
        return answer;
    }
    
    public void findMaxPlusUserAndSale(int[][] users, int[] emoticons, int n) {
        if (n == productSale.length) {
            getPlusUserAndSale(users, emoticons);
            return;
        } 
        for (int i = 0; i < 4; i++) {
            productSale[n] = salePercent[i];
            findMaxPlusUserAndSale(users, emoticons, n + 1);
        }
    }
    
    private void getPlusUserAndSale(int[][] users, int[] emoticons) {
        int money = 0;
        int plusUser = 0;
        
        for (int i = 0; i < users.length; i++) {
            int buyPercent = users[i][0];
            int buyMaxMoney = users[i][1]; 
            
            // 사용자가 구매한 금액체크
            int check = 0;
            for (int j = 0; j < emoticons.length; j++) {
                int sale = productSale[j];
                int buyPrice = emoticons[j] * (100 - sale) / 100 ;
                if (sale >= buyPercent) {
                    check += buyPrice;
                }
            }
            
            
            // 구매 가격이 기준치 보다 높은지 체크
            if (check >= buyMaxMoney) {
                plusUser += 1;
            } else {
                money += check;
            }
        }
        
        if (plusUser > answer[0]) {
            answer[0] = plusUser;
            answer[1] = money;
        } else if (plusUser == answer[0]) {
            answer[1] = Math.max(money, answer[1]);
        }
    }
}