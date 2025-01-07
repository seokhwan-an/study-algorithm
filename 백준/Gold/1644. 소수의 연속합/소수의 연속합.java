import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> primeNumbers = getPrimeNumbers(N);

        int answer = 0;
        int start = 0;
        int end = 0;
        int sum = 0;

        while (true) {
            if (sum == N) {
                answer += 1;
                sum -= primeNumbers.get(start++);
            } else if (sum > N) {
                sum -= primeNumbers.get(start++);
            } else {
               if (end >= primeNumbers.size()) {
                   break;
               }
               sum += primeNumbers.get(end++);
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
