import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static String[][] map = new String[12][6];
    static int answer = 0;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Deque<int[]> removePoint = new LinkedList<>();
    static boolean available;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        solution();
        System.out.println(answer);
    }

    private static void init(BufferedReader br) throws IOException {
        for (int i = 0; i < 12; i++) {
            String[] lineInputs = br.readLine().split("");
            for (int j = 0; j < 6; j++) {
                map[i][j] = lineInputs[j];
            }
        }
    }

    private static void solution() {
        while (isRemovable()) {
            answer++;
            while (!removePoint.isEmpty()) {
                int[] loc = removePoint.poll();
                map[loc[0]][loc[1]] = ".";
            }
            reorder();
        }
    }

    private static boolean isRemovable() {
        visited = new boolean[12][6];
        available = false;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                String color = map[i][j];
                if (isColored(color) && !visited[i][j]) {
                    addRemovePoint(i, j);
                }
            }
        }
        return available;
    }

    private static boolean isColored(String color) {
        return color.equals("R") || color.equals("G")
            || color.equals("B") || color.equals("P")
            || color.equals("Y");
    }

    private static void addRemovePoint(int x, int y) {
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        removePoint.add(new int[]{x, y});
        String color = map[x][y];
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            int locX = loc[0];
            int locY = loc[1];
            visited[locX][locY] = true;

            for (int i = 0; i < 4; i++) {
                int nx = locX + dx[i];
                int ny = locY + dy[i];

                if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) {
                    continue;
                }

                if (map[nx][ny].equals(color) && !visited[nx][ny]) {
                    cnt++;
                    removePoint.offer(new int[]{nx, ny});
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        if (cnt >= 4) {
            available = true;
        } else {
            for (int i = 0; i < cnt; i++) {
                removePoint.removeLast();
            }
        }
    }

    private static void reorder() {
        for (int i = 10; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                String color = map[i][j];
                if (isColored(color)) {
                    move(i, j, color);
                }
            }
        }
    }

    private static void move(int x, int y, String color) {
        x += 1;
        while (x <= 11) {
            if (map[x][y].equals(".")) {
                map[x - 1][y] = ".";
                map[x][y] = color;
            }
            x += 1;
        }
    }
}
