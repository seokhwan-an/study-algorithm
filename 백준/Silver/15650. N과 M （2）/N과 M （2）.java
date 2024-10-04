import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;
    static int[] check;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        check = new int[M];
        visited = new boolean[N + 1];

        getAnswer(M, 0, 0);

        System.out.println(sb.toString());
    }

    private static void getAnswer(int n, int k, int next) {
        if (n == k) {
            for (int i = 0; i < k; i++) {
                sb.append(check[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && i > next) {
                visited[i] = true;
                check[k] = i;
                getAnswer(n, k + 1, i);
                visited[i] = false;
            }
        }
    }
}
