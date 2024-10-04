import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] map;
    static int[] check;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        map = new int[N];
        check = new int[M];
        visited = new boolean[N];


        for (int i = 0; i < N; i++) {
            map[i] = i + 1;
        }
        getAnswer(M, 0);

        System.out.println(sb.toString());
    }

    private static void getAnswer(int n, int k) {
        if (n == k) {
            for (int i = 0; i < k; i++) {
                sb.append(check[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                check[k] = map[i];
                getAnswer(n, k + 1);
                visited[i] = false;
            }
        }
    }
}
