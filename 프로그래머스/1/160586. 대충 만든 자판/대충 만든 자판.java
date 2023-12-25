class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String[] targetChars = targets[i].split("");
            int minClickCnt = 0;
            for (String targetChar : targetChars) {
                int check = Integer.MAX_VALUE;
                for (String keymapUnit : keymap) {
                    int sequence = keymapUnit.indexOf(targetChar);
                    if (sequence == -1) {
                        continue;
                    }
                    check = Math.min(check, sequence);
                }
                if (check == Integer.MAX_VALUE) {
                    minClickCnt = -1;
                    break;
                }
                minClickCnt += check + 1;
            }
            answer[i] = minClickCnt;
        }
        return answer;
    }
}