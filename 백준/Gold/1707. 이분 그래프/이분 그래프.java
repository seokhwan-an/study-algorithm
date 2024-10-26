import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static Map<Integer, List<Integer>> graph;
    static int[] colored;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            colored = new int[V + 1];
            graph = new HashMap<>();
            for (int j = 1; j <= V; j++) {
                graph.put(j, new ArrayList<>());
            }

            for (int j = 0; j < E; j++) {
                String[] edge = br.readLine().split(" ");
                int start = Integer.parseInt(edge[0]);
                int end = Integer.parseInt(edge[1]);
                graph.get(start).add(end);
                graph.get(end).add(start);
            }

            check = true;
            for (int j = 1; j <= V; j++) {
                if (!check) {
                    break;
                }

                if (colored[i] == 0) {
                    bfs(j, -1);
                }
            }

            if (check) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static void bfs(int start, int color) {
        List<Integer> nexts = graph.get(start);

        for (int next : nexts) {
            if (colored[next] == 0) {
                colored[next] = color * -1;
                bfs(next, color * -1);
            }

            if (colored[start] + colored[next] != 0) {
                check = false;
                break;
            }
        }
    }
}
