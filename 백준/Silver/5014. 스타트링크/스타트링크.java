import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int F = Integer.parseInt(inputs[0]);
        int S = Integer.parseInt(inputs[1]);
        int G = Integer.parseInt(inputs[2]);
        int U = Integer.parseInt(inputs[3]);
        int D = Integer.parseInt(inputs[4]);

        visited = new int[F + 1];


        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        visited[S] = 1;
        int answer = -1;

        while (!queue.isEmpty()) {
            int stair = queue.poll();

            if (G == stair) {
                answer = visited[stair] - 1;
                break;
            }

            int up = stair + U;

            if (up <= F && visited[up] == 0) {
                visited[up] = visited[stair] + 1;
                queue.add(up);
            }

            int down = stair - D;

            if (down > 0 && visited[down] == 0) {
                visited[down] = visited[stair] + 1;
                queue.add(down);
            }
        }

        if (answer == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer);
        }
    }
}
