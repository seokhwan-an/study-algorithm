import java.util.*;


class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        List<String> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        String[] Xarr = X.split("");
        String[] Yarr = Y.split("");
        
        Map<String, Integer> Xmap = new HashMap<>();
        Map<String, Integer> Ymap = new HashMap<>();
        
        for (String x : Xarr) {
            if (Xmap.containsKey(x)) {
                Xmap.put(x, Xmap.get(x) + 1);
            } else {
                Xmap.put(x, 1);
            }
        }
        
        for (String y : Yarr) {
            if (Ymap.containsKey(y)) {
                Ymap.put(y, Ymap.get(y) + 1);
            } else {
                Ymap.put(y, 1);
            }
        }
        
        
        for (String number : Xmap.keySet()) {
            if (Ymap.containsKey(number)) {
                int numberCnt = Math.min(Xmap.get(number), Ymap.get(number));
                for (int i = 0; i < numberCnt; i++) {
                    numbers.add(number);
                }
            }
        }
        
        Collections.sort(numbers, Collections.reverseOrder());
        
        if (numbers.size() == 0) {
            return "-1";
        }
        
        if (isOnlyZero(numbers)) {
            return "0";
        }
        
        
        for (String number : numbers) {
            sb.append(number);
        }
        
        
        return sb.toString();
    }
    
    private boolean isOnlyZero(List<String> numbers) {
        for (String number : numbers) {
            if (!number.equals("0")) {
                return false;
            }
        }
        return true;
    }
}