import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] loc = new int[M];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            loc[i] = Integer.parseInt(input[i]);
        }
        binarySearch(N, M, loc);
        System.out.println(answer);

    }

    private static void binarySearch(int N, int M, int[] loc) {
        int start = 1;
        int end = N;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (coverAll(N, M, loc, mid)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }

    private static boolean coverAll(int N, int M, int[] loc, int mid) {
        if (M == 1) {
            int left = loc[0] - mid;
            int right = loc[0] + mid;

            return left <= 0 && right >= N;
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < M; i++) {
            int stand = loc[i];
            if (i == 0) {
                left = stand - mid;
                if (left > 0) {
                    return false;
                }
                right = stand + mid;
            } else if (i < M - 1) {
                int nextLeft = stand - mid;
                if (nextLeft > right) {
                    return false;
                }
                right = stand + mid;
            } else {
                right = stand + mid;
                if (right < N) {
                    return false;
                }
            }
        }

        return true;
    }
}
