import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int h;
    static int w;

    static int[][] map;
    static int[][] answer;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        h = Integer.parseInt(input[0]);
        w = Integer.parseInt(input[1]);

        map = new int[h][w];
        answer = new int[h][w];
        visited = new boolean[h][w];

        int sx = 0;
        int sy = 0;

        for (int i = 0; i < h; i++) {
            String[] lineInput = br.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                int num = Integer.parseInt(lineInput[j]);
                if (num == 2) {
                    sx = i;
                    sy = j;
                }

                map[i][j] = num;
            }
        }

        bfs(sx, sy);
        update();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int sx, int sy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        answer[sx][sy] = 0;

        while(!queue.isEmpty()) {
            int[] p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    answer[nx][ny] = p[2] + 1;
                    queue.offer(new int[]{nx, ny, p[2] + 1});
                }
            }
        }
    }

    private static void update() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1 && answer[i][j] == 0) {
                    answer[i][j] = -1;
                }
            }
        }
    }
}
