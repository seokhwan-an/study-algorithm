import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] switches = new int[n];

        String[] initSwitchesInput = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            switches[i] = Integer.parseInt(initSwitchesInput[i]);
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int gender = Integer.parseInt(input[0]);
            int loc = Integer.parseInt(input[1]) - 1;

            if (gender == 1) {
                int change = loc;
                while (true) {
                    if (change > n - 1) {
                        break;
                    }

                    switches[change] = switches[change] == 1 ? 0 : 1;
                    change += (loc + 1);
                }
            }

            if (gender == 2) {
                int m = 0;
                while (true) {
                    if (loc - m < 0 || loc + m >= n) {
                        break;
                    }

                    if (switches[loc - m] != switches[loc + m]) {
                        break;
                    }

                    if (m == 0) {
                        switches[loc] = switches[loc] == 1 ? 0 : 1;
                        m++;
                        continue;
                    }
                    switches[loc - m] = switches[loc - m] == 1 ? 0 : 1;
                    switches[loc + m] = switches[loc + m] == 1 ? 0 : 1;
                    m++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 1; j < n + 1; j++) {
            if (j % 20 == 0) {
                sb.append(switches[j - 1]).append("\n");
                continue;
            }
            sb.append(switches[j - 1]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
