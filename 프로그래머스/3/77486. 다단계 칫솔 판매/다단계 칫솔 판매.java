/**
추천인이 연결되어 있는 피라미드 구조
조직의 이익 분배 규칙
- 모든 판매원의 수익의 10%를 추천인에게 배분 및 나머지는 자신이 가진다.
*/

import java.util.*;

class Solution {
    
    static Map<String, String> graph;
    static Map<String, Integer> sellPrice;
    static Map<String, Integer> sellerAmount;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        // 피라미드 만들기 (판매원 -> 추천인 방향만 존재)
        graph = new HashMap<>();
        sellPrice = new HashMap<>();
        
        int n = 0;
        for (int i = 0; i < enroll.length; i++) {
            String s = enroll[i];
            String p = referral[i];
            graph.put(s, p);
            sellPrice.put(s, 0);
        }
        sellPrice.put("-", 0);
        
        
        for (int i = 0; i < seller.length; i++) {
            String s = seller[i];
            int sellAmount = amount[i];
            int price = sellAmount * 100;
            sellPrice.put(s, sellPrice.get(s) + price);
            updateAmount(s, price);
        }
        
        for (int i = 0; i < enroll.length; i++) {
            String e = enroll[i];
            answer[i] = sellPrice.get(e);
        }
        return answer;
    }
    
    private void updateAmount(String seller, int price) {
        if (seller.equals("-")) {
            sellPrice.put(seller, sellPrice.get(seller) + price);
            return;
        }
        
        String provider = graph.get(seller);
        int nextPrice = price / 10;
        if (nextPrice == 0) {
            return;
        }
        sellPrice.put(provider, sellPrice.get(provider) + nextPrice);
        sellPrice.put(seller, sellPrice.get(seller) - nextPrice);
        updateAmount(provider, nextPrice);   
    }
}