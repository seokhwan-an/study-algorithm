import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int M = Integer.parseInt(info[0]);
        int N = Integer.parseInt(info[1]);

        int[] arr = new int[N];
        String[] cookieInput = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(cookieInput[i]);
        }
        Arrays.sort(arr);
        System.out.println(binarySearch(arr, M));
    }

    private static int binarySearch(int[] arr, int M) {
        int start = 1;
        int end = arr[arr.length - 1];

        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;

            for (int i = 0; i < arr.length; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt >= M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }
}
