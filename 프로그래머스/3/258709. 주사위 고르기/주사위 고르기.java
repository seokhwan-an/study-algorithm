// 주사위를 선택한다.
// 주사위를 고르면 비교를 한다. (주사위는 오름 차순으로 선택한다.)
// 승이 가장 많은 것으로 답을 설정한다.

// 최적화 할 수 있는 것 사실상 1,2,3,4 주사위에서 1,2 를 고른 것이면 3,4의 정보를 알 수 있다. (어떻게 최적화를 할까?)
import java.util.*;

class Solution {
    
    int bestWinCnt;
    int[] bestCase;
    boolean[] visited;
    Map<String, Integer> history;
    
    public int[] solution(int[][] dice) {
        int[] answer = new int[dice.length / 2];
        bestCase = new int[dice.length/ 2 + 1]; 
        visited = new boolean[dice.length];
        history = new HashMap<>();
        
        findAnswer(dice, dice.length / 2, 0);
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = bestCase[i];
        }
        return answer;
    }
    
    private void findAnswer(int[][] dice, int n, int k) {
        if (n == k) {
            String result = battleResult(dice);
            
            if (result.equals("-1")) {
                return;
            }
            
            String[] split = result.split(" ");
            if (Integer.parseInt(split[dice.length / 2]) > bestCase[dice.length / 2]) {
                for (int i = 0; i <= dice.length / 2; i++) {
                    bestCase[i] = Integer.parseInt(split[i]);
                }
            }
            
            return;
        }
        
        for (int i = 0; i < dice.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                findAnswer(dice, n, k + 1);
                visited[i] = false;
            }
        }
    }
    
    private String battleResult(int[][] dice) {
        List<int[]> aPick = new ArrayList<>();
        List<int[]> bPick = new ArrayList<>();
        int[] result = new int[dice.length / 2 + 1];
        
        int index = 0;
        String aSelect = "";
        String bSelect = "";
        for (int i = 0; i < dice.length; i++) {
            if (visited[i]) {
                aPick.add(dice[i]);
                aSelect += (i + 1) + " ";
            } else {
                bPick.add(dice[i]);
                bSelect += (i + 1) + " ";
            }
        }
        
        if (history.keySet().contains(aSelect)) {
            return "-1";
        }
        
        List<Integer> aResult = getSumResult(aPick);
        List<Integer> bResult = getSumResult(bPick);
        Collections.sort(aResult);
        Collections.sort(bResult);
        
        int win = 0;
        int lose = 0;
        for (int sum : aResult) {
            int start = 0;
            int end = bResult.size();
            while(start < end) {      
                int mid = (start + end) / 2;
                if (sum <= bResult.get(mid)) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            win += end;
        }
        
        for (int sum : bResult) {
            int start = 0;
            int end = bResult.size();
            while (start < end) {
                int mid = (start + end) / 2;
                if (sum <= aResult.get(mid)) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }     
            lose += end;
        }
        
        history.put(aSelect, win);
        history.put(bSelect, lose);
        
        if (win > lose) {
            aSelect += win + " ";
            return aSelect;
        }
        
        bSelect += lose + " ";
        return bSelect;
    }
    
    private List<Integer> getSumResult(List<int[]> pick) {
        int[] visited = new int[pick.size()];
        for (int i = 0; i < pick.size(); i++) {
            visited[i] = -1;
        }
        List<Integer> result = new ArrayList<>();
        addResult(visited, pick, pick.size(), 0, result, 0, -1);
        
        return result;
    }
    
    private void addResult(int[] visited, List<int[]> pick, int n, int k, List<Integer> result, int sum, int next) {
        if (n == k) {
            result.add(sum);
            return;
        }
        
        for (int i = 0; i < pick.size(); i++) {
            if (visited[i] == -1 && i > next) {
                for (int j = 0; j < 6; j++) {
                    visited[i] = j;
                    sum += pick.get(i)[j];
                    addResult(visited, pick, n, k + 1, result, sum, i);
                    sum -= pick.get(i)[j];
                }
                visited[i] = -1;
            }
        }
    }
}