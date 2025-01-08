import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int P = Integer.parseInt(input[2]);
        int X = Integer.parseInt(input[3]);

        int[] nums = getNum(X, K);

        int[][] map = {
            {1, 1, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 1, 1},
            {1, 0, 1, 1, 0, 0, 1},
            {1, 1, 0, 1, 0 ,1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {0, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1}
        };

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int[] target = getNum(i, K);
            int count = 0;
            boolean available = true;
            for (int j = 0; j < K; j++) {
                if (target[j] == nums[j]) {
                    continue;
                }
                int[] num1 = map[nums[j]];
                int[] num2 = map[target[j]];

                for (int k = 0; k < 7; k++) {
                    if (num1[k] != num2[k]) {
                        count++;
                    }
                }

                if (count > P) {
                    available = false;
                    break;
                }
            }
            if (available) {
                answer++;
            }
        }

        System.out.println(answer - 1);
    }

    private static int[] getNum(int num, int K) {
        int[] nums = new int[K];
        for (int i = K; i > 0; i--) {
            nums[i - 1] = num % 10;
            num /= 10;
        }

        return nums;
    }
}
