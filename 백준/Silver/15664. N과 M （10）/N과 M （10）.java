import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new HashSet<>();
    static int n;
    static int m;
    static int[] numbers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        numbers = new int[n];
        visited = new boolean[n];
        String[] numberInputs = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numberInputs[i]);
        }

        Arrays.sort(numbers);

        findAnswer(0);
        System.out.println(sb);
    }

    private static void findAnswer(int k) {
        if (k == m) {
            String find = getNumbers();
            if (!set.contains(find)) {
                set.add(find);
                sb.append(find).append("\n");
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                findAnswer(k + 1);
                visited[i] = false;
            }
        }
    }

    private static String getNumbers() {
        StringBuilder check = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                check.append(numbers[i]).append(" ");
            }
        }

        return check.toString();
    }
}
