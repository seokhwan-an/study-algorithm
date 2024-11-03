import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] lineInput = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(lineInput[j]);
            }
        }

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = map[i][j];
                    continue;
                }
                dp[i][j] += dp[i][j - 1] + map[i][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] order = br.readLine().split(" ");
            int sx = Integer.parseInt(order[0]);
            int sy = Integer.parseInt(order[1]);
            int ex = Integer.parseInt(order[2]);
            int ey = Integer.parseInt(order[3]);

            int sum = 0;
            for (int j = sx - 1; j < ex; j++) {
                sum += dp[j][ey - 1];
                if (sy > 1) {
                    sum -= dp[j][sy - 2];
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }
}
