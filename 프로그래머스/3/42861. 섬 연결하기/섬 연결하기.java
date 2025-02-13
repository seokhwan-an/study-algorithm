import java.util.Arrays;

class Solution {
    
    int[] nodes;
    
    public int solution(int n, int[][] costs) {
        nodes = new int[n];
        Arrays.fill(nodes, -1);
        Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]);

        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < costs.length; i++) {
            int[] section = costs[i];
            int node1 = section[0];
            int node2 = section[1];
            int cost = section[2];
            
            if (!isDiffGraph(node1, node2)) {
                continue;
            }
            answer += cost;
            cnt++;
            if (cnt == n - 1) {
                break;
            }
        }
        
        return answer;
    }
    
    private boolean isDiffGraph(int node1, int node2) {
        int u = find(node1);
        int v = find(node2);
        
        if (u == v) {
            return false;
        }
                    
        if (nodes[u] == nodes[v]) {
            nodes[u]--;
        }
        
        if (nodes[u] < nodes[v]) {
            nodes[u] = v;
        } else {
            nodes[v] = u;
        }
        
        return true;
    }
    
    private int find(int node) {
        if (nodes[node] < 0) {
            return node;
        }
        
        return nodes[node] = find(nodes[node]);
    }
}