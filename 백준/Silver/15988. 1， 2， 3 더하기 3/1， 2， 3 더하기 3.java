import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[1000001];

        int T = Integer.parseInt(br.readLine());
        int[] check = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());
            check[i] = input;
            max = Math.max(input, max);
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= max; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1_000_000_009;
        }

        StringBuilder sb = new StringBuilder();
        for (int c : check) {
            sb.append(dp[c]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
