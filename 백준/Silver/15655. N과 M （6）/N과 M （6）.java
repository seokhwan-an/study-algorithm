import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        arr = new int[M];
        visited = new boolean[N];
        numbers = new int[N];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(numbers);

        solution(0, 0);
        System.out.println(sb);
    }

    private static void solution(int k, int pre) {
        if (k == M) {
            for (int number : arr) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && numbers[i] > pre) {
                arr[k] = numbers[i];
                visited[i] = true;
                solution(k + 1, numbers[i]);
                visited[i] = false;
            }
        }
    }
}
