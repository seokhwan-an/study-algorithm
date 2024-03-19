import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stageLocs = new int[N + 2];
        int[] clearCnt = new int[N + 1];
        List<Stage> stageList = new ArrayList<>();
        
        for (int stage: stages) {
            for (int i = 1; i < stage; i++) {
                clearCnt[i] += 1;
            }
            stageLocs[stage] += 1;
        }
        
        for (int i = 1; i <= N; i++) {
            int total = clearCnt[i] + stageLocs[i];
            System.out.println(total + " " + stageLocs[i]);
            if (total == 0) {
                stageList.add(new Stage(i, (double) 0));
            } else {
                double failPercent = (double) stageLocs[i] / total;
                stageList.add(new Stage(i, failPercent));
            }
        }
        
        stageList.sort((r1, r2) -> Double.compare(r1.failPercent, r2.failPercent) == 0 ? Integer.compare(r1.stage, r2.stage) : Double.compare(r2.failPercent, r1.failPercent));
        
        for (int i = 0; i < N; i++) {
            Stage stage = stageList.get(i);
            answer[i] = stage.stage;
        }
        
        return answer;
    }
    
    class Stage {
        int stage;
        double failPercent;
        
        public Stage(int stage, double failPercent) {
            this.stage = stage;
            this.failPercent = failPercent;
        }
    }
}