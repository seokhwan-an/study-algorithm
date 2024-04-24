import java.util.*;

class Solution {
    
    class Robot {
        int x;
        int y;
        int count;
        
        public Robot(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    String[][] map;
    boolean[][] visited;
    
    public int solution(String[] board) {
        int answer = 0;
        initMap(board);
        visited = new boolean[map.length][map[0].length];
        int[] robotAndArrivalPosition = findRobotPositionAndArrival();
        
        answer = bfs(robotAndArrivalPosition);
        if (answer == 0) {
            return -1;
        }
        
        return answer;
    }
    
    private void initMap(String[] board) {
        int h = board.length;
        int w = board[0].length();
        map = new String[h][w];
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[i][j] = board[i].substring(j, j + 1);
            }
        }
    }
    
    private int[] findRobotPositionAndArrival() {
        int robotX = 0;
        int robotY = 0;
        int arrivalX = 0;
        int arrivalY = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j].equals("R")) {
                    robotX = i;
                    robotY = j;
                }
                if (map[i][j].equals("G")) {
                    arrivalX = i;
                    arrivalY = j;
                }
            }
        }
        
        return new int[] {robotX, robotY, arrivalX, arrivalY};
    }
    
    private int bfs(int[] robotAndArrivalPosition) {
        int robotX = robotAndArrivalPosition[0];
        int robotY = robotAndArrivalPosition[1];
        int arrivalX = robotAndArrivalPosition[2];
        int arrivalY = robotAndArrivalPosition[3];

        int answer = 0;
        visited[robotX][robotY] = true;
        
        Queue<Robot> queue = new LinkedList<>();
        queue.add(new Robot(robotX, robotY, 0));
        
        while(!queue.isEmpty()) {
            Robot robot = queue.poll();
            
            if (robot.x == arrivalX && robot.y == arrivalY) {
                answer = robot.count;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int[] next = null;
                
                // 동쪽으로 이동
                if (i == 0) {
                    next = moveEast(robot);
                }
                // 서쪽으로 이동
                if (i == 1) {
                    next = moveWest(robot);
                }
                // 남쪽으로 이동
                if (i == 2) {
                    next = moveSouth(robot);
                }
                
                // 북쪽으로 이동
                if (i == 3) {
                    next = moveNorth(robot);
                }
                
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new Robot(next[0], next[1], robot.count + 1));
                }
            }
        }
        
        return answer;
    } 
    
    private int[] moveEast(Robot robot) {
        int y = robot.y;
        int next = y;
        
        for (int i = y + 1; i < map[0].length; i++) {
            next = i;
            if (map[robot.x][i].equals("D")) {
                next = i - 1;
                break;
            } 
        }
        return new int[] {robot.x, next};
    }
    
     private int[] moveWest(Robot robot) {
        int y = robot.y;
        int next = y;
        
        for (int i = y - 1; i >= 0; i--) {
            next = i;
            if (map[robot.x][i].equals("D")) {
                next = i + 1;
                break;
            } 
        }
        return new int[] {robot.x, next};
    }
    
    private int[] moveNorth(Robot robot) {
        int x = robot.x;
        int next = x;
        
        for (int i = x - 1; i >= 0; i--) {
            next = i;
            if (map[i][robot.y].equals("D")) {
                next = i + 1;
                break;
            } 
        }
        return new int[] {next, robot.y};
    }
    
    private int[] moveSouth(Robot robot) {
        int x = robot.x;
        int next = x;
        
        for (int i = x + 1; i < map.length; i++) {
            next = i;
            if (map[i][robot.y].equals("D")) {
                next = i - 1;
                break;
            } 
        }
        return new int[] {next, robot.y};
    }
}