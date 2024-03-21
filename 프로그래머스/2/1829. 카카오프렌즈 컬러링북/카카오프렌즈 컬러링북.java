class Solution {
    
    static boolean[][] visited;
    static int[][] map;
    static int pictureCnt;
    static int maxPictureSize;
    static int cnt;
    static int h;
    static int v;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        map = picture;
        pictureCnt = 0;
        maxPictureSize = 0;
        h = m;
        v = n;
        

        
        findColoredArea();
        int[] answer = new int[2];
        answer[0] = pictureCnt;
        answer[1] = maxPictureSize;
        return answer;
    }
    
    private void findColoredArea() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < v; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    cnt = 1;
                    pictureCnt += 1;
                    dfs(map[i][j], i, j);
                    maxPictureSize = Math.max(cnt, maxPictureSize);
                }
            }
        }
    }
    
    private void dfs(int colorType, int x, int y) {
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || ny < 0 || nx >= h || ny >= v) {
                continue;
            }
            
            if (map[nx][ny] == colorType && !visited[nx][ny]) {
                cnt += 1;
                dfs(colorType, nx, ny);
            }
        }
    }
}