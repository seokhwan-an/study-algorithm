import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] numbers;
    static int[] signs = new int[4];
    static int maxAnswer = Integer.MIN_VALUE;
    static int minAnswer = Integer.MAX_VALUE;
    static int[] calculateSigns;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        calculateSigns = new int[N - 1];
        String[] numberInputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(numberInputs[i]);
        }

        String[] signInputs = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            signs[i] = Integer.parseInt(signInputs[i]);
        }
        solution(0, N);
        System.out.println(maxAnswer + "\n" + minAnswer);
    }

    private static void solution(int k, int N) {
        if (k == N - 1) {
            int sum = calculate(N);
            if (sum > maxAnswer) {
                maxAnswer = sum;
            }
            if (sum < minAnswer) {
                minAnswer = sum;
            }
            return;
        }
        // 1 : +, 2 : -, 3 : x, 4 : %
        for (int i = 0; i < 4; i++) {
            int calculateSign = i + 1;
            if (signs[i] > 0) {
                signs[i]--;
                calculateSigns[k] = calculateSign;
                solution(k + 1 , N);
                signs[i]++;
                calculateSigns[k] = 0;
            }
        }
    }

    private static int calculate(int N) {
        int sum = numbers[0];
        for (int i = 0; i < N - 1; i++) {
            if (calculateSigns[i] == 1) {
                sum += numbers[i + 1];
            }
            if (calculateSigns[i] == 2) {
                sum -= numbers[i + 1];
            }
            if (calculateSigns[i] == 3) {
                sum *= numbers[i + 1];
            }
            if (calculateSigns[i] == 4) {
                if (sum < 0) {
                    sum *= -1;
                    sum /= numbers[i + 1];
                    sum *= -1;
                } else {
                    sum /= numbers[i + 1];
                }
            }
        }
        return sum;
    }
}
