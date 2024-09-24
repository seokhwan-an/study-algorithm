import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int height;
    static int width;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapInfo = br.readLine().split(" ");
        height = Integer.parseInt(mapInfo[0]);
        width = Integer.parseInt(mapInfo[1]);

        map = new int[height][width];
        visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            String[] lineInfo = br.readLine().split(" ");
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(lineInfo[j]);
            }
        }

        answer = 0;
        findBestWay(0, 0, 0);

        System.out.println(answer);
    }

    private static void findBestWay(int n, int h, int w) {
        if (n == 3) {
            int safeArea = getSafeArea();
            answer = Math.max(answer, safeArea);
            return;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i < h && j < w) {
                    continue;
                }

                if (!visited[i][j] && map[i][j] == 0) {
                    visited[i][j] = true;
                    findBestWay(n + 1, i, j);
                    visited[i][j] = false;
                }
            }
        }
    }

    private static int getSafeArea() {
        int[][] copyMap = copy();
        boolean[][] terminated = new boolean[height][width];
        Queue<int[]> queue = new LinkedList<>();
        int safeArea = 0;

        // 벽 세우기 && 바이러스 위치 넣기
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (visited[i][j]) {
                    copyMap[i][j] = 1;
                }

                if (map[i][j] == 2) {
                    terminated[i][j] = true;
                    queue.offer(new int[]{i, j});
                }

                if (copyMap[i][j] == 0) {
                    safeArea += 1;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                // 연구소를 벗어나는 경우
                if (nx < 0 || nx >= height || ny < 0 || ny >= width) {
                    continue;
                }

                // 감염이 이미 된 경우 + 벽인 경우
                if (copyMap[nx][ny] == 2 || copyMap[nx][ny] == 1 || terminated[nx][ny]) {
                    continue;
                }

                terminated[nx][ny] = true;
                copyMap[nx][ny] = 2;
                safeArea -= 1;
                queue.offer(new int[]{nx, ny});
            }
        }
        return safeArea;
    }

    private static int[][] copy() {
        int[][] copiedMap = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                copiedMap[i][j] = map[i][j];
            }
        }

        return copiedMap;
    }
}
