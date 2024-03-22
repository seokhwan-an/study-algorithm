import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int[] table;
    static int N;
    static List<Integer>[] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        map = new ArrayList[N + 1];
        table = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            String[] heightInfo = br.readLine().split(" ");
            int first = Integer.parseInt(heightInfo[0]);
            int second = Integer.parseInt(heightInfo[1]);
            table[second] += 1;
            map[first].add(second);
        }
        solution();
        System.out.println(sb.toString());
    }

    private static void solution() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (table[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int number = queue.poll();
            sb.append(number).append(" ");

            for (int i = 0; i < map[number].size(); i++) {
                int next = map[number].get(i);
                table[next] -= 1;
                if (table[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
