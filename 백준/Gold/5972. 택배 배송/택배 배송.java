import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static class Node {
        int next;
        int cow;

        public Node(int next, int cow) {
            this.next = next;
            this.cow = cow;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        List<List<Node>> map = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] road = br.readLine().split(" ");
            int from = Integer.parseInt(road[0]);
            int to = Integer.parseInt(road[1]);
            int cow = Integer.parseInt(road[2]);

            map.get(from).add(new Node(to, cow));
            map.get(to).add(new Node(from, cow));
        }

        System.out.println(dijkstra(map, N));
    }

    private static int dijkstra(List<List<Node>> map, int end) {
        Queue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.cow - n2.cow);
        int[] cowCount = new int[end + 1];
        Arrays.fill(cowCount, Integer.MAX_VALUE);
        cowCount[1] = 0;
        queue.offer(new Node(1, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.cow > cowCount[now.next]) {
                continue;
            }

            for (Node next : map.get(now.next)) {
                int newCowCount = cowCount[now.next] + next.cow;

                if (newCowCount < cowCount[next.next]) {
                    cowCount[next.next] = newCowCount;
                    queue.offer(new Node(next.next, newCowCount));
                }
            }
        }

        return cowCount[end];
    }
}
