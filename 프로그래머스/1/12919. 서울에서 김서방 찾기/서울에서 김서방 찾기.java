class Solution {
    public String solution(String[] seoul) {
        String answer = String.format("김서방은 %d에 있다", getKimLocation(seoul));
        return answer;
    }
    
    private int getKimLocation(String[] seoul) {
        int location = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                location = i;
                break;
            }
        }
        return location;
    }
}