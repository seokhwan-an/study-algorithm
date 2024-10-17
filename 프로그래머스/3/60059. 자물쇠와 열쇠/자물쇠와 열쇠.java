import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        
        List<int[]> keyPoints = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (key[i][j] == 1) {
                    keyPoints.add(new int[]{i, j});
                }
            }
        }
    
        int lockCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lock[i][j] == 0) {
                    lockCnt += 1;
                }
            }
        }
        
        int max = Math.max(M, N);
        
        for (int i = 0; i < 4; i++) {
            if (i != 0) {
                rotate(keyPoints, M);
            }
            
            for (int j = (-1 * N); j <= N; j++) {
                for (int k = (-1 * N); k <= N; k++) {
                    int check = 0;
                    boolean available = true;
                    for (int h = 0; h < keyPoints.size(); h++) {
                        int[] point = keyPoints.get(h);
                        int nx = point[0] + j;
                        int ny = point[1] + k;
                        
                        if (isOut(nx, ny, N)) {
                            continue;
                        }
                        if (lock[nx][ny] == 1) {
                            available = false;
                        }
                        
                        
                        if (lock[nx][ny] == 0) {
                            check++;
                        }
                    }
                    if (check == lockCnt && available) {
                        return true;
                    }
                }
            }
        }
        
  
        
        return false;
    }
    
    private void rotate(List<int[]> keyPoints, int M) {
        for (int i = 0; i < keyPoints.size(); i++) {
            int[] point = keyPoints.get(i);
            int nextY = M - 1 - point[0];
            int nextX = point[1];
            
            point[0] = nextX;
            point[1] = nextY;
        }
    }
    
    private boolean isOut(int x, int y, int N) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }
}