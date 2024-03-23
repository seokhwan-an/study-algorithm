import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] day = new int[N + 2];
        int[] pay = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            String[] inputs = br.readLine().split(" ");
            day[i] = Integer.parseInt(inputs[0]);
            pay[i] = Integer.parseInt(inputs[1]);
        }

        int[] dp = new int[N + 2];
        int max = 0;
        for (int i = 1; i <= N + 1; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }

            int payDay = day[i] + i;

            if (payDay > N + 1) {
                continue;
            }
            dp[payDay] = Math.max(dp[payDay], max + pay[i]);

        }

        System.out.println(dp[N + 1]);
    }
}
