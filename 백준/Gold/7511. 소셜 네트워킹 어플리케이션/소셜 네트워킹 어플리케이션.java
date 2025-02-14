import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; i++) {
            int peopleCnt = Integer.parseInt(br.readLine());
            int[] graph = new int[peopleCnt];
            Arrays.fill(graph, - 1);

            int friendsCnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < friendsCnt; j++) {
                String[] friendInput= br.readLine().split(" ");
                int x = Integer.parseInt(friendInput[0]);
                int y = Integer.parseInt(friendInput[1]);
                union(x, y, graph);
            }

            int checkCnt = Integer.parseInt(br.readLine());
            sb.append("Scenario ").append(i).append(":").append("\n");
            for (int j = 0; j < checkCnt; j++) {
                String[] checkInput = br.readLine().split(" ");
                int x = Integer.parseInt(checkInput[0]);
                int y = Integer.parseInt(checkInput[1]);
                if (find(x, graph) == find(y, graph)) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void union(int x, int y, int[] graph) {
        int xRoot = find(x, graph);
        int yRoot = find(y, graph);

        if (xRoot == yRoot) {
            return;
        }

        graph[yRoot] = xRoot;
    }

    private static int find(int x, int[] graph) {
        if (graph[x] < 0) {
            return x;
        }

        return graph[x] = find(graph[x], graph);
    }
}
