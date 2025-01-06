import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int R;
    static int C;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int moveCnt = 0;
    static String[][] map;
    static Set<String> check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        map = new String[R][C];
        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = line[j];
            }
        }

        check = new HashSet<>();
        check.add(map[0][0]);
        dfs(0, 0, 1);
        System.out.println(moveCnt);
    }

    private static void dfs(int x, int y, int move) {
        moveCnt = Math.max(moveCnt, move);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                continue;
            }

            if (check.contains(map[nx][ny])) {
                continue;
            }

            check.add(map[nx][ny]);
            dfs(nx, ny, move + 1);
            check.remove(map[nx][ny]);
        }
    }
}
