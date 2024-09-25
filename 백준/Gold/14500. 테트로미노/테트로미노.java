import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class History {
        int cnt;
        int point;
        int[] last;
        int[] present;

        public History(int cnt, int point, int[] present, int[] last) {
            this.cnt = cnt;
            this.point = point;
            this.present = present;
            this.last = last;
        }
    }

    static int h;
    static int w;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapInfo = br.readLine().split(" ");

        h = Integer.parseInt(mapInfo[0]);
        w = Integer.parseInt(mapInfo[1]);

        map = new int[h][w];

        for (int i = 0; i < h; i++) {
            String[] lineInfo = br.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(lineInfo[j]);
            }
        }
        answer = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                History track = new History(1, map[i][j], new int[]{i, j}, null);
                getMaxPoint(track);
                getAnotherPoint(i, j);
            }
        }

        System.out.println(answer);
    }

    private static void getMaxPoint(History track) {
        if (track.cnt == 4) {
            answer = Math.max(answer, track.point);
            return;
        }

        int[] position = track.present;
        int x = position[0];
        int y = position[1];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                continue;
            }
            if (track.last != null) {
                if (nx == track.last[0] && ny == track.last[1]) {
                    continue;
                }
            }
            History next = new History(track.cnt + 1, track.point + map[nx][ny], new int[]{nx, ny}, track.present);
            getMaxPoint(next);
        }
    }

    private static void getAnotherPoint(int i, int j) {
        // 동쪽
        if (j + 2 < w) {
            if (i + 1 < h) {
                answer = Math.max(answer, map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i][j + 2]);
            }
            if (i - 1 >= 0) {
                answer = Math.max(answer, map[i][j] + map[i][j + 1] + map[i - 1][j + 1] + map[i][j + 2]);
            }
        }

        // 서쪽
        if (j - 2 >= 0) {
            if (i + 1 < h) {
                answer = Math.max(answer, map[i][j] + map[i][j - 1] + map[i + 1][j - 1] + map[i][j - 2]);
            }
            if (i - 1 >= 0) {
                answer = Math.max(answer, map[i][j] + map[i][j - 1] + map[i - 1][j - 1] + map[i][j - 2]);
            }
        }

        // 남쪽
        if (i + 2 < h) {
            if (j + 1 < w) {
                answer = Math.max(answer, map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j]);
            }
            if (j - 1 >= 0) {
                answer = Math.max(answer, map[i][j] + map[i + 1][j] + map[i + 1][j - 1] + map[i + 2][j]);
            }
        }

        // 북쪽
        if (i - 2 >= 0) {
            if (j + 1 < w) {
                answer = Math.max(answer, map[i][j] + map[i - 1][j] + map[i - 1][j + 1] + map[i - 2][j]);
            }
            if (j - 1 >= 0) {
                answer = Math.max(answer, map[i][j] + map[i - 1][j] + map[i - 1][j - 1] + map[i - 2][j]);
            }
        }
    }
}
