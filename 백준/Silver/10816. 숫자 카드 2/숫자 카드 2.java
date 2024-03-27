import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        String[] inputs = br.readLine().split(" ");

        for (String input : inputs) {
            numbers.add(Integer.parseInt(input));
        }

        numbers.sort((n1, n2) -> Integer.compare(n1, n2));

        int M = Integer.parseInt(br.readLine());
        String[] finds = br.readLine().split(" ");
        for (String find : finds) {
            final int start = leftBinarySearch(Integer.parseInt(find), numbers);
            final int end = rightBinarySearch(Integer.parseInt(find), numbers);
            sb.append(end - start).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static int leftBinarySearch(int find, List<Integer> numbers) {
        int start = 0;
        int end = numbers.size();

        while (start < end) {
            int mid = (start + end) / 2;
            int target = numbers.get(mid);

            if (target >= find) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int rightBinarySearch(int find, List<Integer> numbers) {
        int start = 0;
        int end = numbers.size();

        while (start < end) {
            int mid = (start + end) / 2;
            int target = numbers.get(mid);

            if (target > find) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
