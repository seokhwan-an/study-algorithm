import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int M;
    static int[] numbers;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[M];
        visited = new boolean[N];

        final String[] inputs = br.readLine().split(" ");
        numbers = new int[inputs.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(numbers);

        solution(0);
        System.out.println(sb);
    }

    private static void solution(int k) {
        if (k == M) {
            for (int number : arr) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                arr[k] = numbers[i];
                visited[i] = true;
                solution(k + 1);
                visited[i] = false;
            }
        }
    }
}
