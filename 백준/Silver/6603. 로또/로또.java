import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] numbers;
    static int[] checker;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        while(inputs.length != 1) {
            n = Integer.parseInt(inputs[0]);
            numbers = new int[n];
            checker = new int[6];

            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(inputs[i + 1]);
            }

            sb = new StringBuilder();
            getLotto(0, -1);
            System.out.println(sb);

            inputs = br.readLine().split(" ");
        }
    }

    private static void getLotto(int k, int m) {
        if (k == 6) {
            sb.append(getOneLotto()).append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i > m) {
                checker[k] = numbers[i];
                getLotto(k + 1, i);
            }
        }
    }

    private static String getOneLotto() {
        StringBuilder stringMaker = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringMaker.append(checker[i]).append(" ");
        }
        return stringMaker.toString();
    }
}
