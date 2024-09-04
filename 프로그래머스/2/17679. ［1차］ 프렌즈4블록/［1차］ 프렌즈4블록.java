class Solution {
    
    int x;
    int y;
    int answer;
    String[][] map;
    boolean[][] check;
    
    public int solution(int m, int n, String[] board) {
        answer = 0;
        x = m;
        y = n;
        map = new String[x][y];
              
        // board를 map으로 수정
        for (int i = 0; i < x; i++) {
            String line = board[i];
            for (int j = 0; j < y; j++) {
                String point = line.substring(j, j + 1);
                map[i][j] = point;
            }
        }

        while (true) {
            check = new boolean[x][y];
            
            // 지워질 수 있는 블록이 없음
            if (!available()) {
                break;
            }
            
            // 블록 지우기 + answer에 값 더하기
            deleteBlock();

            
            // 블록 옮기기
            moveBlock();
     
        }
        
        return answer;
    }
    
    private boolean available() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j].equals(" ")) {
                    continue;
                }
                findSquare(i, j);
            }
        }
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (check[i][j]) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private void findSquare(int m, int n) {
        int[] dx = {0, 1, 1, 1, 1, 0, 0, -1, -1, -1, -1, 0};
        int[] dy = {1, 1, 0, 0, -1, -1, -1, -1, 0, 0, 1, 1};
        String target = map[m][n];
        for (int i = 0; i < 4; i++) {
            boolean available = true;
            for (int j = i * 3; j < i * 3 + 3; j++) {
                int nx = m + dx[j];
                int ny = n + dy[j];
                
                if (nx < 0 || nx >= x || ny < 0 || ny >= y) {
                    available = false;
                    break;
                }
            
                if (!target.equals(map[nx][ny])) {
                    available = false;
                    break;
                }
            }
            if (available) {
                check[m][n] = true;
                for (int k = i * 3; k < i * 3 + 3; k++) {
                    int nx = m + dx[k];
                    int ny = n + dy[k];
                    check[nx][ny] = true;
                }
            }
        }
    }
    
    private void deleteBlock() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (check[i][j]) {
                    answer++;
                    map[i][j] = " ";
                }
            }
        }
    }
    
    private void moveBlock() {
        for (int i = 0; i < y; i++) {
            for (int j = x - 1; j >= 0; j--) {
                if (map[j][i].equals(" ")) {
                    continue;
                }
                int nextIndex = j + 1;
                int targetIndex = j;
                String target = map[targetIndex][i];
                while (true) {
                    if (nextIndex >= x) {
                        break;
                    }
                    
                    String next = map[nextIndex][i];
                    if (next.equals(" ")) {
                        map[nextIndex][i] = target;
                        map[targetIndex][i] = next;
                    }
                    nextIndex++;
                    targetIndex++;
                }
            }
        }
    }
}