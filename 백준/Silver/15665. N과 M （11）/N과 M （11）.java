import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int n;
    static int m;
    static int[] numbers;
    static int[] find;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        numbers = new int[n];
        find = new int[m];

        String[] numberInputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numberInputs[i]);
        }

        Arrays.sort(numbers);

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int k) {
        if (k == m) {
            String str = changeToString();

            if (!set.contains(str)) {
                set.add(str);
                sb.append(str).append("\n");
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            find[k] = numbers[i];
            dfs(k + 1);
            find[k] = 0;
        }
    }

    private static String changeToString() {
        StringBuilder stringMaker = new StringBuilder();
        for (int i = 0; i < m; i++) {
            stringMaker.append(find[i]).append(" ");
        }

        return stringMaker.toString();
    }
}
