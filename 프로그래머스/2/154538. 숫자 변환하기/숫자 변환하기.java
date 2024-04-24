import java.util.*;

class Solution {
    
    class Point {
        
        int value;
        int count;
        
        public Point(int value, int count) {
            this.value = value;
            this.count = count;
        }
        
    }
    
    boolean[] visited;
    
    public int solution(int x, int y, int n) {
        visited = new boolean[y + 1];
        int answer = bfs(x, new Point(y, 0), n);
        return answer;
    }
    
    private int bfs(int start, Point end, int n) {
        Queue<Point> queue = new LinkedList<>();
        int answer = -1;
        
        queue.add(end);
        
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            visited[point.value] = true;
            
            if (point.value == start) {
                answer = point.count;
                break;
            }
            
            if (point.value % 2 == 0 && !visited[point.value / 2]) {
                queue.offer(new Point(point.value / 2, point.count + 1));
            }
            
            if (point.value % 3 == 0 && !visited[point.value / 3]) {
                queue.offer(new Point(point.value / 3, point.count + 1));
            }
            
            if (point.value - n >= start && !visited[point.value - n]) {
                queue.offer(new Point(point.value - n, point.count + 1));
            }
        }
        return answer;
    } 
}