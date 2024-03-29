import java.util.*;

class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            List<Integer>[] graph = new ArrayList[n];
            for (int j = 0; j < n; j++) {
                graph[j] = new ArrayList<>();
            }
            
            visited = new boolean[n];
            for (int j = 0; j < wires.length; j++) {
                if (i == j) {
                    continue;
                }
                int[] dot = wires[j];
                graph[dot[0] - 1].add(dot[1] - 1);
                graph[dot[1] - 1].add(dot[0] - 1);
            }
            visited[0] = true;
            dfs(0, graph);
            
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    cnt++;
                }
            }           
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
        } 
        
        return answer;
    }
    
    private void dfs(int n, List<Integer>[] graph) { 
        for (int next : graph[n]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, graph);
            }
        }
    }
}