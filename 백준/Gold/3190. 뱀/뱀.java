import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    static int N;
    static int[][] map;
    static int x = 0;
    static int y = 0;
    static int dir = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Map<Integer, String> turnInfo = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> queue = new LinkedList<>();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        queue.offer(new int[]{0, 0});
        map[x][y] = 2;

        int appleCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < appleCnt; i++) {
            String[] appleLoc = br.readLine().split(" ");
            int appleX = Integer.parseInt(appleLoc[0]);
            int appleY = Integer.parseInt(appleLoc[1]);
            map[appleX - 1][appleY - 1] = 1;
        }

        int moveInfoCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < moveInfoCnt; i++) {
            String[] moveInfo = br.readLine().split(" ");
            int second = Integer.parseInt(moveInfo[0]);
            String turn = moveInfo[1];
            turnInfo.put(second, turn);
        }

        int answer = 0;
        int time = 0;
        while (true) {
            answer++;
            time++;
            // 움직임
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            // 이동가능한지
            if (nx < 0 || ny < 0 || nx >= N  || ny >= N || map[nx][ny] == 2) {
                break;
            }
            // 사과가 없으면
            if (map[nx][ny] == 0) {
                int[] loc = queue.poll();
                map[loc[0]][loc[1]] = 0;
            }
            queue.offer(new int[]{nx, ny});
            map[nx][ny] = 2;
            x = nx;
            y = ny;

            if (turnInfo.containsKey(time)) {
                String turn = turnInfo.get(time);
                if (turn.equals("D")) {
                    dir = (dir + 1) % 4;
                } else {
                    dir = (dir + 3) % 4;
                }
            }
        }

        System.out.println(answer);
    }
}
