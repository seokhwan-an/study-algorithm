import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = Integer.MAX_VALUE;
        int N = Integer.parseInt(br.readLine());
        int[] number = new int[N];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(input[i]);
        }

        int start = 0;
        int end = N - 1;

        while (start != end) {
            int left = number[start];
            int right = number[end];
            int mix = left + right;

            if (Math.abs(mix) < Math.abs(answer)) {
                answer = mix;
            }

            if (mix >= 0) {
                end -= 1;
            } else {
                start += 1;
            }
        }
        System.out.println(answer);
    }
}
