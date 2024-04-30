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
    static int[] check;
    static Set<String> checker = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        numbers = new int[n];
        check = new int[m];

        String[] numberInputs = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numberInputs[i]);
        }

        Arrays.sort(numbers);

        dfs(0, -1);
        System.out.println(sb);
    }

    private static void dfs(int k, int j) {
        if (k == m) {
            String str = getStr();
            if (!checker.contains(str)) {
                checker.add(str);
                sb.append(str).append("\n");
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i >= j) {
                check[k] = numbers[i];
                dfs(k + 1, i);
            }
        }
    }

    private static String getStr() {
        StringBuilder stringMaker = new StringBuilder();

        for (int i = 0; i < m; i++) {
            stringMaker.append(check[i]).append(" ");
        }

        return stringMaker.toString();
    }
}
