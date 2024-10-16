import java.util.*;

class Solution {
    
    int[] toA;
    int[] toB;
    int[] fromS;
    Map<Integer, List<Integer>> graph;
    int[][] fare;
    boolean[] visited;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        toA = new int[n + 1];
        toB = new int[n + 1];
        fromS = new int[n + 1];
        fare = new int[n + 1][n + 1];
        graph = new HashMap<>();
        
        
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int i = 1; i <= n; i++) { 
            for (int j = 1; j <= n; j++) {
                fare[i][j] = -1;
                if (i == j) {
                    fare[i][j] = 0;
                }
            }
        }
        
        for (int[] f : fares) {
            int start = f[0];
            int end = f[1];
            int price = f[2];
            
            graph.get(start).add(end);
            graph.get(end).add(start);
            fare[start][end] = price;
            fare[end][start] = price;
        }
        updateGetLittlePrice(a, toA);
        updateGetLittlePrice(b, toB);
        updateGetLittlePrice(s, fromS);
        
        for (int i = 1; i <= n; i++) {
            if (i != a && toA[i] == 0) {
                continue;
            }
            if (i != b && toB[i] == 0) {
                continue;
            }
            if (i != s && fromS[i] == 0) {
                continue;
            }
            int total = toA[i] + toB[i] + fromS[i];
            answer = Math.min(total, answer);
        }
        
        return answer;
    }
    
    private void updateGetLittlePrice(int position, int[] check) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{position, -1});
        
        while(!queue.isEmpty()) {
            int[] p = queue.poll();
            int point = p[0];
            int value = p[1];
            for (int next : graph.get(point)) {
                if (next == position) {
                    continue;
                }
                if (fare[next][p[0]] == -1) {
                    continue;
                }
                if (value == -1) {
                    int nextValue = fare[next][p[0]];
                    check[next] = nextValue;
                    queue.offer(new int[] {next, nextValue});
                } else {
                    int nextValue = fare[next][p[0]] + check[p[0]];
                    if (check[next] == 0) {
                        check[next] = nextValue;
                        queue.offer(new int[] {next, nextValue});
                    } else {
                        if (check[next] > nextValue) {
                            check[next] = nextValue;
                            queue.offer(new int[]{next, nextValue});
                        }
                    }
                }
            }
        }
    } 
}