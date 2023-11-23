import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0,0,1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            Position position = queue.poll();
            
            if (position.x == maps.length - 1 && position.y == maps[0].length - 1) {
                answer = position.moveCnt;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = position.x + dx[i];
                int ny = position.y + dy[i];
                
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) {
                   continue;
                }
                
                if (!visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new Position(nx, ny, position.moveCnt + 1));
                }
            }
        }
        
        if (answer == 0) {
            answer = -1;
        }
        return answer;
    }
    
    class Position {
        
        int x;
        int y;
        int moveCnt;
        
        public Position (int x, int y, int moveCnt) {
            this.x = x;
            this.y = y;
            this.moveCnt = moveCnt;
        }
    }
}