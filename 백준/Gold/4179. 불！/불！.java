import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static int m;

    static int[][] map;
    static int[][] fireMap;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Queue<int[]> fireQueue;
    static Queue<int[]> jihoonQueue;

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapInfo = br.readLine().split(" ");

        n = Integer.parseInt(mapInfo[0]);
        m = Integer.parseInt(mapInfo[1]);

        map = new int[n][m];
        fireMap = new int[n][m];

        fireQueue = new LinkedList<>();
        jihoonQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] lineInput = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                String type = lineInput[j];
                if (type.equals("#")) {
                    map[i][j] = 1;
                    continue;
                }
                if (type.equals("F")) {
                    fireQueue.offer(new int[] {i, j, 1});
                    fireMap[i][j] = 1;
                    map[i][j] = 0;
                    continue;
                }

                if (type.equals("J")) {
                    jihoonQueue.offer(new int[] {i, j, 0});
                    map[i][j] = 0;
                    continue;
                }

                map[i][j] = 0;
            }
        }

        answer = Integer.MAX_VALUE;
        fireMove();
        jihoonMove();

        if (answer == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(answer);
        }
    }

    private static void fireMove() {
        boolean[][] visited = new boolean[n][m];

        while(!fireQueue.isEmpty()) {
            int[] p = fireQueue.poll();
            visited[p[0]][p[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 1) {
                    continue;
                }

                if (!visited[nx][ny] || fireMap[nx][ny] > p[2] + 1) {
                    visited[nx][ny] = true;
                    fireMap[nx][ny] = p[2] + 1;
                    fireQueue.offer(new int[] {nx, ny, p[2] + 1});
                }
            }
        }
    }

    private static void jihoonMove() {
        boolean[][] visited = new boolean[n][m];

        while(!jihoonQueue.isEmpty()) {
            int[] p = jihoonQueue.poll();
            visited[p[0]][p[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    answer = Math.min(answer, p[2] + 1);
                    return;
                }

                if (map[nx][ny] == 1) {
                    continue;
                }

                if (fireMap[nx][ny] >= 1 && fireMap[nx][ny] - 1 <= p[2] + 1) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    jihoonQueue.offer(new int[] {nx, ny, p[2] + 1});
                }
            }
        }
    }
}
