import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        List<Integer>[] check = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            check[i] = new ArrayList<>();
        }
        dp[1] = 0;
        check[1].add(1);
        
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            check[i].addAll(check[i - 1]);
            check[i].add(i);

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                check[i].clear();
                check[i].addAll(check[i / 3]);
                check[i].add(i);
            }

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                check[i].clear();
                check[i].addAll(check[i / 2]);
                check[i].add(i);
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = check[N].size() - 1; i >= 0; i--) {
            sb.append(check[N].get(i)).append(" ");
        }

        System.out.println(dp[N]);
        System.out.println(sb.toString());
    }
}
