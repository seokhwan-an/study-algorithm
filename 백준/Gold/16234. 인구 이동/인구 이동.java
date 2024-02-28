import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int N;
    static int L;
    static int R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean isMovable = true;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        L = Integer.parseInt(inputs[1]);
        R = Integer.parseInt(inputs[2]);

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] lineInputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(lineInputs[j]);
            }
        }

        while(isMovable) {
            solution();
        }

        System.out.println(answer);
    }

    private static void solution() {
        visited = new boolean[N][N];
        isMovable = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        if (isMovable) {
            answer++;
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> changeLocs = new ArrayList<>();
        queue.add(new int[] {x, y});
        changeLocs.add(new int[] {x, y});
        visited[x][y] = true;
        int people = map[x][y];
        int cnt = 1;

        while(!queue.isEmpty()) {
            int[] loc = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = loc[0] + dx[i];
                int ny = loc[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                int diff = Math.abs(map[loc[0]][loc[1]] - map[nx][ny]);

                if (diff >= L && diff <= R && !visited[nx][ny]) {
                    if (!isMovable) {
                        isMovable = true;
                    }
                    cnt++;
                    people += map[nx][ny];
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                    changeLocs.add(new int[] {nx, ny});
                }
            }
        }

        int changedPeople = people / cnt;

        for (int[] changeLoc : changeLocs) {
            map[changeLoc[0]][changeLoc[1]] = changedPeople;
        }
    }
}
