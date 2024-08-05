import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            String[] objects = br.readLine().split(" ");
            weights[i] = Integer.parseInt(objects[0]);
            values[i] = Integer.parseInt(objects[1]);
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= K; i++) { // 무게
            for (int j = 1; j <= N; j++) { // item
                dp[j][i] = dp[j - 1][i];
                if (i - weights[j] >= 0) {
                    dp[j][i] = Math.max(dp[j - 1][i], values[j] + dp[j - 1][i - weights[j]]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
