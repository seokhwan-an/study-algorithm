import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int index = 1;
        int n = Integer.parseInt(br.readLine());
        while (true) {
            if (n == 0) {
                break;
            }
            int[][] map = new int[n][3];

            for (int i = 0; i < n; i++) {
                String[] lineInput = br.readLine().split(" ");
                for (int j = 0; j < 3; j++) {
                    map[i][j] = Integer.parseInt(lineInput[j]);
                }
            }

            int[][] dp = new int[n][3];
            dp[0][0] = Integer.MAX_VALUE;
            dp[0][1] = map[0][1];
            dp[0][2] = dp[0][1] + map[0][2];

            dp[1][0] = map[1][0] + dp[0][1];
            dp[1][1] = Math.min(Math.min(dp[1][0], dp[0][1]), dp[0][2]) + map[1][1];
            dp[1][2] = Math.min(Math.min(dp[1][1], dp[0][1]), dp[0][2]) + map[1][2];

            for (int i = 2; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + map[i][j];
                        continue;
                    }

                    if (j == 2) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + map[i][j];
                        continue;
                    }

                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])), dp[i][j - 1]) + map[i][j];
                }
            }

            sb.append(index).append(". ").append(dp[n - 1][1]).append("\n");

            index++;
            n = Integer.parseInt(br.readLine());
        }

        System.out.println(sb.toString());
    }
}
