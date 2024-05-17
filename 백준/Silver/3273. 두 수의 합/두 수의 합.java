import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(numbers);
        int answer = 0;
        int start = 0;
        int end = n - 1;

        while(start != end) {
            int sum = numbers[start] + numbers[end];

            if (sum > x) {
                end--;
            } else {
                if (sum == x) {
                    answer++;
                }
                start++;
            }
        }

        System.out.println(answer);
    }
}
