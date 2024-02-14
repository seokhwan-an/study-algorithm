import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int answer = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        solution(0);
        System.out.println(answer);
    }

    private static void solution(int n) {
        if (n == N) {
            answer++;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (!visited[n][j]) {
                visited[n][j] = true;
                if (checkQueen(n, j)) {
                    solution(n + 1);
                }
                visited[n][j] = false;
            }
        }
    }

    private static boolean checkQueen(int x, int y) {
        if (checkUpSide(x, y) || checkUpRightSide(x, y) || checkUpLeftSide(x, y)) {
            return false;
        }

        return true;
    }

    private static boolean checkUpSide(int x, int y) {
        x -= 1;
        while (x >= 0) {
            if (visited[x][y]) {
                return true;
            }
            x -= 1;
        }
        return false;
    }

    private static boolean checkUpRightSide(int x, int y) {
        x -= 1;
        y += 1;
        while (x >= 0 && y < N) {
            if (visited[x][y]) {
                return true;
            }
            x -= 1;
            y += 1;
        }
        return false;
    }

    private static boolean checkUpLeftSide(int x, int y) {
        x -= 1;
        y -= 1;
        while (x >= 0 && y >= 0) {
            if (visited[x][y]) {
                return true;
            }
            x -= 1;
            y -= 1;
        }
        return false;
    }
}
