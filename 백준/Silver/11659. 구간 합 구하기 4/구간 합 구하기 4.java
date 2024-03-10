import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int[] numbers = new int[N + 1];

        String[] numberInputs = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(numberInputs[i - 1]);
        }

        int[] dp = new int[N + 1];
        dp[1] = numbers[1];
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + numbers[i];
        }

        for (int i = 0; i < M; i++) {
            String[] sumInputs = br.readLine().split(" ");
            int start = Integer.parseInt(sumInputs[0]);
            int end = Integer.parseInt(sumInputs[1]);
            sb.append(dp[end] - dp[start - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
