class Solution {
    public String solution(String number, int k) {
        char[] chars = number.toCharArray();
        boolean[] accept = new boolean[chars.length];
        int start = 0;
        int length = chars.length - k;
        
        while(length > 0) {
            int index = getMaxNumberIndex(chars, start, length);
            accept[index] = true;
            length--;
            start = index + 1;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < accept.length; i++) {
            if (accept[i]) {
                sb.append(chars[i]);
            }
        }
        
        return sb.toString();
    }
    
    private int getMaxNumberIndex(char[] chars, int start, int length) {
        int maxNext = 0;
        for (int i = start; i < chars.length; i++) {
            maxNext = i;
            int size = chars.length - i;
            if (size == length) {
                break;
            }
        }
        
        int index = start;
        for (int i = start; i <= maxNext; i++) {
            if (chars[i] > chars[index]) {
                index = i;
            }
        }
        
        return index;
    }
}