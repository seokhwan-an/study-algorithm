import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] numbers = new int[N];
        Set<Integer> check = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(input[i]);
            numbers[i] = num;
            check.add(num);
        }
        List<Integer> sorted = new ArrayList<>(check);
        Collections.sort(sorted);
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            int target = numbers[i];

            int start = 0;
            int end = sorted.size() - 1;
            while(start <= end) {
                int mid = (start + end) / 2;
                int find = sorted.get(mid);

                if (target == find) {
                    answer[i] = mid;
                    break;
                } else if (target < find) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
