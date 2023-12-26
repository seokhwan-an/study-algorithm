import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        Map<String, Integer> termsInfos = getTermsInfos(terms);
        
        String[] todayInfos = today.split("\\.");
        Integer todayYear = stringToInteger(todayInfos[0]);
        Integer todayMonth = stringToInteger(todayInfos[1]);
        Integer todayDay = stringToInteger(todayInfos[2]);
        
        Integer todayDays = todayYear * 12 * 28 + todayMonth * 28 + todayDay;
        
        List<Integer> check = new ArrayList<>();
            
        for (int i = 0; i < privacies.length; i++) {
            String[] privacyInfo = privacies[i].split(" ");
            String registeredDate = privacyInfo[0];
            String privacyType = privacyInfo[1];
            
            String[] registeredDateInfos = registeredDate.split("\\.");
            Integer registerYear = stringToInteger(registeredDateInfos[0]);
            Integer registerMonth = stringToInteger(registeredDateInfos[1]);
            Integer registerDay = stringToInteger(registeredDateInfos[2]);
            Integer privacyTerm = termsInfos.get(privacyType);
            
            Integer expiredMonth = registerMonth + termsInfos.get(privacyType);
 
            if (expiredMonth > 12) {
                registerYear += 1;
                expiredMonth -= 12;
            }
            
            Integer expiredDays = registerYear * 28 * 12 + expiredMonth * 28 + registerDay;
            
            if (expiredDays <= todayDays) {
                check.add(i + 1);
            }
        }
        Collections.sort(check);
        
        answer = new int[check.size()];
        
        for (int i = 0; i < check.size(); i++) {
            answer[i] = check.get(i);
        }
        
        return answer;
    }
    
    private Map<String, Integer> getTermsInfos (String[] terms) {
        Map<String, Integer> termsInfos = new HashMap<>();
        
        for (String term : terms) {
            String[] termInfo = term.split(" ");
            termsInfos.put(termInfo[0], Integer.parseInt(termInfo[1]));
        }
        return termsInfos;
    }
    
    private Integer stringToInteger (String input) {
        return Integer.parseInt(input);
    }
}