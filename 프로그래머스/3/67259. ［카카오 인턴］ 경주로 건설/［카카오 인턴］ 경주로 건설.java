import java.util.*;

class Solution {
    
    class Car {
        int x;
        int y;       
        int value;
        int dir;
        
        public Car(int x, int y, int value, int dir) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.dir = dir;
        }
    }
    
    public int solution(int[][] board) {
        int n = board.length;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][][] visited = new int[n][n][4];
        
        int answer = Integer.MAX_VALUE;
        
        Queue<Car> queue = new LinkedList<>();
        Car car = new Car(0, 0, 0, -1);
        queue.offer(car);
        
        while(!queue.isEmpty()) {
            Car p = queue.poll();
            
            if (p.x == n - 1 && p.y == n - 1) {
                answer = Math.min(answer, p.value);
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                    continue;
                }
                
                int cost = p.value;
                if (p.dir == -1 || p.dir == i) {
                    cost += 100;
                } else {
                    cost += 600;
                }
                
                if (visited[nx][ny][i] == 0 || board[nx][ny] >= cost) {
                    visited[nx][ny][i] = 1;
                    board[nx][ny] = cost;
                    queue.add(new Car(nx, ny, cost, i));
                }
            }
        }
        
        return answer;
    }
}