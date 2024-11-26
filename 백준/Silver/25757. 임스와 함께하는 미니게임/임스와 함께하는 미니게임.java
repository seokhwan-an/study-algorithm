import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        String M = input[1];

        Map<String, Integer> game = new HashMap<>();
        game.put("Y", 1);
        game.put("F", 2);
        game.put("O", 3);

        int player = game.get(M);
        Set<String> checkDuplicate = new HashSet<>();
        int count = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String lineInput = br.readLine();
            if (checkDuplicate.contains(lineInput)) {
                continue;
            }
            checkDuplicate.add(lineInput);
            count++;

            if (player == count) {
                count = 0;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
