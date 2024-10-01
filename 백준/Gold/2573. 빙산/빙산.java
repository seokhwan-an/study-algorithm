import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static int M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapInfo = br.readLine().split(" ");

        N = Integer.parseInt(mapInfo[0]);
        M = Integer.parseInt(mapInfo[1]);
        map = new int[N][M];
        List<int[]> snow = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] lineInfo = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int point = Integer.parseInt(lineInfo[j]);
                if (point > 0){
                    snow.add(new int[]{i, j, point});
                }
                map[i][j] = Integer.parseInt(lineInfo[j]);
            }
        }

        int answer = 0;
        boolean isAllMelted;
        while (true) {
            int cnt = 0;
            isAllMelted = true;

            visited = new boolean[N][M];
            for (int[] point : snow) {
                int x = point[0];
                int y = point[1];
                if (!visited[x][y] && point[2] > 0) {
                    cnt += 1;
                    getAmount(x, y);
                }
            }
            if (cnt >= 2) {
                isAllMelted = false;
                break;
            }
            for (int[] point : snow) {
                int x = point[0];
                int y = point[1];

                int seaCnt = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }

                    if (map[nx][ny] == 0) {
                        seaCnt += 1;
                    }
                }
                if (seaCnt > point[2]) {
                    point[2] = 0;
                } else {
                    point[2] -= seaCnt;
                }
                if (point[2] > 0) {
                    isAllMelted = false;
                }
            }

            if (isAllMelted) {
                break;
            }

            for (int[] point : snow) {
                int x = point[0];
                int y = point[1];

                map[x][y] = point[2];
            }
            answer++;
        }

        if (isAllMelted) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }

    private static void getAmount(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            if (map[nx][ny] > 0 && !visited[nx][ny]) {
                getAmount(nx, ny);
            }
        }
    }
}
