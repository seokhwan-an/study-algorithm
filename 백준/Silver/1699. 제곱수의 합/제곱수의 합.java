import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[1] = 1;
        int check = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (isSquare(i)) {
                dp[i] = 1;
                check++;
                continue;
            }
            for (int j = 1; j <= check; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
            }
        }
        System.out.println(dp[n]);
    }

    private static boolean isSquare(int num) {
        return Math.sqrt(num) % 1 == 0;
    }
}
