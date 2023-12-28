class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
                            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        
        String[] split = s.split("");
        String[] skipSplit = skip.split("");
        for (String ss : split) {
            int loc = 0;   
            for (int i = 0; i < alphabet.length; i++) {
                if (ss.equals(alphabet[i])) {
                    loc = i;
                    break;
                }
            }
            
            int cnt = 1;
            int changeCnt = index;
            while (changeCnt > 0) {
                ss = alphabet[(loc + cnt) % 26];
                for (int j = 0; j < skipSplit.length; j++) {
                    if (ss.equals(skipSplit[j])) {
                        changeCnt++;
                    }
                }
                changeCnt--;
                cnt++;
            }
            answer += ss;
        }
        return answer;
    }
}