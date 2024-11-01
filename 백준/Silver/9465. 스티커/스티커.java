import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[3][n + 1];
            for (int j = 1; j <= 2; j++) {
                String[] sticker = br.readLine().split(" ");
                for (int k = 1; k <= n; k++) {
                    stickers[j][k] = Integer.parseInt(sticker[k - 1]);
                }
            }

            if (n == 1) {
                sb.append(Math.max(stickers[1][1], stickers[2][1])).append("\n");
                continue;
            }

            int[][] dp = new int[3][n + 1];
            dp[1][1] = stickers[1][1];
            dp[2][1] = stickers[2][1];
            dp[1][2] = stickers[2][1] + stickers[1][2];
            dp[2][2] = stickers[1][1] + stickers[2][2];

            for (int j = 3; j <= n; j++) {
                int max = Math.max(dp[1][j - 2], dp[2][j - 2]);
                dp[1][j] = Math.max(max, dp[2][j - 1]) + stickers[1][j];
                dp[2][j] = Math.max(max, dp[1][j - 1]) + stickers[2][j];
            }

            sb.append(Math.max(dp[1][n], dp[2][n])).append("\n");
        }

        System.out.println(sb.toString());
    }
}
