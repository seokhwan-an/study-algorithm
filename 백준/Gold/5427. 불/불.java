import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int h;
    static int w;
    static int[][] map;

    static Fire[][] fireMap;
    static Queue<Fire> fireQueue;
    static Queue<int[]> personQueue;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer;

    static class Fire {
        int x;
        int y;
        int time;

        public Fire(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] mapInfo = br.readLine().split(" ");
            h = Integer.parseInt(mapInfo[1]);
            w = Integer.parseInt(mapInfo[0]);

            map = new int[h][w];
            fireMap = new Fire[h][w];
            fireQueue = new LinkedList<>();
            personQueue = new LinkedList<>();

            for (int j = 0; j < h; j++) {
                String[] lineInput = br.readLine().split("");
                for (int k = 0; k < w; k++) {
                    if (lineInput[k].equals("#")) {
                        map[j][k] = 1;
                    }

                    if (lineInput[k].equals("*")) {
                        Fire fire = new Fire(j, k, 0);
                        fireMap[j][k] = fire;
                        fireQueue.offer(fire);
                    }

                    if (lineInput[k].equals("@")) {
                        personQueue.offer(new int[]{j, k, 0});
                    }
                }
            }

            answer = 0;
            moveFire();
            movePerson();

            if (answer == 0) {
                sb.append("IMPOSSIBLE").append("\n");
            } else {
                sb.append(answer).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static void moveFire() {
        boolean[][] visited = new boolean[h][w];
        while(!fireQueue.isEmpty()) {
            Fire p = fireQueue.poll();
            visited[p.x][p.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                // map을 벗어난 경우
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    continue;
                }

                // 벽인 경우
                if (map[nx][ny] == 1) {
                    continue;
                }

                if (!visited[nx][ny] || fireMap[nx][ny].time > p.time + 1) {
                    visited[nx][ny] = true;
                    Fire next = new Fire(nx, ny, p.time + 1);
                    fireMap[nx][ny] = next;
                    fireQueue.offer(next);
                }
            }
        }
    }

    private static void movePerson() {
        boolean[][] visited = new boolean[h][w];
        while(!personQueue.isEmpty()) {
            int[] p = personQueue.poll();
            visited[p[0]][p[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                // 탈출
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    answer = p[2] + 1;
                    return;
                }

                // 벽
                if (map[nx][ny] == 1) {
                    continue;
                }

                // 이동 위치에 불이 있는 경우
                if (fireMap[nx][ny] != null && fireMap[nx][ny].time <= p[2] + 1) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    personQueue.offer(new int[] {nx, ny, p[2] + 1});
                }
            }
        }
    }
}
