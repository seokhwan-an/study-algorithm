import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        String[] names = new String[N];
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            String[] lineInput = br.readLine().split(" ");
            names[i] = lineInput[0];
            array[i] = Integer.parseInt(lineInput[1]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(br.readLine());
            int find = binarySearch(array, target);
            sb.append(names[find]).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int binarySearch(int[] array, int target) {
        int answer = 0;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= array[mid]) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
