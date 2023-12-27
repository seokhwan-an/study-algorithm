import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Integer, Integer> scoreTable = new HashMap<>();
        scoreTable.put(1,3);
        scoreTable.put(2,2);
        scoreTable.put(3,1);
        scoreTable.put(4,0);
        scoreTable.put(5,1);
        scoreTable.put(6,2);
        scoreTable.put(7,3);

        Map<String, Integer> typeScore = new HashMap<>();
        typeScore.put("R", 0);
        typeScore.put("T", 0);
        typeScore.put("C", 0);
        typeScore.put("F", 0);
        typeScore.put("J", 0);
        typeScore.put("M", 0);
        typeScore.put("A", 0);
        typeScore.put("N", 0);

        List<String> mindTypes = List.of("TR", "CF", "JM", "AN");

        for(int i = 0; i < survey.length; i++) {
            String surveyType = survey[i];
            String[] types = surveyType.split("");
            int choiceAnswer = choices[i];
            if (choiceAnswer < 4) {
                int score = typeScore.get(types[0]);
                int answerScore = scoreTable.get(choiceAnswer);
                typeScore.put(types[0], score + answerScore);
            } else {
                int score = typeScore.get(types[1]);
                int answerScore = scoreTable.get(choiceAnswer);
                typeScore.put(types[1], score + answerScore);
            }
        }

        for (String mindType : mindTypes) {
            String[] minds = mindType.split("");
            if (typeScore.get(minds[0]) > typeScore.get(minds[1])) {
                answer += minds[0];
            } else if (typeScore.get(minds[1]) > typeScore.get(minds[0])) {
                answer += minds[1];
            } else {
                int check = minds[0].compareTo(minds[1]);
                if (check < 0) {
                    answer += minds[0];
                } else {
                    answer += minds[1];
                }
            }
        }

        return answer;
    }
}
