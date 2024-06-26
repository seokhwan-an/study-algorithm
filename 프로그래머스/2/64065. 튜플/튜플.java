import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        List<List<String>> tuples = new ArrayList<>();
        
        char[] chars = s.toCharArray();
        List<String> tuple = new ArrayList<>();
        char pre = 'z';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 || i == chars.length - 1) {
                continue;
            }
            
            if (chars[i] == '{') {
                tuple = new ArrayList<>();
                sb = new StringBuilder();
            }
            
            if (chars[i] == '}') {
                tuple.add(sb.toString());
                tuples.add(tuple);
            }
            
            if (chars[i] == ',') {
                if (pre == '}') {
                    continue;
                } else {
                    tuple.add(sb.toString());
                    sb = new StringBuilder();
                }
            } 
            
            if ('0' <=  chars[i] && chars[i] <= '9') {
                sb.append(String.valueOf(chars[i]));
            }
            pre = chars[i];
        }
        Collections.sort(tuples, (i1, i2) -> i1.size() - i2.size());
        
        answer = new int[tuples.size()];
        Set<Integer> check = new HashSet<>();
        for (int i = 0; i < tuples.size(); i++) {
            List<String> t = tuples.get(i);
            for (String s2 : t) {
                int n = Integer.parseInt(s2);
                if (!check.contains(n)) {
                    answer[i] = n;
                    check.add(n);
                    break;
                }
            }
        }
        return answer;
    }
}