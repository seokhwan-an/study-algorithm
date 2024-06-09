class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        String str = s;
        int tryCnt = 0;
        int zeroCnt = 0;
        while(!str.equals("1")) {
            tryCnt++;
            int oneCnt = 0;
            for (char c : str.toCharArray()) {
                if (c == '1') {
                    oneCnt++;
                } else {
                    zeroCnt++;
                }
            }
            
            str = Integer.toBinaryString(oneCnt);
        }
        
        answer[0] = tryCnt;
        answer[1] = zeroCnt;
        return answer;
    }
}