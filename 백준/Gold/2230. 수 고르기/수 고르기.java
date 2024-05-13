import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        int start = 0;
        int end = 1;
        int answer = Integer.MAX_VALUE;

        while(start <= end && end < N) {
            int number1 = numbers[start];
            int number2 = numbers[end];

            int diff = number2 - number1;

            if (diff < M) {
                end++;
            } else {
                answer = Math.min(answer, diff);
                start++;
            }
        }

        System.out.println(answer);
    }
}
