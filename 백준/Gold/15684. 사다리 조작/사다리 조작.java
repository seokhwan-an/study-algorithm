import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 사다리
// N은 너비(세로선), H는 높이
// 두 가로선이 연속하거나 서로 접하면 안됨
public class Main {

    static int N;
    static int H;
    static boolean[][] ladder;
    static boolean[][] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ladderInfo = br.readLine().split(" ");
        N = Integer.parseInt(ladderInfo[0]);
        H = Integer.parseInt(ladderInfo[2]);
        ladder = new boolean[H + 1][N];

        int M = Integer.parseInt(ladderInfo[1]);

        for (int i = 0; i < M; i++) {
            String[] lineInfo = br.readLine().split(" ");
            int a = Integer.parseInt(lineInfo[0]);
            int b = Integer.parseInt(lineInfo[1]);
            ladder[a][b] = true;
        }

        answer = -1;
        for (int i = 0; i <= 3; i++) {
            if (answer != -1) {
                break;
            }

            visited = new boolean[H + 1][N];
            findAnswer(i, 0, 0, 0);
        }

        System.out.println(answer);
    }

    private static void findAnswer(int n, int k, int x, int y) {
        if (k == n) {
            // 사다리 타기
            if (available()) {
                answer = n;
            }
            return;
        }

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (i < x || i == x && j < y) {
                    continue;
                }
                if (!visited[i][j] && !ladder[i][j]) {
                    int right = j + 1;
                    int left = j - 1;
                    if ((j == N - 1 && !ladder[i][left]) || (j == 1 && !ladder[i][right]) || (!ladder[i][left] && !ladder[i][right])) {
                        visited[i][j] = true;
                        findAnswer(n, k + 1, i, j);
                        visited[i][j] = false;
                    }
                }
            }
        }
    }

    private static boolean available() {
        boolean[][] fixedLadder = copy();
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (visited[i][j]) {
                    fixedLadder[i][j] = true;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int result = getLadderResult(fixedLadder, i);
            if (result != i) {
                return false;
            }
        }

        return true;
    }

    private static boolean[][] copy() {
        boolean[][] copied = new boolean[H + 1][N];
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                copied[i][j] = ladder[i][j];
            }
        }

        return copied;
    }

    private static int getLadderResult(boolean[][] fixedLadder, int start) {
        int position = start;
        for (int i = 1; i <= H; i++) {
            if (position == 1) {
               if (fixedLadder[i][position]) {
                   position++;
               }
            } else if (position == N) {
                if (fixedLadder[i][position - 1]) {
                    position--;
                }
            } else {
                boolean right = fixedLadder[i][position];
                boolean left = fixedLadder[i][position - 1];

                if (right) {
                    position++;
                }

                if (left) {
                    position--;
                }
            }
        }

        return position;
    }
}
