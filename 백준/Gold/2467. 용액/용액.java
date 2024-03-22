import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] fires = new int[N];
        int diff = Integer.MAX_VALUE;
        int fire1 = 0;
        int fire2 = 0;

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            fires[i] = Integer.parseInt(input[i]);
        }

        int start = 0;
        int end = N - 1;

        while (start != end) {
            int mix = fires[start] + fires[end];
            if (Math.abs(mix) < diff) {
                diff = Math.abs(mix);
                fire1 = fires[start];
                fire2 = fires[end];
            }

            if (mix >= 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(fire1 + " " + fire2);
    }
}
