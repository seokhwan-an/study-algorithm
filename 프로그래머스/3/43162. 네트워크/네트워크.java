import java.util.*;

class Solution {
    
    static List<Integer>[] graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        init(n, computers);
        
        for (int i = 1; i < graph.length; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        
        return answer;
    }
    
    private void init(int n, int[][] computers) {
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < computers.length; i++) {
            List<Integer> linkedComputer = graph[i + 1];
            for (int j = 0; j < computers[0].length; j++) {
                if (i == j) {
                    continue;
                }
                if (computers[i][j] == 1) {
                    linkedComputer.add(j + 1);
                }
            }
        }
    }
    
    private void dfs(int computer) {
        visited[computer] = true;
        List<Integer> linkedComputer = graph[computer];
        for (int next : linkedComputer) {
            if (!visited[next]) {
                dfs(next);
            } 
        }
    }
}