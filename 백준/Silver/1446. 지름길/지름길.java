import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            String[] shortCut = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(shortCut[j]);
            }
        }

        int[] dp = new int[M + 1];

        for (int i = 0; i <= M; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= M; i++) {

            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            for (int j = 0; j < N; j++) {
                if (arr[j][1] == i) {
                    dp[i] = Math.min(dp[i], dp[arr[j][0]] + arr[j][2]);
                }
            }
        }

        System.out.println(dp[M]);

    }
}
