import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int vipCnt = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] vipPosition = new int[N + 1];

        for (int i = 0; i < vipCnt; i++) {
            int pos = Integer.parseInt(br.readLine());
            vipPosition[pos] = 1;
        }

        if (N == 1) {
            System.out.println(1);
            return;
        }

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        int answer = 1;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (vipPosition[i] == 1) {
                if (cnt > 0) {
                    answer *= dp[cnt];
                    cnt = 0;
                }
                continue;
            }
            cnt += 1;
        }

        if (cnt > 0) {
            answer *= dp[cnt];
        }

        System.out.println(answer);
    }
}
