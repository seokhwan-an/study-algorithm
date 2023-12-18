// cache에 데이터가 있는 경우 비용 1
// cache에 데이터가 없는 경우 비용 5
// LRU 리스트를 이용

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        for (String city : cities) {
            String lowerCaseCity = city.toLowerCase();
            if (cacheSize == 0) {
                answer += 5;
                continue;
            }
            if (cache.contains(lowerCaseCity)) {
                cache.remove(lowerCaseCity);
                cache.addLast(lowerCaseCity);
                answer += 1;
            } else {
                if (cache.size() == cacheSize) {
                    cache.removeFirst();
                }  
                cache.addLast(lowerCaseCity);
                answer += 5;
            }
        }
        return answer;
    }
}