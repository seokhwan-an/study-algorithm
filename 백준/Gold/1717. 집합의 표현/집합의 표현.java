import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        parent = new int[n + 1];
        Arrays.fill(parent, -1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] commandInput = br.readLine().split(" ");
            int command = Integer.parseInt(commandInput[0]);
            int x = Integer.parseInt(commandInput[1]);
            int y = Integer.parseInt(commandInput[2]);

            if (command == 1) {
                if (find(x) == find(y)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }

            if (command == 0) {
                union(x, y);
            }
        }

        System.out.println(sb.toString());
    }

    private static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        // 같은 트리에 속한 경우
        if (xRoot == yRoot) {
            return;
        }

        parent[yRoot] = xRoot;
    }

    private static int find(int x) {
        if (parent[x] < 0) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
