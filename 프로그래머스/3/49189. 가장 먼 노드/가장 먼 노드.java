import java.util.*;

class Solution {
    
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] distances;
    
    public int solution(int n, int[][] edge) {
        generateGraph(n, edge);
        distances = new int[n + 1];
        visited = new boolean[n + 1];
        
        searchGraph(1, 0);
        
        return getAnswer();
    }
    
    private void generateGraph(int n, int[][] edges) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
    }
    
    private void searchGraph(int n, int distance) {
        visited[n] = true;
        distances[n] = distance;
        List<Integer> nexts = graph[n];
        
        for (int next : nexts) {
            if (!visited[next] || distance + 1 < distances[next]) {
                searchGraph(next, distance + 1);
            }
        }
    }
    
    private int getAnswer() {
        int maxDistance = 0;
        int answer = 0;
        for (int distance : distances) {
            if (distance == maxDistance) {
                answer += 1;
            }
            if (distance > maxDistance) {
                maxDistance = distance;
                answer = 1;
            }
        }
        
        return answer;
    }
}