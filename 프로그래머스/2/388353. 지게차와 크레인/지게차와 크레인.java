// 박스 제거
// 접근 가능 확인
import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        String[][] map = initMap(storage);
        
        for (String request : requests) {
            int[][] remove = new int[map.length][map[0].length];
            if (request.length() == 2) {
                String target = request.substring(0, 1);
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[0].length; j++) {
                        if (map[i][j].equals(target)) {
                            remove[i][j] = 1;
                        }
                    }
                }
            } else {
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[0].length; j++) {
                        if (map[i][j].equals(request) && isAvailable(map, i, j)) {
                            remove[i][j] = 1;
                        }
                    }
                }
            }
            
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (remove[i][j] == 1) {
                        map[i][j] = "0";
                    }
                }
            }
        }
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!map[i][j].equals("0")) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
    private String[][] initMap(String[] s) {
        int r = s.length;
        int c = s[0].length();
        String[][] map = new String[r][c];
        
        for (int i = 0; i < r; i++) {
            String k = s[i];
            for (int j = 0; j < c; j++) {
                map[i][j] = k.substring(j, j + 1);
            }
        }
        
        return map;
    }
    
    private boolean isAvailable(String[][] map, int x, int y) {
        int r = map.length;
        int c = map[0].length;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[r][c];
                    
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        while(!q.isEmpty()) {
            int[] p = q.poll();
            int cx = p[0];
            int cy = p[1];
                        
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    return true;
                }
                            
                if (map[nx][ny].equals("0") && !visited[nx][ny]) {
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return false;
    }
}