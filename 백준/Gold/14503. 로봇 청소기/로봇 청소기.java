import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    static int N;
    static int M;
    static int robotX;
    static int robotY;
    static int robotDir;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapInputs = br.readLine().split(" ");
        N = Integer.parseInt(mapInputs[0]);
        M = Integer.parseInt(mapInputs[1]);

        map = new int[N][M];
        String[] robotInfo = br.readLine().split(" ");
        robotX = Integer.parseInt(robotInfo[0]);
        robotY = Integer.parseInt(robotInfo[1]);
        robotDir = Integer.parseInt(robotInfo[2]);

        for (int i = 0; i < N; i++) {
            String[] lineInput = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(lineInput[j]);
            }
        }

        solution();
        System.out.println(answer);
    }

    private static void solution() {
        while (true) {
            // 1번 실행
            if (map[robotX][robotY] == 0) {
                map[robotX][robotY] = 2;
                answer++;
            }

            if (canCleanSpot()) {
                // 반시계 방향으로 90도 회전
                robotDir = (robotDir + 3) % 4;
                if (robotDir == 0) {
                    int nx = robotX - 1;
                    if (nx >= 0 && map[nx][robotY] == 0) {
                        robotX -= 1;
                        continue;
                    }
                }

                if (robotDir == 1) {
                    int ny = robotY + 1;
                    if (ny < M && map[robotX][ny] == 0) {
                        robotY += 1;
                        continue;
                    }
                }

                if (robotDir == 2) {
                    int nx = robotX + 1;
                    if (nx < N && map[nx][robotY] == 0) {
                        robotX += 1;
                        continue;
                    }
                }

                if (robotDir == 3) {
                    int ny = robotY - 1;
                    if (ny >= 0 && map[robotX][ny] == 0) {
                        robotY -= 1;
                    }
                }
            } else {
                if (robotDir == 0) {
                    int nx = robotX + 1;
                    if (nx >= N || map[nx][robotY] == 1) {
                        break;
                    }
                    robotX += 1;
                }
                if (robotDir == 1) {
                    int ny = robotY - 1;
                    if (ny < 0 || map[robotX][ny] == 1) {
                        break;
                    }
                    robotY -= 1;
                }
                if (robotDir == 2) {
                    int nx = robotX - 1;
                    if (nx < 0 || map[nx][robotY] == 1) {
                        break;
                    }
                    robotX -= 1;
                }
                if (robotDir == 3) {
                    int ny = robotY + 1;
                    if (ny >= M || map[robotX][ny] == 1) {
                        break;
                    }
                    robotY += 1;
                }
            }
        }
    }

    private static boolean canCleanSpot() {
        for (int i = 0; i < 4; i++) {
            int nx = robotX + dx[i];
            int ny = robotY + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            if (map[nx][ny] == 0) {
                return true;
            }
        }

        return false;
    }
}
