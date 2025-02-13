import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static int[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);

        int[][] sections = new int[E][3];
        nodes = new int[V + 1];
        Arrays.fill(nodes, -1);

        for (int i = 0; i < E; i++) {
            String[] sectionInput = br.readLine().split(" ");
            int node1 = Integer.parseInt(sectionInput[0]);
            int node2 = Integer.parseInt(sectionInput[1]);
            int cost = Integer.parseInt(sectionInput[2]);
            sections[i][0] = node1;
            sections[i][1] = node2;
            sections[i][2] = cost;
        }

        Arrays.sort(sections, Comparator.comparingInt(s -> s[2]));

        int answer = 0;
        int cnt = 0;

        for (int i = 0; i < E; i++) {
            int node1 = sections[i][0];
            int node2 = sections[i][1];
            int cost = sections[i][2];

            if (!isDiffGraph(node1, node2)) {
                continue;
            }
            answer += cost;
            cnt++;
            if (cnt == V - 1) {
                break;
            }
        }

        System.out.println(answer);
    }

    private static boolean isDiffGraph(int node1, int node2) {
        int u = find(node1);
        int v = find(node2);

        // 그룹이 같은 경우
        if (u == v) {
            return false;
        }
        // 두 정점 다 트리의 루트인 경우 어느 하나를 다른 그룹에 넣기 위함
        if (nodes[u] == nodes[v]) {
            nodes[u]--;
        }
        if (nodes[u] < nodes[v]) {
            nodes[v] = u;
        } else {
            nodes[u] = v;
        }
        return true;
    }

    private static int find(int node) {
        if (nodes[node] < 0) {
            return node;
        }
        return nodes[node] = find(nodes[node]);
    }
}