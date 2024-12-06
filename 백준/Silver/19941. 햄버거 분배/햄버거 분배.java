import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int answer = 0;
        String[] line = br.readLine().split("");
        boolean[] eat = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (line[i].equals("P")) {
                for (int j = i - M; j <= i + M; j++) {
                    if (j < 0 || j >= N) {
                        continue;
                    }

                    if (line[j].equals("H") && !eat[j]) {
                        eat[j] = true;
                        answer++;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
