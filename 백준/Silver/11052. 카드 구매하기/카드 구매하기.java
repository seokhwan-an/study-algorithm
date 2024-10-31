import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] pay = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            pay[i] = Integer.parseInt(input[i - 1]);
        }
        int[] dp = new int[n + 1];

        dp[1] = pay[1];
        dp[2] = Math.max(dp[1] * 2, pay[2]);
        for (int i = 3; i <= n; i++) {
            dp[i] = pay[i];
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
