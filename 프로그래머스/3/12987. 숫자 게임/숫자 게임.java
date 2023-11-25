
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int bCheckPoint = 0;
        for (int i = 0; i < A.length; i++) {
            while(bCheckPoint < B.length) {
                if (B[bCheckPoint] > A[i]) {
                    answer++;
                    bCheckPoint++;
                    break;
                }
                bCheckPoint++;
            }
        }
      
        return answer;
    }
}