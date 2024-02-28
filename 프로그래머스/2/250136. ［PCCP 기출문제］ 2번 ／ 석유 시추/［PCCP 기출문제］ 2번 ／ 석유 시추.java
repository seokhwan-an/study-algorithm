import java.util.*;

class Solution {
    
    static int gasCnt;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] gasCnts;
    static boolean[] locVisited;
    
    public int solution(int[][] land) {
        int answer = 0;
        visited = new boolean[land.length][land[0].length];
        gasCnts = new int[land[0].length];
        
        for (int i = 0; i < land[0].length; i++) {
            int x = 0;
            gasCnt = 0;
            while (x < land.length) {
               
                if (land[x][i] == 1 && !visited[x][i]) {
                    getGas(land, x, i);
                }
                x += 1;
            }
        }
        
        for (int i = 0; i < gasCnts.length; i++) {
            if (gasCnts[i] > answer) {
                answer = gasCnts[i];
            }
        }
        return answer;
    }
    
    private void getGas(int[][] land, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        locVisited = new boolean[land[0].length];
        queue.add(new int[] {x, y});
        gasCnt = 1;
        visited[x][y] = true;
        locVisited[y] = true;
        
        while(!queue.isEmpty()) {
            int[] loc = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = loc[0] + dx[i];
                int ny = loc[1] + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= land.length || ny >= land[0].length) {
                    continue;
                }
                
                if (land[nx][ny] == 1 && !visited[nx][ny]) {
                    if (!locVisited[ny]) {
                        locVisited[ny] = true;
                    }
                    gasCnt++;
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        
        for (int i = 0; i < locVisited.length; i++) {
            if (locVisited[i]) {
                gasCnts[i] += gasCnt;
            }
        }
    }
}