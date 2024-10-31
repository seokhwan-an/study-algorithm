import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] numbers = new int[N + 1];
        List<Integer>[] check = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            check[i] = new ArrayList<>();
            numbers[i] = Integer.parseInt(input[i - 1]);
        }
        int answer = 0;
        int index = 0;
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    if (dp[j] > max) {
                        max = dp[j];
                        check[i].clear();
                        check[i].addAll(check[j]);
                    }
                }
            }
            check[i].add(numbers[i]);
            dp[i] = max + 1;
            if (dp[i] > answer) {
                answer = dp[i];
                index = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : check[index]) {
            sb.append(num).append(" ");
        }
        System.out.println(answer);
        System.out.println(sb.toString());
    }
}
