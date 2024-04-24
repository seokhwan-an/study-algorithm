import java.util.*;

class Solution {
    
    int[][] map;
    boolean[][] visited;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int cnt;
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        initMap(maps);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    cnt = 0;
                    dfs(i, j);
                    queue.add(cnt);
                }
            }
        }
        
        if (queue.isEmpty()) {
            return new int[] {-1};
        }
        
        answer = new int[queue.size()];
        int index = 0;
        while(!queue.isEmpty()) {
            answer[index++] = queue.poll();
        }
        return answer;
    }
    
    private void initMap(String[] maps) {
        int h = maps.length;
        int w = maps[0].length();
        
        map = new int[h][w];
        visited = new boolean[h][w];
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                String str = maps[i].substring(j, j + 1);
                if (str.equals("X")) {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = Integer.parseInt(str);
            } 
        }
    }
    
    private void dfs(int x, int y) {
        cnt += map[x][y];
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                continue;
            }
            
            if (!visited[nx][ny] && map[nx][ny] != 0) {
                dfs(nx, ny);
            }
        }
    }
}