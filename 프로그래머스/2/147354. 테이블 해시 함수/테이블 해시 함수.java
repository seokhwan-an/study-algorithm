import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (d1, d2) -> d1[col - 1] == d2[col - 1] ? d2[0] - d1[0] : d1[col - 1] - d2[col - 1]);
        
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int[] line = data[i];
            int sum = 0;
            for (int d : line) {
                sum += d % (i + 1);
            }
            
            answer = answer^sum;
        }
        return answer;
    }
}