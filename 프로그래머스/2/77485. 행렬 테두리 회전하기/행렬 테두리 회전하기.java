class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] map = new int[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = columns * i + j + 1;
            }
        }
        int index = 0;
        for (int[] query : queries) {
            answer[index++] = move(map, query);
        }
        return answer;
    }
    
    private int move(int[][] map , int[] query) {
        int startX = query[0] - 1;
        int startY = query[1] - 1;
        int endX = query[2] - 1;
        int endY = query[3] - 1;
        
        int min = Integer.MAX_VALUE;
        
        int x = query[0] - 1;
        int y = query[1] - 1;
        int move = map[x][y];
        int next = map[x][y + 1];
        int cnt = 0;
        while (true) {
            min = Math.min(min, move);
            if (cnt != 0 && x == startX && y == startY) {
                break;
            }
            cnt++;
            // 오른쪽로 이동
            if (x == startX && y + 1 <= endY) {
                next = map[x][y + 1];
                map[x][y + 1] = move;
                y++;
                move = next;
                continue;
           }
            // 아래로 이동
            if (y == endY && x + 1 <= endX) {
                next = map[x + 1][y];
                map[x + 1][y] = move;
                x++;
                move = next;
                continue;
            }
            // 왼쪽으로 이동
            if (x == endX && y - 1 >= startY) {
                next = map[x][y - 1];
                map[x][y - 1] = move;
                y--;
                move = next;
                continue;
            }
            // 위로 이동
            next = map[x - 1][y];
            map[x - 1][y] = move;
            x--;
            move = next;
        }
        
        return min;
    }
}