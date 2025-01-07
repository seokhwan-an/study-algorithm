import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }
        List<Integer> primeNumbers = getPrimeNumbers(N);
        int answer = 0;

        int start = 0;
        int end = 1;

        // 초기 작업
        int sum = primeNumbers.get(start);
        if (sum == N) {
            answer += 1;
            System.out.println(answer);
            return;
        }
        sum += primeNumbers.get(end);

        while (start <= end && end < primeNumbers.size()) {
            if (sum <= N) {
                if (sum == N) {
                    answer += 1;
                }
                end++;
                if (end < primeNumbers.size()) {
                    sum += primeNumbers.get(end);
                }
            } else {
                sum -= primeNumbers.get(start++);
            }
        }

        System.out.println(answer);
    }

    private static List<Integer> getPrimeNumbers(int N) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }

        return primeNumbers;
    }

    private static boolean isPrime(int N) {
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                return false;
            }
        }

        return true;
    }
}
