import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] numbers;
    static boolean[] visited;
    static int[] arr;
    static Set<String> answers = new LinkedHashSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        numbers = new int[N];
        visited = new boolean[N];
        arr = new int[M];

        final String[] numberInputs = br.readLine().split(" ");

        for (int i = 0; i < numberInputs.length; i++) {
            numbers[i] = Integer.parseInt(numberInputs[i]);
        }
        Arrays.sort(numbers);

        solution(0);
        answers.forEach(System.out::println);
    }

    private static void solution(int k) {
        if (k == M) {
            StringBuilder sb = new StringBuilder();
            for (int number : arr) {
                sb.append(number).append(" ");
            }
            answers.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[k] = numbers[i];
                solution(k + 1);
                visited[i] = false;
            }
        }
    }
}
