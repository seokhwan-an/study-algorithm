import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        numbers = new int[N];
        arr = new int[M];

        final String[] numberInputs = br.readLine().split(" ");
        for (int i = 0; i < numberInputs.length; i++) {
            numbers[i] = Integer.parseInt(numberInputs[i]);
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
            arr[k] = numbers[i];
            solution(k + 1);
        }
    }
}
