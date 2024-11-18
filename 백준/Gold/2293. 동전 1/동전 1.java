import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] money = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = money[0]; j <= k; j++) {
                if (j < money[i]) {
                    continue;
                }
                dp[j] += dp[j - money[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
