import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] numbers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(input[i - 1]);
        }
        int answer = 0;
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
