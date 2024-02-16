import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] table;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        table = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        selectTeam(0, 0);
        System.out.println(answer);
    }

    private static void selectTeam(int k, int pre) {
        if (k == N / 2) {
            int scoreGap = getDiffTeamScore();
            answer = Math.min(answer, scoreGap);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && pre < i + 1) {
                visited[i] = true;
                selectTeam(k + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static int getDiffTeamScore() {
        int startTeamScore = 0;
        int linkTeamScore = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeamScore += table[i][j];
                    startTeamScore += table[j][i];
                }
                if (!visited[i] && !visited[j]) {
                    linkTeamScore += table[i][j];
                    linkTeamScore += table[j][i];
                }
            }
        }

        return Math.abs(startTeamScore - linkTeamScore);
    }
}
