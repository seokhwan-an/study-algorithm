import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int answer = N;
        Map<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            map.put(word, false);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] writing = br.readLine().split(",");
            for (String target : writing) {
                if (map.containsKey(target)) {
                    if (!map.get(target)) {
                        map.put(target, true);
                        answer--;
                    }
                }

            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
