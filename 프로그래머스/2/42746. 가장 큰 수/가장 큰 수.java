import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> strings = changeToList(numbers);
        
        Collections.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (strings.get(0).equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        return sb.toString();
    }
    
    private List<String> changeToList(int[] numbers) {
        List<String> strings = new ArrayList<>();
        for (int number : numbers) {
            strings.add(String.valueOf(number));
        }
        return strings;
    }
}