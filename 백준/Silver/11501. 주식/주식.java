import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long answer = 0;
            int[] money = new int[N];
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int m = Integer.parseInt(input[j]);
                money[j] = m;
            }
            int start = money.length - 1;
            int big = money[start];
            start--;
            while (start >= 0) {
                if (money[start] <= big) {
                    answer += big - money[start];
                } else {
                    big = money[start];
                }
                start--;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
