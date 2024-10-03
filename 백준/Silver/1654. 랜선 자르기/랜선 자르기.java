import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input= br.readLine().split(" ");

        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int max = Integer.MIN_VALUE;

        int[] lan = new int[K];

        for (int i = 0; i < K; i++) {
            int lanLength = Integer.parseInt(br.readLine());
            if (lanLength > max) {
                max = lanLength;
            }
            lan[i] = lanLength;
        }

        Arrays.sort(lan);
        long start = 1;
        long end = max;
        while (start <= end) {
            long cnt = 0;
            long mid = (start + end) / 2;

            for (int i = 0; i < K; i++) {
                cnt += lan[i] / mid;
            }

            if (cnt >= N) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}
