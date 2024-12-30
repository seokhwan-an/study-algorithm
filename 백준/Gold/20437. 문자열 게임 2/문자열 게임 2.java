import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] word = br.readLine().split("");
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                sb.append("1 1").append("\n");
                continue;
            }
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < word.length; j++) {
                put(map, word[j]);
            }

            int Min = Integer.MAX_VALUE;
            int Max = 0;
            boolean find = false;
            for (int j = 0; j < word.length; j++) {
                String start = word[j];
                if (map.get(start) < K) {
                    continue;
                }
                int count = 1;
                for (int k = j + 1; k < word.length; k++) {
                    String next = word[k];
                    if (start.equals(next)) {
                        count++;
                    }
                    if (count == K) {
                        Min = Math.min(Min, k - j + 1);
                        Max = Math.max(Max, k - j + 1);
                        find = true;
                        break;
                    }
                }
            }
            if (find) {
                sb.append(Min).append(" ").append(Max).append("\n");
            } else {
                sb.append("-1").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void put(Map<String, Integer> map, String w) {
        if (map.containsKey(w)) {
            map.put(w, map.get(w) + 1);
        } else {
            map.put(w, 1);
        }
    }
}
