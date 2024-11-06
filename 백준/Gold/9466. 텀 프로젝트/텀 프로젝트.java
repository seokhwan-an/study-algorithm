import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int find;
    static boolean[] visited;
    static boolean[] finished;
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            graph = new int[n + 1];
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                graph[j] = Integer.parseInt(input[j - 1]);
            }

            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            find = 0;

            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    dfs(j);
                }
            }

            sb.append(n - find).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int current) {
        visited[current] = true;
        int next = graph[current];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            findCycle(next);
        }

        finished[current] = true;
    }

    private static void findCycle(int start) {
        int node = start;
        do {
            find++;
            node = graph[node];
        } while (node != start);
    }
}
