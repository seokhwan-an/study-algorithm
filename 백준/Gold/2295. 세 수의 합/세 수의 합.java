import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> numbers;
    static Set<Integer> sum;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();
        sum = new HashSet<>();

        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }
        numbers.sort((n1, n2) -> Integer.compare(n1, n2));
        final List<Integer> sortedSum = getSum();
        getAnswer(sortedSum);
        System.out.println(answer);
    }

    private static List<Integer> getSum() {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                sum.add(numbers.get(i) + numbers.get(j));
            }
        }
        List<Integer> sorted = new ArrayList<>(sum);
        sorted.sort((n1, n2) -> Integer.compare(n1, n2));
        return sorted;
    }

    private static void getAnswer(List<Integer> sum) {
        for (int i = numbers.size() - 1; i >= 0; i--) {
            for (int j = numbers.size() - 1; j >= 0; j--) {
                int number = numbers.get(i) - numbers.get(j);
                if (Collections.binarySearch(sum, number) >= 0) {
                    answer = Math.max(answer, numbers.get(i));
                }
            }
        }
    }
}
