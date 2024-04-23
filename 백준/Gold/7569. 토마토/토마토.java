import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int H;
    static int N;
    static int M;
    static int answer = 0;
    static Tomato[][][] map;
    static boolean[][][] visited;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static class Tomato {
        int value;
        int day;
        int z;
        int y;
        int x;

        public Tomato (int value, int day, int z, int y, int x) {
            this.value = value;
            this.day = day;
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        M = Integer.parseInt(inputs[0]);
        N = Integer.parseInt(inputs[1]);
        H = Integer.parseInt(inputs[2]);

        // 높이, 세로, 가로
        map = new Tomato[H][N][M];
        visited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                String[] tomatoInput = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    int value = Integer.parseInt(tomatoInput[k]);
                    map[i][j][k] = new Tomato(value, 0, i, j, k);
                }
            }
        }

        if (isAllGrow()) {
            System.out.println(0);
        } else {
            bfs();
            if (isAllGrow()) {
                System.out.println(answer);
            } else {
                System.out.println(-1);
            }
        }
    }

    private static boolean isAllGrow() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    Tomato tomato = map[i][j][k];
                    if (tomato.value == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void bfs() {
        Queue<Tomato> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    Tomato tomato = map[i][j][k];
                    if (tomato.value == 1) {
                        queue.add(tomato);
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            Tomato tomato = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nz = tomato.z + dz[i];
                int ny = tomato.y + dy[i];
                int nx = tomato.x + dx[i];

                if (nz < 0 || nz >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    continue;
                }

                if (!visited[nz][ny][nx] && map[nz][ny][nx].value == 0) {
                    visited[nz][ny][nx] = true;
                    Tomato next = new Tomato(1, tomato.day + 1, nz, ny, nx);
                    answer = next.day;
                    map[nz][ny][nx] = next;
                    queue.offer(next);
                }
            }
        }
    }
}
