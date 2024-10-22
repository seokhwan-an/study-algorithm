import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static boolean[] visited;
    static int[] number;
    static int[] cal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N];
            cal = new int[N];

            find(N - 1, 0, 0);
            System.out.println();
        }
    }

    private static void find(int n, int k, int s) {
        if (k == n) {
            // 계산 후 맞으면 출력
            if (isZero()) {
                StringBuilder sb = new StringBuilder();
                sb.append(number[1]);
                for (int i = 1; i <= n; i++) {
                    if (cal[i] == 2) {
                        sb.append("+").append(number[i + 1]);
                    }

                    if (cal[i] == 3) {
                        sb.append("-").append(number[i + 1]);
                    }

                    if (cal[i] == 1) {
                        sb.append(" ").append(number[i + 1]);
                    }
                }

                System.out.println(sb.toString());
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && i > s) {
                for (int j = 1; j <= 3; j++) {
                    if (j > cal[i]) {
                        visited[i] = true;
                        cal[i] = j;
                        find(n, k + 1, i);
                    }
                    visited[i] = false;
                    cal[i] = 0;
                }
            }
        }
    }

    private static boolean isZero() {
        init();
        int[] trans = update();
        int result = trans[1];
        int index = 2;
        for (int i = 1; i < N; i++) {
            if (cal[i] == 1) {
                continue;
            }

            if (cal[i] == 2) {
                result += trans[index];
            }

            if (cal[i] == 3) {
                result -= trans[index];
            }
            index++;
        }


        return result == 0;
    }

    private static void init() {
        number = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            number[i] = i;
        }
    }

    private static int[] update() {
        int cnt = 0;
        for (int i = 1; i < N; i++) {
            if (cal[i] == 1) {
                cnt++;
            }
        }

        if (cnt == 0) {
            return number;
        }
        int[] trans = new int[N + 1 - cnt];
        int index = 1;
        for (int i = 1; i < N; i++) {
            if (trans[index] == 0) {
                trans[index] = number[i];
            }
            if (cal[i] == 1) {
                int j = i;
                while(j < N) {
                    if (cal[j] != 1) {
                        j--;
                        break;
                    }

                    trans[index] = trans[index] * 10 + number[j + 1];
                    j++;
                }
                i = j;
            } else {
                index++;
                trans[index] = number[i + 1];
            }
        }

        return trans;
    }
}
