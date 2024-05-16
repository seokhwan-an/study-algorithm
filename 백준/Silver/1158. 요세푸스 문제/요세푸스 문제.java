import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!queue.isEmpty()) {
            if (queue.size() == 1) {
                sb.append(queue.poll());
                break;
            }

            for (int i = 1; i < K; i++) {
                Integer number = queue.poll();
                queue.offer(number);
            }

            sb.append(queue.poll()).append(", ");
        }
        sb.append(">");

        System.out.println(sb);
    }
}
