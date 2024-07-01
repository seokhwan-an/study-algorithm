class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        
        for (char c : chars) {
            if (c == ' ') {
                sb.append(" ");
                continue;
            }
            char next = (char) (c + n);
            if (c >= 'a' && c <= 'z') {
                if (next > 'z') {
                    sb.append(String.valueOf((char)(next - 26)));
                } else {
                    sb.append(String.valueOf(next));
                }
            }
            if (c >= 'A' && c <= 'Z') {
                if (next > 'Z') {
                    sb.append(String.valueOf((char)(next - 26)));
                } else {
                    sb.append(String.valueOf(next));
                }
            }
        }
        return sb.toString();
    }
}