import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
         List<Integer> answerTemp = new ArrayList<>();
        
        int[] firstPerson = {1,2,3,4,5};
        int[] secondPerson = {2,1,2,3,2,4,2,5} ;
        int[] thirdPerson = {3,3,1,1,2,2,4,4,5,5};

        int[] result = {0,0,0};
        
        for (int i = 0; i < answers.length; i++) {
            int problemAnswer = answers[i];
            if (i == 0) {
                problemAnswer =  answers[0];
                int firstPersonAnswer = firstPerson[0];
                int secondPersonAnswer = secondPerson[0];
                int thirdPersonAnswer = thirdPerson[0];
                
                if (firstPersonAnswer == problemAnswer) {
                result[0] = result[0] + 1;
                }
                if (secondPersonAnswer == problemAnswer) {
                result[1] = result[1] + 1;
                }
                if (thirdPersonAnswer == problemAnswer) {
                result[2] = result[2] + 1;
                }
        
                continue;
            }

            int firstPersonAnswer = firstPerson[i % (firstPerson.length)];
            int secondPersonAnswer = secondPerson[i% (secondPerson.length)];
            int thirdPersonAnswer = thirdPerson[i% (thirdPerson.length)];
            
            if (firstPersonAnswer == problemAnswer) {
                result[0] = result[0] + 1;
            }
            if (secondPersonAnswer == problemAnswer) {
                result[1] = result[1] + 1;
            }
            if (thirdPersonAnswer == problemAnswer) {
                result[2] = result[2] + 1;
            }
        }
            
        int maxCnt = 0;
            for (int i = 0; i < result.length; i++) {
                if (result[i] > maxCnt) {
                    maxCnt = result[i];
                }
            }
                
         
            
         for (int i = 0; i < result.length; i++) {
                if (result[i] == maxCnt) {
                    answerTemp.add(i+1);
                }
            }
            Collections.sort(answerTemp);   
        
        answer = answerTemp.stream()
                .mapToInt(i -> i)
                .toArray();
        
        return answer;
    }
}