class Solution {
    
    private static int answer;
    private static int[][] visited;
    
    public int solution(int n) {
        answer = 0;
        visited = new int[n][n];
        
        findAvailable(0, n);
        return answer;
    }
    
    private void findAvailable(int c, int n) {
        if (c == n) {
            answer += 1;
            return;
        }
        
        
        for (int i = 0; i < n; i++) {
            if (isAvailable(c, i, n)) {
                visited[c][i] = 1;
                findAvailable(c + 1, n);
                visited[c][i] = 0;
            }
        }
    }
    
    private boolean isAvailable(int r, int c, int n) {
        // 가로 체크
        for (int i = 0; i < n; i++) {
            if (c == i) {
                continue;
            }
            
            if (visited[r][i] == 1) {
                return false;
            }
        }
        
        // 세로 체크
        for (int i = 0; i < n; i++) {
            if (r == i) {
                continue;
            }
            
            if (visited[i][c] == 1) {
                return false;
            }
        }
        
        // 대각선 체크
        int cr = r - 1;
        int cc = c - 1;
        
        while (cr >= 0 && cc >= 0) {
            if (visited[cr][cc] == 1) {
                return false;
            }
            
            cr -= 1;
            cc -= 1;
        }
        
        cr = r - 1;
        cc = c + 1;
        
        while (cr >= 0 && cc < n) {
            if (visited[cr][cc] == 1) {
                return false;
            }
            
            cr -= 1;
            cc += 1;
        }
        
        return true;
    }
}