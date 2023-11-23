import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        System.out.println(strings[0].substring(n));
        Arrays.sort(strings, (o1, o2) -> {
           if (o1.substring(n, n + 1).equals(o2.substring(n, n + 1))) {
               return o1.compareTo(o2);
           } else {
               return o1.substring(n, n + 1).compareTo(o2.substring(n, n + 1));
           }
        });
            
        answer = strings;
        return answer;
    }
}